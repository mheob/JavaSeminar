package de.shd.day6.machine;

import java.util.ArrayList;
import java.util.List;

import de.shd.day6.animals.Cow;
import de.shd.day6.animals.Dog;
import de.shd.day6.animals.Gender;
import de.shd.day6.animals.Pig;
import de.shd.day6.animals.Sheep;
import de.shd.day6.animals.StallAnimal;
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
public class FeedMachineTest
{
   private FeedMachine machine;
   private List<StallAnimal> animals;

   @Before
   public void setUp() throws Exception
   {
      machine = new FeedMachine();
      animals = new ArrayList<>();

      animals.add(new Cow("Kuh_1", 100, Gender.FEMALE));
      animals.add(new Pig("Schwein_2", 112, Gender.MALE));
      animals.add(new Dog("Hund_3", 120, Gender.FEMALE));
      animals.add(new Sheep("Schaf_4", 117, Gender.MALE));
   }

   @After
   public void tearDown() throws Exception
   {

   }

   @Test
   public void work() throws Exception
   {
      animals = machine.work(animals);

      for( int i = 0; i < animals.size(); i++ )
      {
         Assert.assertTrue("Ergebnis sollte 122 sein (Tier Nr. " + (i + 1) + "): ", animals.get(i).getWeight() == 122);
         Assert.assertFalse("Ergebnis darf nicht kleiner 122 sein (Tier Nr. " + (i + 1) + "): ", animals.get(i).getWeight() < 122);
         Assert.assertFalse("Ergebnis darf nicht größer 122 sein (Tier Nr. " + (i + 1) + "): ", animals.get(i).getWeight() > 122);
      }
   }

   @Test
   public void feed() throws Exception
   {
      animals = machine.feed(animals);

      for( int i = 0; i < animals.size(); i++ )
      {
         Assert.assertTrue("Ergebnis sollte 122 sein (Tier Nr. " + (i + 1) + "): ", animals.get(i).getWeight() == 122);
         Assert.assertFalse("Ergebnis darf nicht kleiner 122 sein (Tier Nr. " + (i + 1) + "): ", animals.get(i).getWeight() < 122);
         Assert.assertFalse("Ergebnis darf nicht größer 122 sein (Tier Nr. " + (i + 1) + "): ", animals.get(i).getWeight() > 122);
      }
   }
}
