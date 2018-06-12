package de.shd.day6.machine;

import java.util.List;

import de.shd.day6.animals.Animal;
import de.shd.day6.animals.Cow;
import de.shd.day6.animals.Dog;
import de.shd.day6.animals.Pig;
import de.shd.day6.animals.Sheep;
import de.shd.day6.animals.StallAnimal;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
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
   List<StallAnimal> feed(List<StallAnimal> animals)
   {
      for( StallAnimal animal : animals )
      {
         int weightBefore = animal.getWeight();

         if( animal instanceof Cow )
         {
            animal.setWeight(weightBefore + Animal.COW.getFoodIncrease());
         }
         else if( animal instanceof Dog )
         {
            animal.setWeight(weightBefore + Animal.DOG.getFoodIncrease());
         }
         else if( animal instanceof Pig )
         {
            animal.setWeight(weightBefore + Animal.PIG.getFoodIncrease());
         }
         else if( animal instanceof Sheep )
         {
            animal.setWeight(weightBefore + Animal.SHEEP.getFoodIncrease());
         }
      }

      return animals;
   }
}
