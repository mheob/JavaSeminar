package de.shd.day8.machine;

import java.util.List;

import de.shd.day8.animals.StallAnimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@FunctionalInterface
public interface Machine
{
   Logger LOG = LogManager.getLogger(Machine.class);

   /**
    * Reinigt die Maschine nach der Arbeit.
    *
    * @param animals die Tiere im Stall
    */
   default void cleaning(List<StallAnimal> animals)
   {
      float count = animals.size() * 1.5F;

      LOG.info("Die Reinigung der Maschine dauerte " + count + " Stunden.");
   }

   /**
    * Führt eine gewünschte Arbeit aus.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   List<StallAnimal> work(List<StallAnimal> animals);
}
