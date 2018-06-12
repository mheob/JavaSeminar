package de.shd.day7.homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein siebtes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 24.02.2017
 */
@SuppressWarnings("SameParameterValue")
public class BankProgram
{
   private static final Logger LOG = LogManager.getLogger(BankProgram.class);
   private boolean isReadyWithdraw;
   private boolean isReadyTransfer;

   public synchronized void withdrawMoney(Account account, int amount)
   {
      LOG.info(account.getAccountName() + " hat vor dem Abheben " + account.getAccountBalance() + " € auf dem Konto.");

      isReadyWithdraw = false;

      if( account.getAccountBalance() >= amount )
      {
         try
         {
            Thread.sleep(1500);
         }
         catch(InterruptedException e)
         {
            LOG.error(e.getMessage());
         }

         account.withdraw(amount);
         isReadyWithdraw = true;
         LOG.info("Von dem Konto \"" + account.getAccountName() + "\" wurden " + amount + " € abgehoben.");
      }
      else
      {
         LOG.warn("Es ist kein Dispokredit eingerichtet --> Aktion nicht möglich!");
      }

      LOG.info(account.getAccountName() + " hat nach dem Abheben " + account.getAccountBalance() + " € auf dem Konto.");
   }

   public synchronized void transferMoney(Account accountTransmitter, Account accountReceiver, int amount)
   {
      LOG.info(accountTransmitter.getAccountName() + " hat vor dem Senden der Überweisung " + accountTransmitter.getAccountBalance() + " € auf dem Konto.");
      LOG.info(accountReceiver.getAccountName() + " hat vor dem Erhalten der Überweisung " + accountReceiver.getAccountBalance() + " € auf dem Konto.");

      isReadyTransfer = false;

      if( accountTransmitter.getAccountBalance() >= amount )
      {
         accountTransmitter.withdraw(amount);
         accountReceiver.deposit(amount);
         isReadyTransfer = true;
         LOG.info("Von dem Konto \"" + accountTransmitter.getAccountName() + "\" wurden " + amount + " € auf das Konto \"" +
                  accountReceiver.getAccountName() + "\" überwiesen.");
      }
      else
      {
         LOG.warn("Es ist kein Dispokredit eingerichtet --> Aktion nicht möglich!");
      }

      LOG.info(accountTransmitter.getAccountName() + " hat nach dem Senden der Überweisung " + accountTransmitter.getAccountBalance() + " € auf dem Konto.");
      LOG.info(accountReceiver.getAccountName() + " hat nach dem Erhalten der Überweisung " + accountReceiver.getAccountBalance() + " € auf dem Konto.");
   }

   public boolean isReadyWithdraw()
   {
      return isReadyWithdraw;
   }

   public boolean isReadyTransfer()
   {
      return isReadyTransfer;
   }
}
