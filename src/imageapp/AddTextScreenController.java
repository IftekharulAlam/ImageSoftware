/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageapp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Iftekharul Alam
 */
public class AddTextScreenController implements Initializable {

    @FXML
    private TextField inputTextField;
    private String inputString;
    private String selectedFont;
    private int selectedSize;

    @FXML
    private Button AddButton;
    @FXML
    private ComboBox fontComboBox;
    @FXML
    private TextField sizeTextField;
    @FXML
    private Label exampleLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> fonts = new ArrayList<String>();
        fonts.add("Arial");
        fonts.add("Cambria");
        fonts.add("Consolas");
        fonts.add("Corbel");
        fonts.add("Ebrima");
        fonts.add("Gabriola");
        fonts.add("Georgia");
        fonts.add("Impact");
        fonts.add("Lucida Console");
        fonts.add("Malgun Gothic");

        fontComboBox.getItems().add(fonts.get(0));
        fontComboBox.getItems().add(fonts.get(1));
        fontComboBox.getItems().add(fonts.get(2));
        fontComboBox.getItems().add(fonts.get(3));
        fontComboBox.getItems().add(fonts.get(4));
        fontComboBox.getItems().add(fonts.get(5));
        fontComboBox.getItems().add(fonts.get(6));
        fontComboBox.getItems().add(fonts.get(7));
        fontComboBox.getItems().add(fonts.get(8));
        fontComboBox.getItems().add(fonts.get(9));
      

        // TODO
    }

    public String getText() {
        return inputString;
    }

    public String getFont() {
        return selectedFont;
    }

    public int getSize() {
        return selectedSize;
    }

    @FXML
    private void AddbuttonClicked(ActionEvent event) throws IOException {
        inputString = inputTextField.getText();
        selectedFont = fontComboBox.getValue().toString();
        selectedSize = Integer.parseInt(sizeTextField.getText());

        AddButton.getScene().getWindow().hide();

    }

}
