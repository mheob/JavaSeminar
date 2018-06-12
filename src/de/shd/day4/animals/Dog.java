package de.shd.day4.animals;

/**
 * Ein viertes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 25.01.2017
 */
@SuppressWarnings("Duplicates")
public class Dog extends StallAnimal implements Comparable
{
   /**
    * Die Instanzinierung mit dynamischem Namen und Gewicht.
    *
    * @param name   der Name vom Hund
    * @param weight das Gewicht vom Hund
    */
   public Dog(String name, int weight)
   {
      setName(name);
      setWeight(weight);
   }

   @Override
   public int compareTo(Object o)
   {
      return defaultCompare(o);
   }
}
