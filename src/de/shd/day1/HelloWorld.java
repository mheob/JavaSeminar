package de.shd.day1;

import java.io.IOException;

/**
 * Ein erstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 04.01.2017
 */
@SuppressWarnings("SameParameterValue")
public class HelloWorld
{
   /**
    * Hauptprogramm.
    *
    * @param args Kommandozeilenparameter
    * @throws IOException eine falsche Eingabe könnte eine Exception werfen
    */
   public static void main(String[] args) throws IOException
   {
      // Aufgabe 1
      System.out.println("Aufgabe 1:\n");
      loopSpec5();

      // Aufgabe 2 + 3
      System.out.println("Aufgaben 2 + 3:\n");
      firstPrimes(100);

      // Aufgabe 4
      System.out.println("Aufgabe 4:\n");
      rowOfSeven(250);
   }

   /**
    * Aufgabe 1:
    * Erstellt eine 10-fache Schleife, wo die 5. hervorgehoben ist.
    */
   private static void loopSpec5()
   {
      int i = 0;

      while( i < 10 )
      {
         i++;
         System.out.printf("%02d. Durchlauf", i);
         System.out.print(i == 5 ? " (der ganz wichtig ist)\n" : "\n");
      }
   }

   /**
    * Aufgabe 2 + 3:
    * Gibt eine bestimmte Anzahl an Primzahlen zurück.
    *
    * @param limit bestimmt die größtmögliche Primzahl
    */
   private static void firstPrimes(int limit)
   {
      System.out.println("Die Primzahlen von 1 bis " + limit + " sind:");

      boolean isFirstNum = true;

      for( int i = 1; i < limit; i++ )
      {
         boolean isPrime = true;

         for( int j = 2; j < i; j++ )
         {
            if( i % j == 0 )
            {
               isPrime = false;
               break;
            }
         }

         if( isPrime )
         {
            System.out.print((isFirstNum ? "" : ", ") + i);

            isFirstNum = false;
         }
      }

      System.out.println("");
   }

   /**
    * Aufgabe 4:
    * Gibt die 7er-Reihe, mit Hilfe des Schlüsselwortes <code>continue</code>, zurück.
    *
    * @param maxValue bestimmt die größtmögliche Zahl
    */
   private static void rowOfSeven(int maxValue)
   {
      System.out.println("Die gerade 7er-Reihe bis zum Maximalwert von " + maxValue + " lautet:");

      boolean isFirstNum = true;

      for( int i = 0; i < maxValue; i++ )
      {
         if( i % 7 != 0 || i % 2 == 0 )
         {
            continue;
         }

         System.out.print((isFirstNum ? "" : " | ") + i);

         isFirstNum = false;
      }

      System.out.println("");
   }
}
