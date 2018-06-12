package de.shd.day4.animals;

/**
 * Ein viertes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 25.01.2017
 */
@SuppressWarnings("Duplicates")
public class Sheep extends StallAnimal implements Comparable
{
   /**
    * Die Instanzinierung mit dynamischem Namen und Gewicht.
    *
    * @param name   der Name vom Schaf
    * @param weight das Gewicht vom Schaf
    */
   public Sheep(String name, int weight)
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
