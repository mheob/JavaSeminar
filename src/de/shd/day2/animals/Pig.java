package de.shd.day2.animals;

/**
 * Ein zweites Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 13.01.2017
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
      System.out.println("Das Schwein mit dem Namen " + getName() + " suhlt sich vergnügt im Schlamm.");
   }

   /**
    * Lässt das Schwein Nahrung zu sich nehmen und nimmt gleich doppelt Gewicht zu.
    */
   @Override
   public void eat()
   {
      System.out.println("Das " + this.getClass().getSimpleName() + " " + getName() + " wiegt vor dem Essen " + getWeight() + " kg.");
      System.out.println("Durch die Nahrung hat es 2 kg zugenommen und wiegt nun: " + (getWeight() + 2) + " kg.");
   }
}
