package de.shd.day2.machine;

import java.util.ArrayList;

import de.shd.day2.animals.Cow;
import de.shd.day2.animals.Dog;
import de.shd.day2.animals.Pig;
import de.shd.day2.animals.StallAnimal;

/**
 * Ein zweites Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 13.01.2017
 */
@SuppressWarnings("WeakerAccess")
public class FeedMachine
{
   /**
    * L‰sst das Stalltier Nahrung zu sich nehmen und nimmt an Gewicht zu.
    *
    * @param animal     die Art des Tieres
    * @param animalName der Name des Tiere in erweiterter Textform
    * @param weight     das Gewicht des Tieres
    */
   public void feed(StallAnimal.Animal animal, String animalName, int weight)
   {
      System.out.println(animalName + " wiegt vor dem Essen " + weight + " kg.");

      if( animal == StallAnimal.Animal.PIG )
      {
         System.out.println("Durch die Nahrung hat das Tier 2 kg zugenommen und wiegt nun: " + (weight + 2) + " kg.");
      }
      else
      {
         System.out.println("Durch die Nahrung hat das Tier 1 kg zugenommen und wiegt nun: " + ++weight + " kg.");
      }
   }

   /**
    * L‰sst das Stalltier Nahrung zu sich nehmen und nimmt an Gewicht zu.
    *
    * @param animal         das Tier
    * @param animalName     der Name des Tiere in erweiterter Textform
    * @param weightBefore   das Gewicht des Tieres
    * @param weightIncrease die Gewichtszunahme des Tieres
    */
   public void feed(StallAnimal animal, String animalName, int weightBefore, int weightIncrease)
   {
      animal.setWeight(weightBefore + weightIncrease);

      System.out.println(animalName + " wiegt vor dem Essen " + weightBefore + " kg.");
      System.out.println("Durch die Nahrung hat das Tier " + weightIncrease + " kg zugenommen und wiegt nun: " + animal.getWeight() + " kg.");
   }

   public void feed(ArrayList<StallAnimal> animals)
   {
      int weightToLoose = 4;
      int numberDogs = 0;

      for( StallAnimal animal : animals )
      {
         if( animal instanceof Dog )
         {
            feed(animal, animal.animalNameText(StallAnimal.Animal.DOG, animal.getName()), animal.getWeight(), 1);
            numberDogs++;
         }
         else if( animal instanceof Cow )
         {
            feed(animal, animal.animalNameText(StallAnimal.Animal.COW, animal.getName()), animal.getWeight(), 1);
            bite(animal, weightToLoose, numberDogs);
         }
         else if( animal instanceof Pig )
         {
            feed(animal, animal.animalNameText(StallAnimal.Animal.PIG, animal.getName()), animal.getWeight(), 2);
            bite(animal, weightToLoose, numberDogs);
         }
         else //if( animal instanceof Sheep )
         {
            feed(animal, animal.animalNameText(StallAnimal.Animal.SHEEP, animal.getName()), animal.getWeight(), 1);
            bite(animal, weightToLoose, numberDogs);
         }

         System.out.println("\n\t---\n");
      }
   }

   /**
    * Beiﬂt andere Tiere und nimmt dabei an Gewicht ab.
    *
    * @param animal      das Tier
    * @param weightLoose das zu verlierende Gewicht pro Biss
    * @param numberDogs  die Anzahl der beiﬂenden Hunde
    */
   public void bite(StallAnimal animal, int weightLoose, int numberDogs)
   {
      if( numberDogs < 1 )
      {
         return;
      }

      animal.setWeight(animal.getWeight() - (weightLoose * numberDogs));

      System.out.println("Das Tier wurde von " + (numberDogs == 1 ? "einem Hund" : numberDogs + " Hunden") + " gebissen.");
      System.out.println("Dadurch nimmt es pro Biss " + weightLoose + " Kilogramm ab und wiegt nun nur noch " + animal.getWeight() + " kg.");
   }
}
