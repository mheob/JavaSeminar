package de.shd.day5.exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Ein fünftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
 */
@SuppressWarnings("unused")
public class FileProcExercise
{
   /**
    * Erstellt eine Datei
    *
    * @param file Die Datei.
    * @throws IOException Dateiprobleme
    */
   public void createFile(File file) throws IOException
   {
      if( file.createNewFile() )
      {
         System.out.println("Die Datei wurde erstellt.");
      }
   }

   /**
    * Schreibt in eine Datei
    *
    * @param file Die Datei.
    * @throws FileNotFoundException Dateiprobleme
    */
   public void writeFile(File file) throws FileNotFoundException
   {
      PrintWriter pw = new PrintWriter(file);
      pw.println("Hallo Welt!");
      pw.println("Hier könnte Ihre Werbung stehen ...");
      pw.flush();
      pw.close();
   }

   /**
    * Schreibt in eine Datei
    *
    * @param file Die Datei.
    * @throws IOException Dateiprobleme
    */
   public void readFile(File file) throws IOException
   {
      try (BufferedReader reader = new BufferedReader(new FileReader(file)))
      {
         reader.lines().forEach(System.out::println);

         //String line;
         //while( (line = reader.readLine()) != null )
         //{
         //   System.out.println(line);
         //}

         //for( String line = reader.readLine(); line != null; line = reader.readLine() )
         //{
         //   System.out.println(line);
         //}
      }
   }
}
