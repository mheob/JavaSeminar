package de.shd.day4.animals;

/**
 * Ein viertes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 25.01.2017
 */
@SuppressWarnings("Duplicates")
public class Pig extends StallAnimal implements Comparable
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

   @Override
   public int compareTo(Object o)
   {
      return defaultCompare(o);
   }
}
