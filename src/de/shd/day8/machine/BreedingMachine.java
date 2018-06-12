package de.shd.day8.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.shd.day8.animals.Cow;
import de.shd.day8.animals.Dog;
import de.shd.day8.animals.Gender;
import de.shd.day8.animals.Pig;
import de.shd.day8.animals.Sheep;
import de.shd.day8.animals.StallAnimal;
import de.shd.utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@SuppressWarnings("Duplicates")
public class BreedingMachine implements Machine
{
   private static final Logger LOG = LogManager.getLogger(BreedingMachine.class);

   /**
    * Führt eine gewünschte Arbeit aus.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   @Override
   public List<StallAnimal> work(List<StallAnimal> animals)
   {
      LOG.info("Neue Tiere werden gezeugt.");
      return conceive(animals);
   }

   /**
    * Zeugt ein neues Tier, wenn es ein männliche und weibliche Tiere der gleichen Gattung gibt.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   List<StallAnimal> conceive(List<StallAnimal> animals)
   {
      List<StallAnimal> cows = new ArrayList<>();
      List<StallAnimal> dogs = new ArrayList<>();
      List<StallAnimal> pigs = new ArrayList<>();
      List<StallAnimal> sheeps = new ArrayList<>();

      for( StallAnimal animal : animals )
      {
         if( animal instanceof Cow )
         {
            cows.add(animal);
         }
         else if( animal instanceof Dog )
         {
            dogs.add(animal);
         }
         else if( animal instanceof Pig )
         {
            pigs.add(animal);
         }
         else if( animal instanceof Sheep )
         {
            sheeps.add(animal);
         }
      }

      animals.addAll(addAnimals(cows));
      animals.addAll(addAnimals(dogs));
      animals.addAll(addAnimals(pigs));
      animals.addAll(addAnimals(sheeps));

      return animals;
   }

   /**
    * Fügt Babytiere hinzu
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   List<StallAnimal> addAnimals(List<StallAnimal> animals)
   {
      List<StallAnimal> animalBabys = new ArrayList<>();
      int countMale = 0;
      int countFemale = 0;

      for( StallAnimal animal : animals )
      {
         if( "MALE".equals(animal.getGender()) )
         {
            countMale++;
         }
         else
         {
            countFemale++;
         }
      }

      for( int i = 0; i < Helper.getSmallerInt(countMale, countFemale); i++ )
      {
         Gender gender = new Random().nextInt(2) <= 1 ? Gender.FEMALE : Gender.MALE;

         if( animals.get(i) instanceof Cow )
         {
            animalBabys.add(new Cow("KuhBaby_" + (i + 1), new Random().nextInt(300), gender));
         }
         else if( animals.get(i) instanceof Pig )
         {
            animalBabys.add(new Pig("SchweinBaby_" + (i + 1), new Random().nextInt(350), gender));
         }
         else if( animals.get(i) instanceof Sheep )
         {
            animalBabys.add(new Sheep("SchafBaby_" + (i + 1), new Random().nextInt(200), gender));
         }
         else
         {
            animalBabys.add(new Dog("HundBaby_" + (i + 1), new Random().nextInt(250), gender));
         }
      }

      return animalBabys;
   }
}
