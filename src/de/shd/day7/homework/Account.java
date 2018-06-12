package de.shd.day7.homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein siebtes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 24.02.2017
 */
public class Account
{
   private static final Logger LOG = LogManager.getLogger(Account.class);

   private int accountBalance;
   private String accountName;

   public Account(int accountBalance, String accountName)
   {
      this.accountBalance = accountBalance;
      this.accountName = accountName;
   }

   void deposit(int amount)
   {
      //setAccountBalance(getAccountBalance() + amount);
      accountBalance += amount;
   }

   void withdraw(int amount)
   {
      //setAccountBalance(getAccountBalance() - amount);
      accountBalance -= amount;
   }

   public int getAccountBalance()
   {
      return accountBalance;
   }

   public void setAccountBalance(int accountBalance)
   {
      if( accountBalance < 0 )
      {
         LOG.warn("Es ist kein Dispokredit eingerichtet --> Aktion nicht möglich!");
      }
      else
      {
         this.accountBalance = accountBalance;
      }
   }

   public String getAccountName()
   {
      return accountName;
   }
}
