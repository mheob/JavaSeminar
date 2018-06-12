package de.shd.day6.dao;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import de.shd.day6.animals.Cow;
import de.shd.day6.animals.Dog;
import de.shd.day6.animals.Gender;
import de.shd.day6.animals.Pig;
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
public class StallDAOTest
{
   private List<StallAnimal> animals;
   private StallDAO dao = new StallDAO();
   private String testingPath;
   private File testFile;

   @Before
   public void initialData()
   {
      animals = new ArrayList<>();
      testingPath = Paths.get("").toAbsolutePath().toString() + "\\resources\\ExerciseFiles\\day6\\";
      testFile = new File(testingPath + "stall_test.csv");

      animals.add(new Cow("Kuh_1", 100, Gender.FEMALE));
      animals.add(new Pig("Schwein_2", 112, Gender.MALE));
      animals.add(new Dog("Hund_3", 120, Gender.FEMALE));

      dao = new StallDAO();
      dao.writeData(testFile, animals);
   }

   @Test
   public void writeCsvShouldGenerateCsvFile()
   {
      // Datei vorhanden?
      Assert.assertTrue("Die geschriebene Datei ist nicht vorhanden!", testFile.exists());

      // Datei korrekt?
      Assert.assertNotNull("Die Rückgabe darf nicht \"null\" sein.", dao.readData(new File(testingPath + "stall_test.csv")));

      // Prüfung der Testmethode
      Assert.assertTrue("Die Rückgabe muss größer 0 sein.", dao.readData(new File(testingPath + "stall_test_correct.csv")).size() > 0);
      Assert.assertFalse("Die Rückgabe darf nicht größer 0 sein.", dao.readData(new File(testingPath + "stall_test_incorrect.csv")).size() > 0);
   }

   @Test
   public void readCsvShouldHave3Lines() throws Exception
   {
      // Datei vorhanden?
      Assert.assertTrue("Die geschriebene Datei ist nicht vorhanden!", testFile.exists());

      StallDAO dao = new StallDAO();
      animals = dao.readData(testFile);

      Assert.assertEquals("Das Ergebnis muss 3 sein: ", 3, animals.size());
   }

   @After
   public void cleanData()
   {
      if( testFile.exists() )
      {
         //noinspection ResultOfMethodCallIgnored
         testFile.delete();
      }
   }
}
