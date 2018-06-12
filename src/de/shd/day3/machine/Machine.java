package de.shd.day3.machine;

import java.util.List;

import de.shd.day3.animals.StallAnimal;

/**
 * Ein drittes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 18.01.2017
 */
@SuppressWarnings("Duplicates")
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
