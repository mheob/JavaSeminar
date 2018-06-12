package de.shd.day3.animals;

/**
 * Ein drittes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 18.01.2017
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
      System.out.println(animalNameText(Animal.COW, getName()) + " macht muh.");
   }
}
