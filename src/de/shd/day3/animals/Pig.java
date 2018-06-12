package de.shd.day3.animals;

/**
 * Ein drittes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 18.01.2017
 */
public class Pig extends StallAnimal
{
   /**
    * Die Instanzinierung mit dynamischem Namen und Gewicht.
    *
    * @param name   der Name vom Schwein
    * @param weight das Gewicht vom Schwein
    */
   public Pig(String name, int weight)
   {
      setName(name);
      setWeight(weight);
   }

   /**
    * Das benannte Schwein suhlt sich voller Freude.
    */
   public void suhlen()
   {
      System.out.println(animalNameText(Animal.PIG, getName()) + " suhlt sich vergnügt im Schlamm.");
   }
}
