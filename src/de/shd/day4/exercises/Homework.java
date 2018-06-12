package de.shd.day4.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Ein viertes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 25.01.2017
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class Homework
{

   /**
    * Sortierreihenfolge.
    */
   public enum OrderDirection
   {
      /**
       * Aufsteigend
       */
      ASC,
      /**
       * Absteigend.
       */
      DESC,
      /**
       * Ohne Sortierung.
       */
      NONE
   }

   /**
    * Aufgabe 1:
    * Methode nimmt eine Collection entgegen und füllt sie mit einer angegebenen Anzahl an Zahlen.
    *
    * @param list   Die Collection.
    * @param number Die Anzahl der angegebenen Zahlen.
    * @return Die verarbeitete Collection.
    */
   public List<Integer> Task1(List<Integer> list, int number)
   {
      list.clear();

      for( int i = 0; i < number; i++ )
      {
         list.add(new Random().nextInt(49) + 1);
      }

      return list;
   }

   /**
    * Aufgabe 2:
    * Methode nimmt eine Collection entgegen und sortiert sie je nach Vorgabe.
    *
    * @param list      Die Collection.
    * @param direction Die Sortierreihenfolge.
    * @return Die sortierte Liste.
    */
   public List<Integer> Task2(List<Integer> list, OrderDirection direction)
   {
      switch( direction )
      {
         case ASC:
            list.sort((o1, o2) -> (o1 < o2 ? -1 : (Objects.equals(o1, o2) ? 0 : 1)));
            return list;
         case DESC:
            list.sort((o1, o2) -> (o1 > o2 ? -1 : (Objects.equals(o1, o2) ? 0 : 1)));
            return list;
         default:
            return list;
      }
   }

   /**
    * Aufgabe 3:
    * Methode, fügt Inhalt einer übergebenen Collection an eine zweite übergebene Collection zu und gibt die zusammengeführte Liste zurück.
    *
    * @param list1 Die Collection, die ergänzt werden soll.
    * @param list2 Die ergänzende Collection.
    * @return Die zusammengeführte Collection.
    */
   public List<Integer> Task3(List<Integer> list1, List<Integer> list2)
   {
      List<Integer> newList = new ArrayList<>(list1);
      newList.addAll(list2);

      return newList;
   }
}
