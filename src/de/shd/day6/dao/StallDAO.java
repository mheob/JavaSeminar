package de.shd.day6.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.google.gson.GsonBuilder;
import de.shd.day6.animals.Gender;
import de.shd.day6.animals.StallAnimal;
import de.shd.utils.Helper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Ein sechstes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 08.02.2017
 */
@SuppressWarnings({"Duplicates", "unused"})
public class StallDAO
{
   private static final Logger LOGGER = Logger.getLogger(StallDAO.class.getName());
   private static final String ANIMAL = "animal";
   private static final String STALL = "stall";
   private static final String NAME = "name";
   private static final String WEIGHT = "weight";
   private static final String GENDER = "gender";
   private static final String TYPE = "type";

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
            default:
         }
      }
      catch(Exception e)
      {
         LOGGER.log(Level.SEVERE, "Die Datei konnte nicht beschrieben werden", e);
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
         LOGGER.log(Level.SEVERE, "Aus der Datei konnte nicht gelesen werden", e);
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
         pw.println(animal.getName() + ";" +
                    animal.getWeight() + ";" +
                    animal.getClass().getName() + ";" +
                    animal.getGender());
      }

      pw.flush();
      pw.close();
   }

   /**
    * Liest die Liste der Stalltiere aus einer CSV-Datei.
    *
    * @param stallFile Die Datei, aus der gelesen werden soll.
    */
   private List<StallAnimal> readCSV(File stallFile)
   {
      List<StallAnimal> stallAnimals = new ArrayList<>();

      try (BufferedReader reader = new BufferedReader(new FileReader(stallFile)))
      {
         String line;
         while( (line = reader.readLine()) != null )
         {
            String[] lineSplit = line.split(";");

            StallAnimal stallAnimal = (StallAnimal) Class.forName(lineSplit[2]).newInstance();
            stallAnimal.setName(lineSplit[0]);
            stallAnimal.setWeight(Integer.parseInt(lineSplit[1]));
            stallAnimal.setGender(Gender.convert(lineSplit[3]));

            stallAnimals.add(stallAnimal);
         }
      }
      catch(Exception e)
      {
         LOGGER.log(Level.SEVERE, "Aus der CSV-Datei konnte nicht gelesen werden", e);
      }

      return stallAnimals;
   }

   /**
    * Beschreibt eine XML-Datei mit der Liste der Stalltiere.
    *
    * @param stallFile    Die Datei, wo rein geschrieben werden soll.
    * @param stallAnimals Die Liste der Tiere.
    * @throws ParserConfigurationException Verschiedene Fehler möglich.
    * @throws TransformerException         Verschiedene Fehler möglich.
    */

   private void writeXML(File stallFile, List<StallAnimal> stallAnimals) throws ParserConfigurationException, TransformerException
   {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

      Document doc = docBuilder.newDocument();
      Element rootElem = doc.createElement(STALL);
      doc.appendChild(rootElem);

      for( StallAnimal animal : stallAnimals )
      {
         Element animalElem = doc.createElement(ANIMAL);
         rootElem.appendChild(animalElem);

         Attr nameAttr = doc.createAttribute(NAME);
         nameAttr.setValue(animal.getName());
         animalElem.setAttributeNode(nameAttr);

         Element weightElem = doc.createElement(WEIGHT);
         weightElem.appendChild(doc.createTextNode(Integer.toString(animal.getWeight())));
         animalElem.appendChild(weightElem);

         Element typeElem = doc.createElement(TYPE);
         typeElem.appendChild(doc.createTextNode(animal.getClass().getName()));
         animalElem.appendChild(typeElem);

         Element genderElem = doc.createElement(GENDER);
         genderElem.appendChild(doc.createTextNode(animal.getGender()));
         animalElem.appendChild(genderElem);
      }

      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
      transformer.transform(new DOMSource(doc), new StreamResult(stallFile));

      LOGGER.log(Level.INFO, "Datei gespeichert!");
   }

   /**
    * Liest die Liste der Stalltiere aus einer XML-Datei.
    *
    * @param stallFile Die Datei, aus der gelesen werden soll.
    * @throws ParserConfigurationException Verschiedene Fehler möglich.
    * @throws IOException                  Verschiedene Fehler möglich.
    * @throws SAXException                 Verschiedene Fehler möglich.
    * @throws ClassNotFoundException       Verschiedene Fehler möglich.
    * @throws IllegalAccessException       Verschiedene Fehler möglich.
    * @throws InstantiationException       Verschiedene Fehler möglich.
    */
   private List<StallAnimal> readXML(File stallFile)
         throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException, IllegalAccessException, InstantiationException
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

         StallAnimal stallAnimal = (StallAnimal) Class.forName(elem.getElementsByTagName(TYPE).item(0).getTextContent()).newInstance();
         stallAnimal.setName(elem.getAttribute("name"));
         stallAnimal.setWeight(Integer.parseInt(elem.getElementsByTagName(WEIGHT).item(0).getTextContent()));
         stallAnimal.setGender(Gender.convert(elem.getElementsByTagName(GENDER).item(0).getTextContent()));

         stallAnimals.add(stallAnimal);
      }

      return stallAnimals;
   }

   /**
    * Beschreibt eine JSON-Datei mit der Liste der Stalltiere.
    *
    * @param stallFile    Die Datei, wo rein geschrieben werden soll.
    * @param stallAnimals Die Liste der Tiere.
    */
   @SuppressWarnings("unchecked")
   private void writeJSON(File stallFile, List<StallAnimal> stallAnimals)
   {
      JSONObject rootObj = new JSONObject();
      JSONArray stallList = new JSONArray();

      for( StallAnimal animal : stallAnimals )
      {
         JSONObject animalObj = new JSONObject();
         animalObj.put("name", animal.getName());
         animalObj.put(WEIGHT, animal.getWeight());
         animalObj.put(TYPE, animal.getClass().getName());
         animalObj.put(GENDER, animal.getGender());

         stallList.add(animalObj);
      }

      rootObj.put(STALL, stallList);

      try (FileWriter file = new FileWriter(stallFile))
      {
         file.write(new GsonBuilder().setPrettyPrinting().create().toJson(rootObj));
         file.flush();
      }
      catch(IOException e)
      {
         LOGGER.log(Level.SEVERE, "Die JSON-Datei konnte nicht beschrieben werden", e);
      }
   }

   /**
    * Liest die Liste der Stalltiere aus einer JSON-Datei.
    *
    * @param stallFile Die Datei, aus der gelesen werden soll.
    * @throws ClassNotFoundException Verschiedene Fehler möglich.
    * @throws IllegalAccessException Verschiedene Fehler möglich.
    * @throws InstantiationException Verschiedene Fehler möglich.
    * @throws IOException            Verschiedene Fehler möglich.
    * @throws ParseException         Verschiedene Fehler möglich.
    */
   private List<StallAnimal> readJSON(File stallFile) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, ParseException
   {
      List<StallAnimal> stallAnimals = new ArrayList<>();

      JSONParser parser = new JSONParser();
      JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(stallFile));

      JSONArray stallList = (JSONArray) jsonObj.get(STALL);

      for( Object animal : stallList )
      {
         JSONObject animalObj = (JSONObject) animal;

         StallAnimal stallAnimal = (StallAnimal) Class.forName((String) animalObj.get(TYPE)).newInstance();
         stallAnimal.setName((String) animalObj.get("name"));
         stallAnimal.setWeight(Integer.parseInt(String.valueOf(animalObj.get(WEIGHT))));
         stallAnimal.setGender(Gender.convert((String) animalObj.get(GENDER)));

         stallAnimals.add(stallAnimal);
      }

      return stallAnimals;
   }
}
