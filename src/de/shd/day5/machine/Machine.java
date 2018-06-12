package de.shd.day5.machine;

import java.util.List;

import de.shd.day5.animals.StallAnimal;

/**
 * Ein f�nftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
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
