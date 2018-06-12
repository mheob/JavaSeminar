package de.shd.day6.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class SlaughterMachine implements Machine
{
   private static final Logger LOGGER = Logger.getLogger(SlaughterMachine.class.getName());

   /**
    * Führt eine gewünschte Arbeit aus.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   @Override
   public List<StallAnimal> work(List<StallAnimal> animals)
   {
      return slaughter(animals);
   }

   /**
    * Schlachtet die fetten Tiere.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   List<StallAnimal> slaughter(List<StallAnimal> animals)
   {
      Animal animalVar = Animal.ANIMAL;
      List<StallAnimal> overweightAnimals = new ArrayList<>();

      for( StallAnimal animal : animals )
      {
         if( animal instanceof Cow )
         {
            animalVar = Animal.COW;
         }
         else if( animal instanceof Dog )
         {
            animalVar = Animal.DOG;
         }
         else if( animal instanceof Pig )
         {
            animalVar = Animal.PIG;
         }
         else if( animal instanceof Sheep )
         {
            animalVar = Animal.SHEEP;
         }

         if( animal.getWeight() > animalVar.getSlaughterWeight() )
         {
            overweightAnimals.add(animal);
         }
      }

      animals.removeAll(overweightAnimals);

      String loggerText = "Es leben aktuell nur noch " + animals.size() + " Tiere.";
      LOGGER.log(Level.INFO, loggerText);

      return animals;
   }
}
