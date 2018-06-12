package de.shd.day6.animals;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
public enum Animal
{
   COW(22, 300), DOG(2, 250), PIG(10, 350), SHEEP(5, 200), ANIMAL(10, 150);

   private final int foodIncrease;
   private final int slaughterWeight;

   Animal(int foodIncrease, int slaughterWeight)
   {
      this.foodIncrease = foodIncrease;
      this.slaughterWeight = slaughterWeight;
   }

   public int getFoodIncrease()
   {
      return foodIncrease;
   }

   public int getSlaughterWeight()
   {
      return slaughterWeight;
   }
}
