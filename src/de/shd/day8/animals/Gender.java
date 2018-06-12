package de.shd.day8.animals;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
public enum Gender
{
   FEMALE, MALE;

   public static Gender convert(String str)
   {
      for( Gender gender : Gender.values() )
      {
         if( gender.toString().equals(str) )
         {
            return gender;
         }
      }

      return null;
   }
}
