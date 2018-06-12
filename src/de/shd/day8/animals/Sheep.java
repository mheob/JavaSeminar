package de.shd.day8.animals;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@SuppressWarnings("Duplicates")
public class Sheep extends StallAnimal implements Comparable
{
   public Sheep()
   {
      // F�r generierung aus einer Datei raus ben�tigt.
   }

   /**
    * Die Instanzinierung mit dynamischem Namen und Gewicht.
    *
    * @param name   der Name vom Schaf
    * @param weight das Gewicht vom Schaf
    * @param gender das Geschlecht vom Schaf
    */
   public Sheep(String name, int weight, Gender gender)
   {
      setName(name);
      setWeight(weight);
      setGender(gender);
   }

   @Override
   public int compareTo(Object o)
   {
      return defaultCompare(o);
   }
}
