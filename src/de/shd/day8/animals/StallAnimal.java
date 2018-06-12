package de.shd.day8.animals;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@SuppressWarnings({"Duplicates", "WeakerAccess"})
public class StallAnimal
{
   private String name;
   private String gender;
   private int weight;
   private boolean dirty;

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
            output = "Das Tier";
            break;
      }

      output += " mit dem Namen \"" + name + "\"";

      return output;
   }

   public int defaultCompare(Object o)
   {
      StallAnimal otherAnimal = (StallAnimal) o;

      if( this.getWeight() < otherAnimal.getWeight() )
      {
         return -1;
      }
      else if( this.getWeight() > otherAnimal.getWeight() )
      {
         return 1;
      }
      else
      {
         return 0;
      }
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


   /**
    * Gibt eine Verschmutzung zur�ck.
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

   public String getGender()
   {
      return gender;
   }

   public void setGender(Gender gender)
   {
      this.gender = gender.name();
   }

   @Override
   public String toString()
   {
      return "Name: " + getName() + ", " + "Gewicht: " + getWeight() + " kg.";
   }
}
