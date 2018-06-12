package de.shd.day2.animals;

/**
 * Ein zweites Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 13.01.2017
 */
public class Cow extends StallAnimal
{
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
      System.out.println("Die Kuh mit dem Namen " + getName() + " macht muh.");
   }
}
