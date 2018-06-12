package de.shd.day5.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import de.shd.day5.animals.Cow;
import de.shd.day5.animals.Dog;
import de.shd.day5.animals.Pig;
import de.shd.day5.animals.Sheep;
import de.shd.day5.animals.StallAnimal;
import de.shd.day5.dao.StallDAO;
import de.shd.day5.machine.FeedMachine;
import de.shd.day5.machine.Machine;
import de.shd.day5.machine.SlaughterMachine;

/**
 * Ein fünftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
 */
@SuppressWarnings("Duplicates")
public class MainDay5
{
   private static File stallFile;
   private static File stallFileTest;
   private static List<StallAnimal> stallAnimals = new ArrayList<>();
   private static StallDAO dao = new StallDAO();

   /**
    * Hauptprogramm.
    *
    * @param args Kommandozeilenparameter
    */
   public static void main(String[] args)
   {
      //// Aufgabe 1:
      //ExceptionsExercise ee = new ExceptionsExercise();
      //
      ////ee.calcTryCatch();
      //
      //try
      //{
      //   ee.calcThrows();
      //}
      //catch(ArithmeticException e)
      //{
      //   System.out.println("Arithmetischer Fehler: ");
      //   e.printStackTrace();
      //}
      //catch(Exception e)
      //{
      //   System.out.println("Allgemeiner Fehler: ");
      //   e.printStackTrace();
      //}
      //
      //// Aufgabe 2:
      //FileProcExercise fpe = new FileProcExercise();
      //
      //String currentPath = Paths.get("").toAbsolutePath().toString() + "\\";
      //String storeDirectory = "resources\\ExerciseFiles\\";
      //
      //File stallFile = new File(storeDirectory + "2017-02-01-aufgabe-2.txt");
      //
      //try
      //{
      //   fpe.createFile(stallFile);
      //   fpe.writeFile(stallFile);
      //   fpe.readFile(stallFile);
      //}
      //catch(IOException e)
      //{
      //   e.getMessage();
      //}
      @SuppressWarnings("unused") final boolean SEPARATOR_ONLY; // TODO: kann wieder gelöscht werden.

      String ext = "csv";
      //String ext = "xml";
      //String ext = "json";
      //String ext2 = "csv";
      String ext2 = "xml";
      //String ext2 = "json";
      //String ext3 = "csv";
      //String ext3 = "xml";
      String ext3 = "json";

      stallFile = new File(Paths.get("").toAbsolutePath().toString() + "\\resources\\ExerciseFiles\\day5\\stall." + ext);
      stallFileTest = new File(Paths.get("").toAbsolutePath().toString() + "\\resources\\ExerciseFiles\\day5\\stall_new." + ext);

      //// Aufgabe 3 + 4, sowie die Hausaufgaben
      //// Läd die gewünschten Daten.
      //// Es wird die benötigte Datei erzeugt, falls sie noch nicht vorhanden ist.
      //if( !stallFile.exists() )
      //{
      //   createFile();
      //}
      //else
      //{
      //   getAnimals();
      //}
      //
      //// Regelt die Arbeiten der Maschinen.
      //doMachineJobs();
      //
      //// Speichert die Daten wieder zurück in die Datei.
      //saveDataInFile();

      dao.convertFile(stallFile, new File(Paths.get("").toAbsolutePath().toString() + "\\resources\\ExerciseFiles\\day5\\stall_converter." + ext2));
      dao.convertFile(stallFile, new File(Paths.get("").toAbsolutePath().toString() + "\\resources\\ExerciseFiles\\day5\\stall_converter." + ext3));
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
            System.out.println("Die Datei wurde erstellt.");
            fillFile();
            System.out.println("Die Datei wurde mit zufälligen Tieren beschrieben.");
         }
      }
      catch(IOException e)
      {
         e.getMessage();
      }
   }

   /**
    * Füllt die Datei mit zufälligen Tieren.
    */
   private static void fillFile()
   {
      for( int i = 0; i < 50; i++ )
      {
         double random = Math.random();

         if( random <= 0.25 )
         {
            stallAnimals.add(new Cow("Kuh_" + (i + 1), (int) (Math.random() * 1010)));
         }
         else if( random <= 0.5 )
         {
            stallAnimals.add(new Pig("Schwein_" + (i + 1), (int) (Math.random() * 520)));
         }
         else if( random <= 0.75 )
         {
            stallAnimals.add(new Sheep("Schaf_" + (i + 1), (int) (Math.random() * 300)));
         }
         else
         {
            stallAnimals.add(new Dog("Hund_" + (i + 1), (int) (Math.random() * 100)));
         }
      }

      dao.writeData(stallFile, stallAnimals);
   }

   /**
    * Holt die Tiere aus der Liste.
    */
   private static void getAnimals()
   {
      stallAnimals = dao.readData(stallFile);
   }

   /**
    * Führt die Arbeiten der Maschinen durch.
    */
   private static void doMachineJobs()
   {
      List<Machine> machines = new ArrayList<>();
      machines.add(new FeedMachine());
      machines.add(new SlaughterMachine());

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
      dao.writeData(stallFileTest, stallAnimals);
   }
}
