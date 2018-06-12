package de.shd.day5.exercises;

/**
 * Ein fünftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
 */
@SuppressWarnings({"NumericOverflow", "unused"})
public class ExceptionsExercise
{
   //private int calculation = 55 / (33 - (11 * 3));

   /**
    * Aufgabe 1 (1 - 3):
    * Simuliert das Ausnahmeverhalten bei einer Division durch 0.
    * Genutzt wird der "try/catch"-Block.
    */
   public void calcTryCatch()
   {
      try
      {
         System.out.println("Das Ergebnis ist: " + (55 / (33 - (11 * 3))));
      }
      catch(ArithmeticException | NumberFormatException e)
      {
         //System.out.println("FEHLER: " + e.getMessage());
         throw new RuntimeException("Arithmetischer FEHLER: " + e.getMessage());
      }
      catch(Exception e)
      {
         //System.out.println("FEHLER: " + e.getMessage());
         throw new RuntimeException("Allgemeiner FEHLER: " + e.getMessage());
      }
   }

   /**
    * Aufgabe 1 (1 + 4):
    * Simuliert das Ausnahmeverhalten bei einer Division durch 0.
    * Genutzt wird die "trows"-Variante zum Aufrufer, der sich um die Behandlung kümmert.
    *
    * @throws Exception Verschiedene Fehler möglich - in erster Linie eine Division durch 0.
    */
   public void calcThrows() throws Exception
   {
      System.out.println("Das Ergebnis ist: " + (55 / (33 - (11 * 3))));
   }
}
