package de.shd.day5.machine;

import java.util.List;

import de.shd.day5.animals.Cow;
import de.shd.day5.animals.Dog;
import de.shd.day5.animals.Pig;
import de.shd.day5.animals.Sheep;
import de.shd.day5.animals.StallAnimal;

/**
 * Ein fünftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
 */
@SuppressWarnings("Duplicates")
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
      for( StallAnimal animal : animals )
      {
         int weightBefore = animal.getWeight();

         if( animal instanceof Cow )
         {
            animal.setWeight(weightBefore + 10);
         }
         else if( animal instanceof Dog )
         {
            animal.setWeight(weightBefore + 2);
         }
         else if( animal instanceof Pig )
         {
            animal.setWeight(weightBefore + 20);
         }
         else if( animal instanceof Sheep )
         {
            animal.setWeight(weightBefore + 5);
         }
         else
         {
            animal.setWeight(weightBefore + 2);
         }
      }

      return animals;
   }
}
