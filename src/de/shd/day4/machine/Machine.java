package de.shd.day4.machine;

import java.util.List;

import de.shd.day4.animals.StallAnimal;

/**
 * Ein viertes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 25.01.2017
 */
@SuppressWarnings("Duplicates")
public interface Machine
{
   /**
    * F�hrt eine gew�nschte Arbeit aus.
    *
    * @param animals eine Liste mit Stalltieren
    * @return eine Liste mit Stalltieren
    */
   List<StallAnimal> work(List<StallAnimal> animals);
}
