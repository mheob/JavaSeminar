package de.shd.day4.exercises;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import de.shd.day4.animals.Cow;
import de.shd.day4.animals.Dog;
import de.shd.day4.animals.Pig;
import de.shd.day4.animals.Sheep;
import de.shd.day4.animals.StallAnimal;

/**
 * Ein viertes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 25.01.2017
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SetsExercise
{
   public enum SetType
   {
      HASH_SET, TREE_SET, NONE
   }

   private Set<StallAnimal> stallAnimals;
   private Set<StallAnimal> stallAnimalsAsHash = new HashSet<>();
   private Set<StallAnimal> stallAnimalsAsTree = new TreeSet<>();

   /**
    * Die Instanzinierung inklusive der initialisierung einer Liste.
    */
   public SetsExercise()
   {
   }

   /**
    * Die Instanzinierung inklusive der initialisierung einer Liste.
    *
    * @param setType Die Art der Liste.
    */
   public SetsExercise(SetType setType)
   {
      initSet(setType);
   }

   /**
    * Aufgabe 3 (1)
    * Erstellt eine Liste mit einer bestimmten Anzahl an Stalltieren.
    *
    * @param setType Die Art des Sets.
    */
   public void initSet(SetType setType)
   {
      Set<StallAnimal> animals;

      switch( setType )
      {
         case HASH_SET:
            animals = stallAnimalsAsHash;
            break;
         case TREE_SET:
            animals = stallAnimalsAsTree;
            break;
         default:
            animals = stallAnimals;
      }

      for( int i = 0; i < 10; i++ )
      {
         double random = Math.random();

         if( random <= 0.25 )
         {
            animals.add(new Cow("Kuh_" + (i + 1), (int) (Math.random() * 1000)));
         }
         else if( random <= 0.5 )
         {
            animals.add(new Pig("Schwein_" + (i + 1), (int) (Math.random() * 500)));
         }
         else if( random <= 0.75 )
         {
            animals.add(new Sheep("Schaf_" + (i + 1), (int) (Math.random() * 270)));
         }
         else
         {
            animals.add(new Dog("Hund_" + (i + 1), (int) (Math.random() * 150)));
         }
      }

      stallAnimals = animals;
   }

   /**
    * Aufgabe 3 (2)
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
    * Aufgabe 3 (3)
    * Überschreibt die Sets.
    */
   public void setAnimalsAgain()
   {
      initSet(SetType.NONE);
      System.out.println("Anzahl der Elemente in der Liste: " + stallAnimals.size());
   }
}
