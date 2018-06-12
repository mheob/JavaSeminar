package de.shd.day8.machine;

import java.util.ArrayList;
import java.util.List;

import de.shd.day8.animals.Cow;
import de.shd.day8.animals.Dog;
import de.shd.day8.animals.Gender;
import de.shd.day8.animals.Pig;
import de.shd.day8.animals.Sheep;
import de.shd.day8.animals.StallAnimal;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Eine Testumgebung für unser sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@SuppressWarnings("Duplicates")
public class BreedingMachineTest
{
   private List<StallAnimal> animals = new ArrayList<>();
   private List<StallAnimal> cows = new ArrayList<>();
   private List<StallAnimal> dogs = new ArrayList<>();
   private List<StallAnimal> pigs = new ArrayList<>();
   private List<StallAnimal> sheeps = new ArrayList<>();
   private BreedingMachine machine;

   @Before
   public void setUp() throws Exception
   {
      machine = new BreedingMachine();

      animals.add(new Cow("Kuh_Male_1", 1200, Gender.MALE));
      animals.add(new Cow("Kuh_Female_1", 1200, Gender.FEMALE));
      animals.add(new Cow("Kuh_Female_2", 1200, Gender.FEMALE));
      animals.add(new Dog("Hund_Male_1", 220, Gender.MALE));
      animals.add(new Dog("Hund_Female_1", 220, Gender.FEMALE));
      animals.add(new Dog("Hund_Female_2", 220, Gender.FEMALE));
      animals.add(new Pig("Schwein_Male_1", 512, Gender.MALE));
      animals.add(new Pig("Schwein_Female_1", 512, Gender.FEMALE));
      animals.add(new Pig("Schwein_Female_2", 512, Gender.FEMALE));
      animals.add(new Sheep("Schaf_Male_1", 205, Gender.MALE));
      animals.add(new Sheep("Schaf_Female_1", 205, Gender.FEMALE));
      animals.add(new Sheep("Schaf_Female_2", 205, Gender.FEMALE));

      cows.add(animals.get(0));
      cows.add(animals.get(1));
      cows.add(animals.get(2));
      dogs.add(animals.get(3));
      dogs.add(animals.get(4));
      dogs.add(animals.get(5));
      pigs.add(animals.get(6));
      pigs.add(animals.get(7));
      pigs.add(animals.get(8));
      sheeps.add(animals.get(9));
      sheeps.add(animals.get(10));
      sheeps.add(animals.get(11));
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void work() throws Exception
   {
      animals = machine.work(animals);

      Assert.assertTrue("Es müssen insgesamt 16 Tiere vorhanden sein werden", animals.size() == 16);
   }

   @Test
   public void conceive()
   {
      animals = machine.conceive(animals);
      Assert.assertTrue("Es müssen insgesamt 16 Tiere vorhanden sein werden", animals.size() == 16);
   }

   @Test
   public void addAnimals() throws Exception
   {
      List<StallAnimal> animalBabys = new ArrayList<>();

      animalBabys.addAll(machine.addAnimals(cows));
      animalBabys.addAll(machine.addAnimals(dogs));
      animalBabys.addAll(machine.addAnimals(pigs));
      animalBabys.addAll(machine.addAnimals(sheeps));

      Assert.assertTrue("Das erste Tier muss \"KuhBaby_1\" heißen.", "KuhBaby_1".equals(animalBabys.get(0).getName()));
      Assert.assertTrue("Das zweite Tier muss \"HundBaby_1\" heißen.", "HundBaby_1".equals(animalBabys.get(1).getName()));
      Assert.assertTrue("Das dritte Tier muss \"SchweinBaby_1\" heißen.", "SchweinBaby_1".equals(animalBabys.get(2).getName()));
      Assert.assertTrue("Das vierte Tier muss \"SchafBaby_1\" heißen.", "SchafBaby_1".equals(animalBabys.get(3).getName()));
   }
}
