package de.shd.day9.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * Ein neuntes Programm in unserer Java-Schulung.
 *
 * @author ALB
 * @version 1.0 vom 10.03.2017
 */
public class CalculatorView
{
   @FXML
   private VBox container;
   @FXML
   private TextField result;
   @FXML
   private Button clearAll;
   @FXML
   private Button clear;
   @FXML
   private Button back;
   @FXML
   private Button divide;
   @FXML
   private Button multiply;
   @FXML
   private Button nine;
   @FXML
   private Button eight;
   @FXML
   private Button seven;
   @FXML
   private Button four;
   @FXML
   private Button five;
   @FXML
   private Button six;
   @FXML
   private Button subtraction;
   @FXML
   private Button one;
   @FXML
   private Button two;
   @FXML
   private Button three;
   @FXML
   private Button addition;
   @FXML
   private Button zero;
   @FXML
   private Button comma;
   @FXML
   private Button calculate;

   public void init()
   {
      //noinspection Convert2MethodRef
      container.setOnKeyPressed(event -> checkOnKeyPressed(event));

      zero.setOnAction(event -> onNumberAdded("0"));
      one.setOnAction(event -> onNumberAdded("1"));
      two.setOnAction(event -> onNumberAdded("2"));
      three.setOnAction(event -> onNumberAdded("3"));
      four.setOnAction(event -> onNumberAdded("4"));
      five.setOnAction(event -> onNumberAdded("5"));
      six.setOnAction(event -> onNumberAdded("6"));
      seven.setOnAction(event -> onNumberAdded("7"));
      eight.setOnAction(event -> onNumberAdded("8"));
      nine.setOnAction(event -> onNumberAdded("9"));

      clearAll.setOnAction(event -> result.setText("0"));
   }

   private void checkOnKeyPressed(KeyEvent event)
   {
      if( event.getCode().isDigitKey() && event.getText().matches("\\d") )
      {
         onNumberAdded(event.getText());
      }

      if( event.getText().equals(",") )
      {
         onNumberAdded(".");
      }
   }

   private void onNumberAdded(String number)
   {
      if( result.getText().equals("0") )
      {
         result.setText("");
      }

      result.appendText(number);
   }
}
