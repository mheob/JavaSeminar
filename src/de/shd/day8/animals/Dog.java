package de.shd.day8.animals;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@SuppressWarnings("Duplicates")
public class Dog extends StallAnimal implements Comparable
{
   public Dog()
   {
      // Für generierung aus einer Datei raus benötigt.
   }

   /**
    * Die Instanzinierung mit dynamischem Namen und Gewicht.
    *
    * @param name   der Name vom Hund
    * @param weight das Gewicht vom Hund
    * @param gender das Geschlecht vom Hund
    */
   public Dog(String name, int weight, Gender gender)
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
