package de.shd.day5.machine;

import java.util.ArrayList;
import java.util.List;

import de.shd.day5.animals.StallAnimal;

/**
 * Ein fünftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
 */
@SuppressWarnings("Duplicates")
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
      int maxWeight = 300;

      for( StallAnimal animal : animals )
      {
         if( animal.getWeight() > maxWeight )
         {
            overweightAnimals.add(animal);
         }
      }

      animals.removeAll(overweightAnimals);

      System.out.println("\t---");
      System.out.println("Es leben aktuell nur noch " + animals.size() + " Tiere.");

      return animals;
   }
}
