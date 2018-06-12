package de.shd.day5.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.google.gson.GsonBuilder;
import de.shd.day5.animals.StallAnimal;
import de.shd.utils.Helper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Ein fünftes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 01.02.2017
 */
public class StallDAO
{
   /**
    * Konvertiert eine Datei in eine andere Datei.
    * Dabei sind auch auch andere Datei Typen möglich.
    *
    * @param inputFile  Die zu konvertierende Datei.
    * @param outputFile Die neue Datei.
    */
   public void convertFile(File inputFile, File outputFile)
   {
      writeData(outputFile, readData(inputFile));
   }

   /**
    * Schreibt Daten aus einer Liste in eine Datei.
    *
    * @param stallFile    Die Datei.
    * @param stallAnimals Die Liste mit Daten.
    */
   public void writeData(File stallFile, List<StallAnimal> stallAnimals)
   {
      try
      {
         switch( Helper.getFileExtension(stallFile) )
         {
            case "csv":
               writeCSV(stallFile, stallAnimals);
               break;
            case "xml":
               writeXML(stallFile, stallAnimals);
               break;
            case "json":
               writeJSON(stallFile, stallAnimals);
               break;
         }
      }
      catch(Exception e)
      {
         e.getMessage();
      }
   }

   /**
    * Liest Daten aus einer Datei und sie als Liste zurück.
    *
    * @param stallFile Datei mit dem Inhalt.
    * @return die Liste mit den Daten.
    */
   public List<StallAnimal> readData(File stallFile)
   {
      try
      {
         switch( Helper.getFileExtension(stallFile) )
         {
            case "csv":
               return readCSV(stallFile);
            case "xml":
               return readXML(stallFile);
            case "json":
               return readJSON(stallFile);
            default:
               return new ArrayList<>();
         }
      }
      catch(Exception e)
      {
         e.getMessage();
         return new ArrayList<>();
      }
   }

   /**
    * Beschreibt eine CSV-Datei mit der Liste der Stalltiere.
    *
    * @param stallFile    Die Datei, wo rein geschrieben werden soll.
    * @param stallAnimals Die Liste der Tiere.
    * @throws FileNotFoundException Die Datei könnte möglicherweise nicht vorhanden sein.
    */
   private void writeCSV(File stallFile, List<StallAnimal> stallAnimals) throws FileNotFoundException
   {
      PrintWriter pw = new PrintWriter(stallFile);

      for( StallAnimal animal : stallAnimals )
      {
         pw.println(animal.getName() + ";" + animal.getWeight() + ";" + animal.getClass().getName());
      }

      pw.flush();
      pw.close();
   }

   /**
    * Liest die Liste der Stalltiere aus einer CSV-Datei.
    *
    * @param stallFile Die Datei, aus der gelesen werden soll.
    * @throws Exception Verschiedene Fehler möglich.
    */
   private List<StallAnimal> readCSV(File stallFile) throws Exception
   {
      List<StallAnimal> stallAnimals = new ArrayList<>();

      BufferedReader reader = new BufferedReader(new FileReader(stallFile));

      String line;
      while( (line = reader.readLine()) != null )
      {
         String[] lineSplit = line.split(";");

         StallAnimal stallAnimal = (StallAnimal) Class.forName(lineSplit[2]).newInstance();
         stallAnimal.setName(lineSplit[0]);
         stallAnimal.setWeight(Integer.parseInt(lineSplit[1]));

         stallAnimals.add(stallAnimal);
      }

      return stallAnimals;
   }

