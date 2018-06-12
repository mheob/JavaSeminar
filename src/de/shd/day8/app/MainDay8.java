package de.shd.day8.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;

import de.shd.day8.animals.Animal;
import de.shd.day8.animals.Cow;
import de.shd.day8.animals.Dog;
import de.shd.day8.animals.Gender;
import de.shd.day8.animals.Pig;
import de.shd.day8.animals.Sheep;
import de.shd.day8.animals.StallAnimal;
import de.shd.day8.dao.StallDAO;
import de.shd.day8.machine.BreedingMachine;
import de.shd.day8.machine.FeedMachine;
import de.shd.day8.machine.Machine;
import de.shd.day8.machine.SlaughterMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein achtes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.03.2017
 */
@SuppressWarnings("Duplicates")
public class MainDay8
{
   private static final Logger LOG = LogManager.getLogger(MainDay8.class);
   private static final StallDAO DAO = new StallDAO();

   private static File stallFile;
   private static List<StallAnimal> stallAnimals = new ArrayList<>();
   private static File stallFileToSave;

   private MainDay8()
   {
   }

   /**
    * Hauptprogramm.
    *
    * @param args Kommandozeilenparameter
    */
   public static void main(String[] args)
   {
      LOG.info("application started");

      //// Aufgabe 2:
      //startAppForTask2();

      // Aufgabe 3:
      startAppForTask3();

      // Aufgabe 1:
      //ExerciseInterface ei = new ExerciseInterface()
      //{
      //   @Override
      //   public void MethodA(String sParam, int add1, int add2)
      //   {
      //      LOG.info(sParam + (add1 + add2));
      //   }
      //};
      //ExerciseInterface ei = (sParam, add1, add2) -> LOG.info(sParam + (add1 + add2));
      //
      //ExerciseClass.MethodB(ei, ">>> Mein Ergebnis von 3 + 6 ist gleich ", 3, 6);

      Runtime.getRuntime().addShutdownHook(new Thread(() -> LOG.info("application closed\n-----")));
   }

   private static void startAppForTask2()
   {
      // Aufgabe 1:
      String ext = "csv";
      String ext2 = "xml";
      String ext3 = "json";

      String fileNew = "\\resources\\ExerciseFiles\\day8\\stall_new.";
      stallFile = new File(Paths.get("").toAbsolutePath().toString() + "\\resources\\ExerciseFiles\\day8\\stall." + ext);
      stallFileToSave = new File(Paths.get("").toAbsolutePath().toString() + fileNew + ext);

      if( !stallFile.exists() )
      {
         createFile();
      }
      else
      {
         getAnimals();
      }

      // Regelt die Arbeiten der Maschinen.
      doMachineJobs();

      // Speichert die Daten wieder zurück in die Datei.
      saveDataInFile();

      DAO.convertFile(stallFileToSave, new File(Paths.get("").toAbsolutePath().toString() + fileNew + ext2));
      DAO.convertFile(stallFileToSave, new File(Paths.get("").toAbsolutePath().toString() + fileNew + ext3));
   }

   private static void startAppForTask3()
   {
      // Füllt die Liste mit Tieren.
      fillFile(false);

      stallAnimals.stream()
            .filter(x -> x.getWeight() >= Animal.ANIMAL.getSlaughterWeight())
            .peek(x -> x.setName(x.getName().toUpperCase()))
            .sorted().forEachOrdered(System.out::println);

      //stallAnimals = getSorted().collect(Collectors.toList());

      // Regelt die Arbeiten der Maschinen.
      //doMachineJobs();

      //stallAnimals.forEach(System.out::println);
   }

   private static Stream<StallAnimal> getSorted()
   {
      return stallAnimals.stream().sorted((o1, o2) ->
      {
         if( o1.getWeight() < o2.getWeight() )
         {
            return -1;
         }
         else if( o1.getWeight() > o2.getWeight() )
         {
            return 1;
         }
         else
         {
            return 0;
         }
      });
   }

   /**
    * Erstellt die Datei.
    */
   private static void createFile()
   {
      try
      {
         if( stallFile.createNewFile() )
         {
            LOG.info("Die Datei wurde erstellt.");
            fillFile(true);
            LOG.info("Die Datei wurde mit zufälligen Tieren beschrieben.");
         }
      }
      catch(IOException e)
      {
         LOG.error("Die Datei konnte nicht erstellt werden: " + e);
      }
   }

   /**
    * Füllt die Datei mit zufälligen Tieren.
    */
   private static void fillFile(boolean isFile)
   {
      for( int i = 0; i < 50; i++ )
      {
         Random random = new Random();
         Gender gender = random.nextInt(10) < 5 ? Gender.FEMALE : Gender.MALE;

         if( random.nextInt(4) < 1 )
         {
            stallAnimals.add(new Cow("Kuh_" + (i + 1), new Random().nextInt(300), gender));
         }
         else if( random.nextInt(4) < 2 )
         {
            stallAnimals.add(new Pig("Schwein_" + (i + 1), new Random().nextInt(350), gender));
         }
         else if( random.nextInt(4) < 3 )
         {
            stallAnimals.add(new Sheep("Schaf_" + (i + 1), new Random().nextInt(200), gender));
         }
         else
         {
            stallAnimals.add(new Dog("Hund_" + (i + 1), new Random().nextInt(250), gender));
         }
      }

      if( isFile )
      {
         DAO.writeData(stallFile, stallAnimals);
      }
   }

   /**
    * Holt die Tiere aus der Liste.
    */
   private static void getAnimals()
   {
      stallAnimals = DAO.readData(stallFile);
   }

   /**
    * Führt die Arbeiten der Maschinen durch.
    */
   private static void doMachineJobs()
   {
      List<Machine> machines = new ArrayList<>();
      machines.add(new FeedMachine());
      machines.add(new SlaughterMachine());
      machines.add(new BreedingMachine());

      machines.parallelStream().forEach(getMachineConsumer());
   }

   private static Consumer<Machine> getMachineConsumer()
   {
      return machine ->
      {
         machine.work(stallAnimals);
         machine.cleaning(stallAnimals);
      };
   }

   /**
    * Speichert die Daten in eine Datei.
    */
   private static void saveDataInFile()
   {
      DAO.writeData(stallFileToSave, stallAnimals);
   }
}
