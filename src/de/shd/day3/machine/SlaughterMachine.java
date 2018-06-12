package de.shd.day3.machine;

import java.util.ArrayList;
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
public class SlaughterMachine implements Machine
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
      return slaughter(animals);
   }

   /**
    * Schlachtet die fetten Tiere.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   private List<StallAnimal> slaughter(List<StallAnimal> animals)
   {
      List<StallAnimal> overweightAnimals = new ArrayList<>();
      String startOutput;
      int maxWeight = 300;

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
         else
         {
            startOutput = animal.animalNameText(StallAnimal.Animal.ANIMAL, animal.getName());
         }

         if( animal.getWeight() > maxWeight )
         {
            overweightAnimals.add(animal);

            System.out.println(startOutput + " hat mit " + animal.getWeight() +
                               " kg mehr als das Höchstgewicht von "
                               + maxWeight + " kg gewogen und wurde geschlachtet.");
         }
      }

      animals.removeAll(overweightAnimals);

      System.out.println("\t---");
      System.out.println("Es leben somit aktuell nur noch " + animals.size() + " Tiere.");

      return animals;
   }
}
