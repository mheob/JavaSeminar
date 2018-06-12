package de.shd.day6.machine;

import java.util.List;

import de.shd.day6.animals.StallAnimal;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@FunctionalInterface
public interface Machine
{
   /**
    * Führt eine gewünschte Arbeit aus.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   List<StallAnimal> work(List<StallAnimal> animals);
}
