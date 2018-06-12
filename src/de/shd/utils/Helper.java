package de.shd.utils;

import java.io.File;

/**
 * Eine Klasse mit nützlichen kleinen Helfer-Methoden.
 *
 * @author ALB
 * @version 1.2 vom 01.02.2017
 */
public interface Helper
{
   /**
    * Gibt die Dateiendung zurück
    *
    * @param file Die zu prüfende Datei.
    * @return Die Dateiendung.
    */
   static String getFileExtension(File file)
   {
      String fileName = file.getName();
      if( fileName.lastIndexOf('.') != -1 && fileName.lastIndexOf('.') != 0 )
      {
         return fileName.substring(fileName.lastIndexOf('.') + 1);
      }
      else
      {
         return "";
      }
   }

   /**
    * Gibt den kleineren Wert von zwei Zahlen zurück.
    *
    * @param a Zahl 1
    * @param b Zahl 2
    * @return Wert der kleineren Zahl
    */
   static int getSmallerInt(int a, int b)
   {
      return a > b ? b : a;
   }
}
