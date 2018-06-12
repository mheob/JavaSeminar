package de.shd.day3.animals;

/**
 * Ein drittes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 18.01.2017
 */
public class Sheep extends StallAnimal
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
}
