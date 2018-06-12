package de.shd.day3.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.shd.day3.animals.Cow;
import de.shd.day3.animals.Dog;
import de.shd.day3.animals.Pig;
import de.shd.day3.animals.Sheep;
import de.shd.day3.animals.StallAnimal;
import de.shd.day3.machine.CleaningMachine;
import de.shd.day3.machine.FeedMachine;
import de.shd.day3.machine.Machine;
import de.shd.day3.machine.SlaughterMachine;

/**
 * Ein drittes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 18.01.2017
 */
@SuppressWarnings("Duplicates")
public class MainDay3
{
   /**
    * Hauptprogramm.
    *
    * @param args Kommandozeilenparameter
    */
   public static void main(String[] args) throws IOException
   {
      System.out.println("Hausaufgaben:\n");
      initAnimalsFromMachine();
   }

   /**
    * Hausaufgaben:
    * <ul>
    * <li>Der Stall wurde um zwei zusätzliche Tiere (Schaf und Hund) erweitert.</li>
    * <li>Das Schaf ist in den Fütterprozess mit eingebunden worden.</li>
    * <li>Der Hund beißt nach dem Fütterprozess jedes andere Tier.</li>
    * <li>Durch die Bewegung verliert er an Gewicht.</li>
    * </ul>
    */
   private static void initAnimalsFromMachine() throws IOException
   {
      List<StallAnimal> stallAnimals = new ArrayList<>();

      for( int i = 0; i < 10; i++ )
      {
         double random = Math.random();

         if( random <= 0.25 )
         {
            stallAnimals.add(new Cow("Kuh_" + (i + 1), (int) (Math.random() * 1000)));
         }
         else if( random <= 0.5 )
         {
            stallAnimals.add(new Pig("Schwein_" + (i + 1), (int) (Math.random() * 500)));
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

      List<Machine> machines = new ArrayList<>();
      machines.add(new FeedMachine());
      machines.add(new SlaughterMachine());
      machines.add(new CleaningMachine());

      for( Machine machine : machines )
      {
         machine.work(stallAnimals);
      }
   }
}
