package de.shd.day9.app;

import java.net.URL;

import de.shd.day9.viewController.CalculatorView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein neuntes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 10.03.2017
 */
@SuppressWarnings("Duplicates")
public class MainDay9 extends Application
{
   private static final Logger LOG = LogManager.getLogger(MainDay9.class);

   /**
    * Hauptprogramm.
    *
    * @param args Kommandozeilenparameter
    */
   public static void main(String[] args)
   {
      LOG.info("application started");

      launch(args);

      Runtime.getRuntime().addShutdownHook(new Thread(() -> LOG.info("application closed\n-----")));
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
      URL cssResource = Thread.currentThread().getContextClassLoader().getResource("views/Main.css");
      //URL resource = Thread.currentThread().getContextClassLoader().getResource("views/LoginView.fxml");
      URL resource = Thread.currentThread().getContextClassLoader().getResource("views/CalculatorView.fxml");
      FXMLLoader loader = new FXMLLoader(resource);
      Parent rootParent = loader.load();
      Scene scene = new Scene(rootParent);
      scene.getStylesheets().addAll(cssResource != null ? cssResource.toExternalForm() : null);

      //LoginView loginViewController = loader.getController();
      //loginViewController.init();

      CalculatorView calculatorViewController = loader.getController();
      calculatorViewController.init();

      primaryStage.setScene(scene);
      //primaryStage.setTitle("Login");
      primaryStage.setTitle("Taschenrechner");

      primaryStage.show();
   }
}
