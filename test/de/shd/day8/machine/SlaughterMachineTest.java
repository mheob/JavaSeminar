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
 * Eine Testumgebung f�r unser sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@SuppressWarnings("Duplicates")
public class SlaughterMachineTest
{
   private SlaughterMachine machine;
   private List<StallAnimal> animals;

   @Before
   public void setUp() throws Exception
   {
      machine = new SlaughterMachine();
      animals = new ArrayList<>();

      animals.add(new Cow("Kuh_1", 300, Gender.FEMALE));
      animals.add(new Pig("Schwein_2", 351, Gender.MALE));
      animals.add(new Dog("Hund_3", 251, Gender.FEMALE));
      animals.add(new Sheep("Schaf_4", 200, Gender.MALE));
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void work() throws Exception
   {
      animals = machine.work(animals);

      Assert.assertTrue("Es sollten 2 Tiere �brig bleiben: ", animals.size() == 2);
      Assert.assertFalse("Es d�rfen nicht weniger wie 2 Tiere �brig bleiben: ", animals.size() < 2);
      Assert.assertFalse("Es d�rfen nicht mehr wie 2 Tiere �brig bleiben: ", animals.size() > 2);
   }

   @Test
   public void slaughter() throws Exception
   {
      animals = machine.slaughter(animals);

      Assert.assertTrue("Es sollten 2 Tiere �brig bleiben: ", animals.size() == 2);
      Assert.assertFalse("Es d�rfen nicht weniger wie 2 Tiere �brig bleiben: ", animals.size() < 2);
      Assert.assertFalse("Es d�rfen nicht mehr wie 2 Tiere �brig bleiben: ", animals.size() > 2);
   }
}
