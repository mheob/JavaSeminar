package de.shd.utils;

/**
 * Eine Stoppuhr, mit den Funktionen:
 * <ul>
 * <li>Start</li>
 * <li>Stop</li>
 * <li>Reset</li>
 * </ul>
 *
 * @author ALB
 * @version 1.0 vom 18.01.2017
 */
public class StopWatch
{
   private long start;
   private long elapsedTime;

   /**
    * Startet die Stoppuhr.
    */
   public void start()
   {
      start = System.nanoTime();
   }

   /**
    * Stoppt die Stoppuhr und gibt die vergangen Millisekunden zurück.
    *
    * @return die vergangen Millisekunden in einem Satz
    */
   public String stop(String title)
   {
      elapsedTime = System.nanoTime() - start;
      double milliseconds = (double) elapsedTime / 1000000;

      return title + milliseconds + " ms";
   }

   /**
    * Setzt die Werte der Stoppuhr zurück.
    */
   public void reset()
   {
      start = 0;
      elapsedTime = 0;
   }
}
