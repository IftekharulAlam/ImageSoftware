/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageapp;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Iftekharul Alam
 */
public class MainPageController implements Initializable {

    @FXML
    private ImageView myImageView;
    @FXML
    private Button openButton;
    @FXML
    private Button convertButton;

    private String openedImage;
    private WritableImage wImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void openButtonClicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        Stage stage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(stage);
        openedImage = selectedFile.toURI().toString();
        Image image = new Image(openedImage);
        PixelReader pixelReader = image.getPixelReader();

        System.out.println(image.getHeight());
        System.out.println(image.getWidth());

        System.out.println(pixelReader.getArgb(100, 100));

        myImageView.setImage(image);

    }

    @FXML
    private void convertButtonClicked(ActionEvent event) {
        Image image = new Image(openedImage);
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        //Creating a writable image 
        wImage = new WritableImage(width, height);

        //Reading color from the loaded image 
        PixelReader pixelReader = image.getPixelReader();

        //getting the pixel writer 
        PixelWriter writer = wImage.getPixelWriter();

        //Reading the color of the image 
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //Retrieving the color of the pixel of the loaded image   
                Color color = pixelReader.getColor(x, y);

                //Setting the color to the writable image 
                writer.setColor(x, y, color.grayscale());

            }
        }
        //Setting the view for the writable image 
        myImageView.setImage(wImage);
    }

    @FXML
    private void saveButtonclicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Alert a = new Alert(AlertType.NONE);

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg")
        );
        Stage s = new Stage();
        File selectedFile = fileChooser.showSaveDialog(s);
        if (selectedFile != null) {
            try {
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(wImage, null);

                ImageIO.write(renderedImage, "jpg", selectedFile);
            } catch (IOException ex) {
                // Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                a.setAlertType(AlertType.CONFIRMATION);
                a.show();
            }

        }

    }

}
