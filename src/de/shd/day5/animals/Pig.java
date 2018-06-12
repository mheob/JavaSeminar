package de.shd.day5.animals;

/**
 * Ein fünftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
 */
@SuppressWarnings("Duplicates")
public class Pig extends StallAnimal implements Comparable
{
   public Pig()
   {
   }

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
