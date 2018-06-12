package de.shd.day4.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.shd.day4.exercises.Homework;
import de.shd.utils.StopWatch;

/**
 * Ein viertes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 25.01.2017
 */
public class MainDay4
{
   /**
    * Hauptprogramm.
    *
    * @param args Kommandozeilenparameter
    */
   public static void main(String[] args) throws IOException
   {
      StopWatch sw = new StopWatch();
      sw.start();

      // Aufgabe 1:
      //ArrayExercise ae = new ArrayExercise();
      //ae.getAnimalsPerLoop(true);
      //System.out.println("-------------");
      //ae.getAnimalsPerLoop(false);
      //Helper.spacer();
      //ae.twoDimensionArray();

      // Aufgabe 2:
      //ListExercise le = new ListExercise();
      //
      //le.initSet(100_000, ListExercise.ListType.ARRAY_LIST);
      //sw.start();
      ////le.getAnimalsFromList();
      //le.removeAnimalsManual("ArrayList");
      //String alTime = sw.stop("Zeit ArrayList:\t\t");
      //
      //le.initSet(100_000, ListExercise.ListType.VECTOR);
      //sw.start();
      ////le.getAnimalsFromList();
      //le.removeAnimalsManual("Vector");
      //String vTime = sw.stop("Zeit Vector:\t\t");
      //
      //le.initSet(100_000, ListExercise.ListType.LINKED_LIST);
      //sw.start();
      ////le.getAnimalsFromList();
      //le.removeAnimalsManual("LinkedList");
      //String llTime = sw.stop("Zeit LinkedList:\t");
      //
      //System.out.println("--------------");
      //System.out.println(alTime);
      //System.out.println(vTime);
      //System.out.println(llTime);

      // Aufgabe 3:
      //SetsExercise se = new SetsExercise();
      //se.initSet(SetsExercise.SetType.HASH_SET);
      //se.getAnimalsFromList();
      //
      //se.initSet(SetsExercise.SetType.TREE_SET);
      //se.getAnimalsFromList();
      //se.setAnimalsAgain();

      // Aufgabe 4:
      //MapExercise me = new MapExercise();
      //me.initSet(MapExercise.MapType.HASH_MAP);
      //me.getAnimalsFromHash();
      //
      //me.initSet(MapExercise.MapType.TREE_MAP);
      //me.getAnimalsFromHash();

      // Hausaufgaben
      Homework hw = new Homework();
      List<Integer> numberList1 = new ArrayList<>();
      List<Integer> numberList2 = new ArrayList<>();

      numberList1 = hw.Task2(hw.Task1(numberList1, 3), Homework.OrderDirection.ASC);
      numberList2 = hw.Task2(hw.Task1(numberList2, 3), Homework.OrderDirection.DESC);

      System.out.println(hw.Task3(numberList1, numberList2));

      System.out.println("\n\n---------------------\n\n" + sw.stop("Gesamtzeit: \t\t"));
   }
}
