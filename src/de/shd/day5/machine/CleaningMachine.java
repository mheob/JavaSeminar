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
public class CleaningMachine implements Machine
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
    * Reinigt die Tiere.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   private List<StallAnimal> feed(List<StallAnimal> animals)
   {
      String startOutput = "Das Tier ";
      int numberCleanings = 0;

      for( StallAnimal animal : animals )
      {
         if( animal instanceof Cow )
         {
            startOutput = animal.animalNameText(StallAnimal.Animal.COW, animal.getName());
         }
         else if( animal instanceof Dog )
         {
            startOutput = animal.animalNameText(StallAnimal.Animal.DOG, animal.getName());
         }
         else if( animal instanceof Pig )
         {
            startOutput = animal.animalNameText(StallAnimal.Animal.PIG, animal.getName());
         }
         else if( animal instanceof Sheep )
         {
            startOutput = animal.animalNameText(StallAnimal.Animal.SHEEP, animal.getName());
         }

         if( animal.isDirty() )
         {
            numberCleanings++;

            System.out.println(startOutput + " wurde gereinigt.");
            animal.setDirty(false);
         }
      }

      System.out.println("\t---");
      System.out.println("Es wurden insgesamt " + numberCleanings + " Tiere gereinigt.");

      return animals;
   }
}