   /**
    * Beschreibt eine XML-Datei mit der Liste der Stalltiere.
    *
    * @param stallFile    Die Datei, wo rein geschrieben werden soll.
    * @param stallAnimals Die Liste der Tiere.
    * @throws Exception Verschiedene Fehler möglich.
    */
   private void writeXML(File stallFile, List<StallAnimal> stallAnimals) throws Exception
   {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

      Document doc = docBuilder.newDocument();
      Element rootElem = doc.createElement("stall");
      doc.appendChild(rootElem);

      for( StallAnimal animal : stallAnimals )
      {
         Element animalElem = doc.createElement("animal");
         rootElem.appendChild(animalElem);

         Attr nameAttr = doc.createAttribute("name");
         nameAttr.setValue(animal.getName());
         animalElem.setAttributeNode(nameAttr);

         Element weightElem = doc.createElement("weight");
         weightElem.appendChild(doc.createTextNode(Integer.toString(animal.getWeight())));
         animalElem.appendChild(weightElem);

         Element typeElem = doc.createElement("type");
         typeElem.appendChild(doc.createTextNode(animal.getClass().getName()));
         animalElem.appendChild(typeElem);
      }

      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
      transformer.transform(new DOMSource(doc), new StreamResult(stallFile));

      System.out.println("Datei gespeichert!");
   }

   /**
    * Liest die Liste der Stalltiere aus einer XML-Datei.
    *
    * @param stallFile Die Datei, aus der gelesen werden soll.
    * @throws Exception Verschiedene Fehler möglich.
    */
   private List<StallAnimal> readXML(File stallFile) throws Exception
   {
      List<StallAnimal> stallAnimals = new ArrayList<>();

      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      Document doc = docBuilder.parse(stallFile);

      doc.getDocumentElement().normalize();

      NodeList nList = doc.getElementsByTagName("animal");

      for( int temp = 0; temp < nList.getLength(); temp++ )
      {
         Node nNode = nList.item(temp);

         if( nNode.getNodeType() != Node.ELEMENT_NODE )
         {
            continue;
         }

         Element elem = (Element) nNode;

         StallAnimal stallAnimal = (StallAnimal) Class.forName(elem.getElementsByTagName("type").item(0).getTextContent()).newInstance();
         stallAnimal.setName(elem.getAttribute("name"));
         stallAnimal.setWeight(Integer.parseInt(elem.getElementsByTagName("weight").item(0).getTextContent()));

         stallAnimals.add(stallAnimal);
      }

      return stallAnimals;
   }

   /**
    * Beschreibt eine JSON-Datei mit der Liste der Stalltiere.
    *
    * @param stallFile    Die Datei, wo rein geschrieben werden soll.
    * @param stallAnimals Die Liste der Tiere.
    * @throws IOException Dateizugriffs probleme.
    */
   @SuppressWarnings("unchecked")
   private void writeJSON(File stallFile, List<StallAnimal> stallAnimals) throws IOException
   {
      JSONObject rootObj = new JSONObject();
      JSONArray stallList = new JSONArray();

      for( StallAnimal animal : stallAnimals )
      {
         JSONObject animalObj = new JSONObject();
         animalObj.put("name", animal.getName());
         animalObj.put("weight", animal.getWeight());
         animalObj.put("type", animal.getClass().getName());

         stallList.add(animalObj);
      }

      rootObj.put("stall", stallList);

      FileWriter file = new FileWriter(stallFile);
      file.write(new GsonBuilder().setPrettyPrinting().create().toJson(rootObj));
      file.flush();
      file.close();
   }

   /**
    * Liest die Liste der Stalltiere aus einer JSON-Datei.
    *
    * @param stallFile Die Datei, aus der gelesen werden soll.
    * @throws Exception Verschiedene Fehler möglich.
    */
   private List<StallAnimal> readJSON(File stallFile) throws Exception
   {
      List<StallAnimal> stallAnimals = new ArrayList<>();

      JSONParser parser = new JSONParser();
      JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(stallFile));

      JSONArray stallList = (JSONArray) jsonObj.get("stall");

      for( Object animal : stallList )
      {
         JSONObject animalObj = (JSONObject) animal;

         System.out.println(animalObj.get("type"));
         System.out.println(animalObj.get("name"));
         System.out.println(animalObj.get("weight"));

         StallAnimal stallAnimal = (StallAnimal) Class.forName((String) animalObj.get("type")).newInstance();
         stallAnimal.setName((String) animalObj.get("name"));
         stallAnimal.setWeight(Integer.parseInt(String.valueOf(animalObj.get("weight"))));

         stallAnimals.add(stallAnimal);
      }

      return stallAnimals;
   }
}
