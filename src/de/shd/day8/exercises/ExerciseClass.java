package de.shd.day8.exercises;

/**
 * Ein achtes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.03.2017
 */
@SuppressWarnings("SameParameterValue")
public abstract class ExerciseClass
{
   public static void MethodB(ExerciseInterface ei, String sParam, int add1, int add2)
   {
      ei.MethodA(sParam, add1, add2);
   }
}
