/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML
    private Button AddButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public String getText() {
        return inputString;
    }

    @FXML
    private void AddbuttonClicked(ActionEvent event) throws IOException {
        inputString = inputTextField.getText();
        AddButton.getScene().getWindow().hide();

    }

}
