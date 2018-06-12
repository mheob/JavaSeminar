package de.shd.day4.exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import de.shd.day4.animals.Cow;
import de.shd.day4.animals.Dog;
import de.shd.day4.animals.Pig;
import de.shd.day4.animals.Sheep;
import de.shd.day4.animals.StallAnimal;
import de.shd.utils.StopWatch;

/**
 * Ein viertes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 25.01.2017
 */
@SuppressWarnings({"SameParameterValue", "unused", "WeakerAccess"})
public class ListExercise
{
   public enum ListType
   {
      ARRAY_LIST, VECTOR, LINKED_LIST
   }

   private List<StallAnimal> stallAnimals;

   /**
    * Die Instanzinierung inklusive der initialisierung einer Liste.
    */
   public ListExercise()
   {
   }

   /**
    * Die Instanzinierung inklusive der initialisierung einer Liste.
    *
    * @param countAnimals Die Anzahl der erzeugten Tiere.
    * @param listType     Die Art der Liste.
    */
   public ListExercise(int countAnimals, ListType listType)
   {
      initList(countAnimals, listType);
   }

   /**
    * Aufgabe 2 (1)
    * Erstellt eine Liste mit einer bestimmten Anzahl an Stalltieren.
    *
    * @param countAnimals Die Anzahl der erzeugten Tiere.
    * @param listType     Die Art der Liste.
    */
   public void initList(int countAnimals, ListType listType)
   {
      switch( listType )
      {
         case ARRAY_LIST:
            stallAnimals = new ArrayList<>();
            break;
         case VECTOR:
            stallAnimals = new Vector<>();
            break;
         case LINKED_LIST:
            stallAnimals = new LinkedList<>();
            break;
      }

      for( int i = 0; i < countAnimals; i++ )
      {
         double random = Math.random();

         if( random <= 0.25 )
         {
            stallAnimals.add(new Cow("Kuh_" + (i + 1), (int) (Math.random() * 2000)));
         }
         else if( random <= 0.5 )
         {
            stallAnimals.add(new Pig("Schwein_" + (i + 1), (int) (Math.random() * 510)));
         }
         else if( random <= 0.75 )
         {
            stallAnimals.add(new Sheep("Schaf_" + (i + 1), (int) (Math.random() * 250)));
         }
         else
         {
            stallAnimals.add(new Dog("Hund_" + (i + 1), (int) (Math.random() * 150)));
         }
      }
   }

   /**
    * Aufgabe 2 (2)
    * Gibt alle Tiere auf der Konsole zurück.
    */
   public void getAnimalsFromList()
   {
      for( StallAnimal animal : stallAnimals )
      {
         System.out.println(animal);
      }
   }

   /**
    * Aufgabe 2 (3)
    * Gibt je 5 Tiere vom Anfang, der Mitte und dem Ende zurück.
    *
    * @param listType Die Art der Liste.
    */
   public void removeAnimalsManual(String listType)
   {
      StopWatch sw = new StopWatch();

      sw.start();
      stallAnimals.remove(0);
      stallAnimals.remove(1);
      stallAnimals.remove(2);
      stallAnimals.remove(3);
      stallAnimals.remove(4);
      System.out.println(sw.stop("Zeit Anfang (" + listType + "):\t\t"));

      sw.start();
      stallAnimals.remove(48_000);
      stallAnimals.remove(49_000);
      stallAnimals.remove(50_000);
      stallAnimals.remove(51_000);
      stallAnimals.remove(52_000);
      System.out.println(sw.stop("Zeit Mitte (" + listType + "):\t\t"));

      sw.start();
      stallAnimals.remove(stallAnimals.size() - 5);
      stallAnimals.remove(stallAnimals.size() - 4);
      stallAnimals.remove(stallAnimals.size() - 3);
      stallAnimals.remove(stallAnimals.size() - 2);
      stallAnimals.remove(stallAnimals.size() - 1);
      System.out.println(sw.stop("Zeit Ende (" + listType + "):\t\t"));
   }
}
