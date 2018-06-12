package de.shd.day5.animals;

/**
 * Ein fünftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
 */
@SuppressWarnings("Duplicates")
public class Cow extends StallAnimal implements Comparable
{
   public Cow()
   {
   }

   /**
    * Die Instanzinierung mit dynamischem Namen und Gewicht.
    *
    * @param name   der Name der Kuh
    * @param weight das Gewicht der Kuh
    */
   public Cow(String name, int weight)
   {
      setName(name);
      setWeight(weight);
   }

   /**
    * Die benannte Kuh gibt einen Laut von sich.
    */
   public void muh()
   {
      System.out.println(animalNameText(Animal.COW, getName()) + " macht muh.");
   }

   @Override
   public int compareTo(Object o)
   {
      return defaultCompare(o);
   }
}
