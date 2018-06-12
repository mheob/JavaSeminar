package de.shd.day2.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import de.shd.day2.animals.Cow;
import de.shd.day2.animals.Dog;
import de.shd.day2.animals.Pig;
import de.shd.day2.animals.Sheep;
import de.shd.day2.animals.StallAnimal;
import de.shd.day2.machine.FeedMachine;

/**
 * Ein zweites Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 13.01.2017
 */
public class MainDay2
{
   /**
    * Hauptprogramm.
    *
    * @param args Kommandozeilenparameter
    */
   public static void main(String[] args) throws IOException, InterruptedException
   {
      //// Aufgabe 1
      //System.out.println("Aufgaben 1:\n");
      //initAnimals();
      //Helper.spacer();
      //
      //// Aufgabe 2
      //System.out.println("Aufgabe 2:\n");
      //init10Animals();
      //Helper.spacer();
      //
      //// Aufgabe 3
      //System.out.println("Aufgabe 3:\n");
      //initAnimalsFromMachine();
      ////Helper.spacer();

      // Hausaufgaben
      System.out.println("Hausaufgaben:\n");
      initAnimalsFromMachineWWithAnDog();
   }

   /**
    * Aufgabe 1:
    * Erstellt je eine Kuh und ein Schwein. Zudem lässt es sie feed und je nach Art muhen oder suhlen.
    */
   private static void initAnimals()
   {
      Cow cow = new Cow("Lila", 85);
      cow.muh();
      cow.eat();

      System.out.println();

      Pig pig = new Pig("Oink", 40);
      pig.suhlen();
      pig.eat();
   }

   /**
    * Aufgabe 2:
    * Erstellt und gibt 10 Random Tiere aus, lässt sie feed und je nach Art muhen oder suhlen.
    */
   private static void init10Animals() throws InterruptedException
   {
      boolean isFirst = true, isLast;
      ArrayList<StallAnimal> stallAnimals = new ArrayList<>();

      for( int i = 0; i < 10; i++ )
      {
         stallAnimals.add(new Random().nextInt() % 2 == 0 ? new Cow("Kuh_" + (i + 1), 50) : new Pig("Schwein_" + (i + 1), 35));
      }

      for( StallAnimal stallAnimal : stallAnimals )
      {
         isLast = stallAnimals.indexOf(stallAnimal) == stallAnimals.size() - 1;

         if( isFirst )
         {
            System.out.println("Das erste Tier hat den Namen:\t" + stallAnimal.getName() + ".");
            isFirst = false;
         }
         else if( isLast )
         {
            System.out.println("Das letzte Tier hat den Namen:\t" + stallAnimal.getName() + ".");
         }
         else
         {
            System.out.println("Das aktuelle Tier heißt:\t\t" + stallAnimal.getName() + ".");
         }

         stallAnimal.eat();

         if( stallAnimal instanceof Cow )
         {
            ((Cow) stallAnimal).muh();
         }
         else //if( stallAnimal instanceof Pig )
         {
            ((Pig) stallAnimal).suhlen();
         }

         Thread.sleep(500);

         if( isLast )
         {
            break;
         }

         System.out.println("\n\t---\n");
      }
   }

   /**
    * Aufgabe 3:
    * Erstellt und gibt 10 Random Tiere mit Hilfe des Futterautomaten aus, lässt sie feed und je nach Art muhen oder suhlen.
    */
   private static void initAnimalsFromMachine() throws InterruptedException
   {
      boolean isFirst = true, isLast;
      FeedMachine feedMachine = new FeedMachine();
      ArrayList<StallAnimal> stallAnimals = new ArrayList<>();

      for( int i = 0; i < 10; i++ )
      {
         stallAnimals.add(new Random().nextInt() % 2 == 0 ? new Cow("Kuh_" + (i + 1), 50) : new Pig("Schwein_" + (i + 1), 35));
      }

      for( StallAnimal stallAnimal : stallAnimals )
      {
         isLast = stallAnimals.indexOf(stallAnimal) == stallAnimals.size() - 1;

         if( isFirst )
         {
            isFirst = false;
            System.out.println("Das erste Tier hat den Namen:\t" + stallAnimal.getName() + ".");
         }
         else if( isLast )
         {
            System.out.println("Das letzte Tier hat den Namen:\t" + stallAnimal.getName() + ".");
         }
         else
         {
            System.out.println("Das aktuelle Tier heißt:\t\t" + stallAnimal.getName() + ".");
         }

         if( stallAnimal instanceof Cow )
         {
            feedMachine.feed(StallAnimal.Animal.COW, stallAnimal.animalNameText(StallAnimal.Animal.COW, stallAnimal.getName()), stallAnimal.getWeight());
            ((Cow) stallAnimal).muh();
         }
         else //if( stallAnimal instanceof Pig )
         {
            feedMachine.feed(StallAnimal.Animal.PIG, stallAnimal.animalNameText(StallAnimal.Animal.PIG, stallAnimal.getName()), stallAnimal.getWeight());
            ((Pig) stallAnimal).suhlen();
         }

         Thread.sleep(500);

         if( isLast )
         {
            break;
         }

         System.out.println("\n\t---\n");
      }
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
   private static void initAnimalsFromMachineWWithAnDog() throws InterruptedException
   {
      FeedMachine feedMachine = new FeedMachine();
      ArrayList<StallAnimal> stallAnimals = new ArrayList<>();

      for( int i = 0; i < 10; i++ )
      {
         double random = Math.random();

         if( random < 0.25 )
         {
            stallAnimals.add(new Cow("Kuh_" + (i + 1), 50));
         }
         else if( random < 0.5 )
         {
            stallAnimals.add(new Pig("Schwein_" + (i + 1), 35));
         }
         else if( random < 0.75 )
         {
            stallAnimals.add(new Sheep("Schaf_" + (i + 1), 20));
         }
         else
         {
            stallAnimals.add(new Dog("Hund_" + (i + 1), 10));
         }
      }

      feedMachine.feed(stallAnimals);
   }
}
