package de.shd.day4.exercises;

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
@SuppressWarnings("unused")
public class ArrayExercise
{
   /**
    * Aufgabe 1 (1 + 2)
    * Gibt 100 Tiere mit Hilfe einer For(Each)-Schleife zurück.
    *
    * @param isForEach <c>true</c>, wenn ForEach-Schleife und <c>false</c>, wenn For-Schleife.
    */
   public void getAnimalsPerLoop(boolean isForEach)
   {
      StallAnimal[] stallAnimals = new StallAnimal[100];

      for( int i = 0; i < 100; i++ )
      {
         double random = Math.random();

         if( random <= 0.25 )
         {
            stallAnimals[i] = new Cow("Kuh_" + (i + 1), (int) (Math.random() * 1000));
         }
         else if( random <= 0.5 )
         {
            stallAnimals[i] = new Pig("Schwein_" + (i + 1), (int) (Math.random() * 500));
         }
         else if( random <= 0.75 )
         {
            stallAnimals[i] = new Sheep("Schaf_" + (i + 1), (int) (Math.random() * 300));
         }
         else
         {
            stallAnimals[i] = new Dog("Hund_" + (i + 1), (int) (Math.random() * 100));
         }
      }

      if( isForEach )
      {
         //noinspection ForLoopReplaceableByForEach
         for( int i = 0; i < stallAnimals.length; i++ )
         {
            System.out.println(stallAnimals[i].getName());
         }
      }
      else
      {
         for( StallAnimal animal : stallAnimals )
         {
            System.out.println(animal.getName());
         }
      }
   }

   /**
    * Aufgabe 1 (3 + 4)
    * Erstellt ein 2-dimensionales Array und gibt es aus.
    */
   public void twoDimensionArray()
   {
      char[][] asteriskArray = new char[10][10];

      for( int i = 0; i < asteriskArray.length; i++ )
      {
         for( int j = 0; j < asteriskArray[i].length; j++ )
         {
            asteriskArray[i][j] = '*';
            System.out.print(asteriskArray[i][j]);
         }

         System.out.println();
      }

      System.out.println("\n");

      for( int i = 0; i < asteriskArray.length; i++ )
      {
         for( int j = 0; j < asteriskArray[i].length; j++ )
         {
            if( i == 0 || i == asteriskArray.length - 1
                || ((i > 0 && i < asteriskArray.length)
                    && (j == 0 || j == asteriskArray[i].length - 1)) )
            {
               asteriskArray[i][j] = '*';
            }
            else
            {
               asteriskArray[i][j] = ' ';
            }

            System.out.print(asteriskArray[i][j]);
         }

         System.out.println();
      }
   }
}
