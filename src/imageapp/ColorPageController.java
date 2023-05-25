/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Iftekharul Alam
 */
public class ColorPageController implements Initializable {

    @FXML
    private Button saveButtonColor;
    @FXML
    private TextField redTextfield;
    @FXML
    private TextField greenTextField;
    @FXML
    private TextField blueTextField;
    @FXML
    private TextField hexTextField;
    @FXML
    private Button greenButton;
    @FXML
    private Button blueButton;
    @FXML
    private Button redButton;
    @FXML
    private Button yellowButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        greenButton.setStyle("-fx-background-color: #008000");
        blueButton.setStyle("-fx-background-color: #0000FF");
        redButton.setStyle("-fx-background-color: #ff0000");
        yellowButton.setStyle("-fx-background-color: #FFFF00");

    }

    @FXML
    private void saveButtonClicked(ActionEvent event) {
    }

    @FXML
    private void greenButtonClicked(ActionEvent event) {
         System.out.println("Green");
    }

    @FXML
    private void blueButtonClicked(ActionEvent event) {
        System.out.println("Blue");
    }

    @FXML
    private void redButtonClicked(ActionEvent event) {
         System.out.println("Red");
    }

    @FXML
    private void yellowButtonClicked(ActionEvent event) {
         System.out.println("yellow");
    }

}
