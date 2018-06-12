package de.shd.day8.machine;

import java.util.List;

import de.shd.day8.animals.Animal;
import de.shd.day8.animals.Cow;
import de.shd.day8.animals.Dog;
import de.shd.day8.animals.Pig;
import de.shd.day8.animals.Sheep;
import de.shd.day8.animals.StallAnimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein fünftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
 */
@SuppressWarnings("Duplicates")
public class CleaningMachine implements Machine
{
   private static final Logger LOG = LogManager.getLogger(CleaningMachine.class);

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
            startOutput = animal.animalNameText(Animal.COW, animal.getName());
         }
         else if( animal instanceof Dog )
         {
            startOutput = animal.animalNameText(Animal.DOG, animal.getName());
         }
         else if( animal instanceof Pig )
         {
            startOutput = animal.animalNameText(Animal.PIG, animal.getName());
         }
         else if( animal instanceof Sheep )
         {
            startOutput = animal.animalNameText(Animal.SHEEP, animal.getName());
         }

         if( animal.isDirty() )
         {
            numberCleanings++;

            LOG.info(startOutput + " wurde gereinigt.");
            animal.setDirty(false);
         }
      }

      LOG.info("Es wurden insgesamt " + numberCleanings + " Tiere gereinigt.");

      return animals;
   }
}
