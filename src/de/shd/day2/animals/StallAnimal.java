package de.shd.day2.animals;

/**
 * Ein zweites Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 13.01.2017
 */
@SuppressWarnings("WeakerAccess")
public abstract class StallAnimal
{
   private String name;
   private int weight;

   public enum Animal
   {
      COW, DOG, PIG, SHEEP
   }

   /**
    * L�sst das Tier Nahrung zu sich nehmen und nimmt an Gewicht zu.
    */
   public void eat()
   {
      System.out.println("Das Tier mit dem Namen " + getName() + " wiegt vor dem Essen " + getWeight() + " kg.");
      System.out.println("Durch die Nahrung hat es 1 kg zugenommen und wiegt nun: " + (getWeight() + 1) + " kg.");
   }

   /**
    * Baut einen standardisierten Text f�r die jeweiligen Tiere zusammen.
    *
    * @param animal die Art des Tieres
    * @param name   der Name des Tieres
    * @return das Tier inkl. dem Namen
    */
   public String animalNameText(Animal animal, String name)
   {
      String output;

      switch( animal )
      {
         case COW:
            output = "Die Kuh";
            break;
         case DOG:
            output = "Der Hund";
            break;
         case PIG:
            output = "Das Schwein";
            break;
         case SHEEP:
            output = "Das Schaf";
            break;
         default:
            output = "-- ERROR --";
            break;
      }

      output += " mit dem Namen \"" + name + "\"";

      return output;
   }

   /**
    * Gibt den Namen vom Stalltier zur�ck.
    *
    * @return der Name
    */
   public String getName()
   {
      return name;
   }

   /**
    * Setzt den Namen vom Stalltier.
    *
    * @param name der gew�nschte Name
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Gibt das Gewicht vom Stalltier zur�ck.
    *
    * @return das Gewicht
    */
   public int getWeight()
   {
      return weight;
   }

   /**
    * Setzt das Gewicht vom Stalltier.
    *
    * @param weight das gew�nschte Gewicht
    */
   public void setWeight(int weight)
   {
      this.weight = weight;
   }
}
