package de.shd.day8.animals;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@SuppressWarnings("Duplicates")
public class Cow extends StallAnimal implements Comparable
{
   public Cow()
   {
      // Für generierung aus einer Datei raus benötigt.
   }

   /**
    * Die Instanzinierung mit dynamischem Namen und Gewicht.
    *
    * @param name   der Name der Kuh
    * @param weight das Gewicht der Kuh
    * @param gender das Geschlecht der Kuh
    */
   public Cow(String name, int weight, Gender gender)
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
