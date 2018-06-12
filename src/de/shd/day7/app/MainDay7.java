package de.shd.day7.app;

import de.shd.day7.exercises.ThreadFinishedListener;
import de.shd.day7.homework.Account;
import de.shd.day7.homework.BankProgram;
import de.shd.utils.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein siebtes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 24.02.2017
 */
@SuppressWarnings("Duplicates")
public class MainDay7
{
   private static final Logger LOG = LogManager.getLogger(MainDay7.class);

   private static ThreadFinishedListener listener = LOG::info;
   //private static ThreadFinishedListener listener = taskName -> LOG.info(taskName);
   //private static ThreadFinishedListener listener = new ThreadFinishedListener()
   //{
   //   @Override
   //   public void onFinished(String taskName)
   //   {
   //      LOG.info(taskName);
   //   }
   //};

   private MainDay7()
   {
   }

   /**
    * Hauptprogramm.
    *
    * @param args Kommandozeilenparameter
    */
   public static void main(String[] args)
   {
      LOG.info("application startet");

      // Hausaufgaben:
      BankProgram banking = new BankProgram();
      Account hans = new Account(1000, "Kto_Hans");
      Account peter = new Account(1000, "Kto_Peter");

      new Thread(() -> banking.withdrawMoney(hans, 1000)).start();
      new Thread(() -> banking.transferMoney(hans, peter, 1000)).start();

      // Aufgaben:
      //learningThreading();

      Runtime.getRuntime().addShutdownHook(new Thread(() -> LOG.info("application closed\n-----")));
   }

   private static void learningThreading()
   {
      StopWatch sw = new StopWatch();
      sw.start();
      exercise1();
      exercise2();
      System.out.println(sw.stop("Gesamtzeit Run 1: \t\t"));
      sw.reset();

      // Aufgaben 4 + 5:
      sw.start();
      //new Thread(new Runnable()
      //{
      //   @Override
      //   public void run()
      //   {
      //      exercise1();
      //   }
      //}).start();
      //new Thread(() -> exercise2()).start();
      new Thread(MainDay7::exercise1).start();
      new Thread(MainDay7::exercise2).start();
      System.out.println("\n---------------------\n\n" + sw.stop("Gesamtzeit Run 2: \t\t"));
      sw.reset();
   }

   private static void exercise1()
   {
      try
      {
         Thread.sleep(500);
         listener.onFinished("exercise1()");
      }
      catch(InterruptedException e)
      {
         e.printStackTrace();
      }
   }

   private static void exercise2()
   {
      try
      {
         Thread.sleep(1000);
         listener.onFinished("exercise2()");
      }
      catch(InterruptedException e)
      {
         e.printStackTrace();
      }
   }
}
