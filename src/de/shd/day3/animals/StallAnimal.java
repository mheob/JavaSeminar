package de.shd.day3.animals;

/**
 * Ein drittes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 18.01.2017
 */
public abstract class StallAnimal
{
   private String name;
   private int weight;
   private boolean dirty;

   public enum Animal
   {
      COW, DOG, PIG, SHEEP, ANIMAL
   }

   /**
    * Baut einen standardisierten Text für die jeweiligen Tiere zusammen.
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
            output = "Das Tier";
            break;
      }

      output += " mit dem Namen \"" + name + "\"";

      return output;
   }

   /**
    * Gibt den Namen vom Stalltier zurück.
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
    * @param name der gewünschte Name
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Gibt das Gewicht vom Stalltier zurück.
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
    * @param weight das gewünschte Gewicht
    */
   public void setWeight(int weight)
   {
      this.weight = weight;
   }


   /**
    * Gibt eine Verschmutzung zurück.
    *
    * @return true, wenn verschmutzt
    */
   public boolean isDirty()
   {
      return dirty;
   }

   /**
    * Setz die Verschmutzung.
    *
    * @param dirty eine Verschmutzung liegt vor
    */
   public void setDirty(boolean dirty)
   {
      this.dirty = dirty;
   }
}
