package de.shd.day5.animals;

/**
 * Ein fünftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
 */
@SuppressWarnings("Duplicates")
public class Sheep extends StallAnimal implements Comparable
{
   public Sheep()
   {
   }

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
