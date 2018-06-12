package de.shd.day3.machine;

import java.util.List;

import de.shd.day3.animals.Cow;
import de.shd.day3.animals.Dog;
import de.shd.day3.animals.Pig;
import de.shd.day3.animals.Sheep;
import de.shd.day3.animals.StallAnimal;

/**
 * Ein drittes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 18.01.2017
 */
public class FeedMachine implements Machine
{
   /**
    * Führt eine gewünschte Arbeit aus.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   @Override
   public List<StallAnimal> work(List<StallAnimal> animals)
   {
      return feed(animals);
   }

   /**
    * Füttert die Tiere.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   private List<StallAnimal> feed(List<StallAnimal> animals)
   {
      boolean isLast;

      for( StallAnimal animal : animals )
      {
         isLast = animals.indexOf(animal) == animals.size() - 1;

         boolean isDirty = Math.random() <= 0.3;

         String startOutput = animal.animalNameText(StallAnimal.Animal.ANIMAL, animal.getName());
         int weightBefore = animal.getWeight();

         if( animal instanceof Cow )
         {
            startOutput = animal.animalNameText(StallAnimal.Animal.COW, animal.getName());
            animal.setWeight(weightBefore + 10);
            ((Cow) animal).muh();
         }
         else if( animal instanceof Dog )
         {
            startOutput = animal.animalNameText(StallAnimal.Animal.DOG, animal.getName());
            animal.setWeight(weightBefore + 2);
         }
         else if( animal instanceof Pig )
         {
            startOutput = animal.animalNameText(StallAnimal.Animal.PIG, animal.getName());
            animal.setWeight(weightBefore + 20);
            ((Pig) animal).suhlen();
         }
         else if( animal instanceof Sheep )
         {
            startOutput = animal.animalNameText(StallAnimal.Animal.SHEEP, animal.getName());
            animal.setWeight(weightBefore + 5);
         }
         else
         {
            animal.setWeight(weightBefore + 2);
         }

         System.out.println(startOutput + " wiegt anfangs " + weightBefore + " kg.");
         System.out.println(startOutput + " wiegt nach dem Fressen " + animal.getWeight() + " kg.");

         animal.setDirty(isDirty);

         if( isDirty )
         {
            System.out.println(startOutput + " hat sich beim Fressen versaut");
         }

         if( !isLast )
         {
            System.out.println("\n\t---\n");
         }
      }

      return animals;
   }
}
