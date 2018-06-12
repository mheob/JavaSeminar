package de.shd.day4.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
@SuppressWarnings({"WeakerAccess", "unused", "Duplicates"})
public class MapExercise
{
   public enum MapType
   {
      HASH_MAP, TREE_MAP
   }

   private Map<StallAnimal, Integer> stallAnimals;
   private Map<StallAnimal, Integer> stallAnimalsAsHash = new HashMap<>();
   private Map<StallAnimal, Integer> stallAnimalsAsTree = new TreeMap<>();

   /**
    * Die Instanzinierung inklusive der initialisierung einer Liste.
    */
   public MapExercise()
   {
   }

   /**
    * Die Instanzinierung inklusive der initialisierung einer Liste.
    *
    * @param mapType Die Art der Liste.
    */
   public MapExercise(MapType mapType)
   {
      initSet(mapType);
   }

   /**
    * Aufgabe 4 (1 + 2)
    * Erstellt eine Map mit einer bestimmten Anzahl an Stalltieren.
    *
    * @param mapType Die Art des Sets.
    */
   public void initSet(MapType mapType)
   {
      Map<StallAnimal, Integer> animals;

      switch( mapType )
      {
         case HASH_MAP:
            animals = stallAnimalsAsHash;
            break;
         case TREE_MAP:
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
            animals.put(new Cow("Kuh_" + (i + 1), (int) (Math.random() * 1000)), i);
         }
         else if( random <= 0.5 )
         {
            animals.put(new Pig("Schwein_" + (i + 1), (int) (Math.random() * 500)), i);
         }
         else if( random <= 0.75 )
         {
            animals.put(new Sheep("Schaf_" + (i + 1), (int) (Math.random() * 270)), i);
         }
         else
         {
            animals.put(new Dog("Hund_" + (i + 1), (int) (Math.random() * 150)), i);
         }
      }

      stallAnimals = animals;
   }

   public void getAnimalsFromHash()
   {
      for( StallAnimal key : stallAnimals.keySet() )
      {
         System.out.println("Key: " + key);
      }

      for( Integer value : stallAnimals.values() )
      {
         System.out.println("Value: " + value);
      }

      for( Map.Entry<StallAnimal, Integer> entry : stallAnimals.entrySet() )
      {
         System.out.println("Key: " + entry.getKey() + "\t|\tValue: " + entry.getValue());
      }
   }
}
