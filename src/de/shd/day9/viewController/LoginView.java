package de.shd.day9.viewController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Ein neuntes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 10.03.2017
 */
public class LoginView
{
   @FXML
   private TextField username;
   @FXML
   private PasswordField password;
   @FXML
   private Button login;
   @FXML
   private Button cancel;

   public void init()
   {
      login.setOnAction(event -> onButtonLoginClicked());

      cancel.setOnAction(event -> Platform.exit());
   }

   private void onButtonLoginClicked()
   {
      System.out.println("Benutzer: " + username.getText() + " und Passwort: " + password.getText());
   }
}
