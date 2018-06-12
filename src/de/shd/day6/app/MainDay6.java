package de.shd.day6.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.shd.day6.animals.Cow;
import de.shd.day6.animals.Dog;
import de.shd.day6.animals.Gender;
import de.shd.day6.animals.Pig;
import de.shd.day6.animals.Sheep;
import de.shd.day6.animals.StallAnimal;
import de.shd.day6.dao.StallDAO;
import de.shd.day6.machine.BreedingMachine;
import de.shd.day6.machine.FeedMachine;
import de.shd.day6.machine.Machine;
import de.shd.day6.machine.SlaughterMachine;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
public class MainDay6
{
   private static final Logger LOGGER = Logger.getLogger(MainDay6.class.getName());
   private static final StallDAO DAO = new StallDAO();

   private static File stallFile;
   private static List<StallAnimal> stallAnimals = new ArrayList<>();
   private static File stallFileToSave;

   private MainDay6()
   {
   }

   /**
    * Hauptprogramm.
    *
    * @param args Kommandozeilenparameter
    */
   public static void main(String[] args)
   {
      // Aufgabe 1:
      String ext = "csv";
      String ext2 = "xml";
      String ext3 = "json";

      String fileNew = "\\resources\\ExerciseFiles\\day6\\stall_new.";
      stallFile = new File(Paths.get("").toAbsolutePath().toString() + "\\resources\\ExerciseFiles\\day6\\stall." + ext);
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

   /**
    * Erstellt die Datei.
    */
   private static void createFile()
   {
      try
      {
         if( stallFile.createNewFile() )
         {
            LOGGER.log(Level.INFO, "Die Datei wurde erstellt.");
            fillFile();
            LOGGER.log(Level.INFO, "Die Datei wurde mit zufälligen Tieren beschrieben.");
         }
      }
      catch(IOException e)
      {
         LOGGER.log(Level.SEVERE, "Die Datei konnte nicht erstellt werden", e);
      }
   }

   /**
    * Füllt die Datei mit zufälligen Tieren.
    */
   private static void fillFile()
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

      DAO.writeData(stallFile, stallAnimals);
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

      for( Machine machine : machines )
      {
         stallAnimals = machine.work(stallAnimals);
      }
   }

   /**
    * Speichert die Daten in eine Datei.
    */
   private static void saveDataInFile()
   {
      DAO.writeData(stallFileToSave, stallAnimals);
   }
}
