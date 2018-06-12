package de.shd.day2.animals;

/**
 * Ein zweites Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 13.01.2017
 */
public class Dog extends StallAnimal
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
}
