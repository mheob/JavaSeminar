package de.shd.day6.animals;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
public class Pig extends StallAnimal implements Comparable
{
   public Pig()
   {
      // Für generierung aus einer Datei raus benötigt.
   }

   /**
    * Die Instanzinierung mit dynamischem Namen und Gewicht.
    *
    * @param name   der Name vom Schwein
    * @param weight das Gewicht vom Schwein
    * @param gender das Geschlecht vom Schwein
    */
   public Pig(String name, int weight, Gender gender)
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
