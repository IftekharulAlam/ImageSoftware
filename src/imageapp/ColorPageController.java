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
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Iftekharul Alam
 */
public class ColorPageController implements Initializable {

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
    private Color myColor;
    @FXML
    private Button saveButton;

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

    public Color returnColor() {
        return myColor;

    }

    @FXML
    private void saveButtonClicked(ActionEvent event) {

        if (hexTextField.getText() == "") {
            int red = Integer.parseInt(redTextfield.getText());
            int green = Integer.parseInt(greenTextField.getText());
            int blue = Integer.parseInt(blueTextField.getText());
            myColor = Color.rgb(red, green, blue);
            saveButton.getScene().getWindow().hide();

        } else {
            String s = "0x" + hexTextField.getText();
            myColor = Color.web(s);
            saveButton.getScene().getWindow().hide();
        }

    }

    @FXML
    private void greenButtonClicked(ActionEvent event) {
        myColor = Color.GREEN;
        greenButton.getScene().getWindow().hide();

    }

    @FXML
    private void blueButtonClicked(ActionEvent event) {
        myColor = Color.BLUE;
        blueButton.getScene().getWindow().hide();
    }

    @FXML
    private void redButtonClicked(ActionEvent event) {
        myColor = Color.RED;
        redButton.getScene().getWindow().hide();
    }

    @FXML
    private void yellowButtonClicked(ActionEvent event) {
        myColor = Color.YELLOW;
        yellowButton.getScene().getWindow().hide();
    }

}
