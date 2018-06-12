package de.shd.day8.machine;

import java.util.ArrayList;
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
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@SuppressWarnings("Duplicates")
public class SlaughterMachine implements Machine
{
   private static final Logger LOG = LogManager.getLogger(SlaughterMachine.class);

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
    * Reinigt die Maschine nach der Arbeit.
    *
    * @param animals die Tiere im Stall
    */
   @Override
   public void cleaning(List<StallAnimal> animals)
   {
      float count = animals.size() * 2.5F;

      LOG.info("Die Reinigung der Schlachtmaschine dauerte " + count + " Stunden.");
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

      LOG.info("Es leben aktuell nur noch " + animals.size() + " Tiere.");

      return animals;
   }
}
