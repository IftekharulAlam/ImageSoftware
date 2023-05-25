/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageapp;

import ImageAppMainClassPackage.ImageAppMainClass;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
    private Button openButton;
    @FXML
    private Button convertButton;
    @FXML
    private Canvas myCanvas;

    private String openedImage;
    private WritableImage wImage;
    private int selection = 0;
    private GraphicsContext graphicContext;
    private String myText = "";
    private String selectedFont = "Verdana";
    private int selectedSize = 10;

    private double firstX;
    private double firstY;
    private double lastX;
    private double lastY;

    private ImageAppMainClass imageAppMainClass = new ImageAppMainClass();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setMyText(String text) {
        myText = text;

    }

    @FXML
    private void NewMenubuttonClicked(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        } catch (IOException ex) {
            //Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("My Image Editor");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void OpenMenuButtonClicked(ActionEvent event) {
        this.openButtonClicked(event);
    }

    @FXML
    private void SaveMenuButtonClicked(ActionEvent event) {
        this.saveButtonclicked(event);
    }

    @FXML
    private void SaveAsMenuButtonClicked(ActionEvent event) {

    }

    @FXML
    private void PreferenceMenuButtonClicked(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("PreferencePage.fxml"));
        } catch (IOException ex) {
            // Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("My Image Editor");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void quietMenunuButtonClicked(ActionEvent event) {

        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void openButtonClicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        Stage stage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(stage);
        openedImage = selectedFile.toURI().toString();
        Image image = new Image(openedImage);

        graphicContext = myCanvas.getGraphicsContext2D();
        graphicContext.drawImage(image, 2, 2, 500, 500);
        myCanvas.autosize();
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

        graphicContext.drawImage(wImage, 2, 2, 500, 500);
    }

    @FXML
    private void option1ButtonClicked(ActionEvent event) {
        selection = 1;
    }

    @FXML
    private void option2ButtonClicked(ActionEvent event) {
        selection = 3;
    }

    @FXML
    private void option3ButtonClicked(ActionEvent event) {
        selection = 4;
    }

    @FXML
    private void saveButtonclicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Alert a = new Alert(Alert.AlertType.NONE);

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg")
        );
        Stage s = new Stage();
        File selectedFile = fileChooser.showSaveDialog(s);
        if (selectedFile != null) {
            try {
                WritableImage writableImage = new WritableImage(1365, 400);

                myCanvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);

                ImageIO.write(renderedImage, "jpg", selectedFile);
            } catch (IOException ex) {
                // Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.show();
            }

        }
    }

    @FXML
    private void myCanvasMouseDragged(MouseEvent event) {
        if (selection == 1) {
            graphicContext.lineTo(event.getX(), event.getY());
            graphicContext.stroke();
        } else if (selection == 2) {
            //graphicContext.fillText(myText, event.getX(), event.getY());

        } else if (selection == 3) {

        } else if (selection == 4) {

        }

    }

    @FXML
    private void myCanvasMousePressed(MouseEvent event) {

        if (selection == 1) {
            graphicContext.beginPath();
            graphicContext.moveTo(event.getX(), event.getY());
            graphicContext.stroke();
        } else if (selection == 2) {

            graphicContext.setFont(Font.font(selectedFont, selectedSize));
            graphicContext.fillText(myText, event.getX(), event.getY());

        } else if (selection == 3) {
            firstX = event.getX();
            firstY = event.getY();

        } else if (selection == 4) {
            firstX = event.getX();
            firstY = event.getY();

        } else if (selection == 5) {
            firstX = event.getX();
            firstY = event.getY();

        }

    }

    @FXML
    private void AboutButtonClicked(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("About.fxml"));
        } catch (IOException ex) {
            // Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("My Image Editor");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void AddTextButtonClicked(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTextScreen.fxml"));
        Stage stage = new Stage();
        //stage.initOwner(btn1.getScene().getWindow());
        stage.setScene(new Scene((Parent) loader.load()));
        stage.setTitle("Text");
        // showAndWait will block execution until the window closes...
        stage.showAndWait();

        AddTextScreenController controller = loader.getController();
        myText = controller.getText();
        selectedFont = controller.getFont();
        selectedSize = controller.getSize();

        if (myText != "") {
            selection = 2;
        }

    }

    @FXML
    private void clearButtonClicked(ActionEvent event) {
        graphicContext.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
        Image image = new Image(openedImage);

        graphicContext = myCanvas.getGraphicsContext2D();
        graphicContext.drawImage(image, 2, 2, 500, 500);
    }

    @FXML
    private void onKeyPressed(KeyEvent event) {

        if (selection == 1) {
//            graphicContext.beginPath();
//            graphicContext.moveTo(event.getX(), event.getY());
//            graphicContext.stroke();
        } else if (selection == 2) {
            //  graphicContext.fillText(myText, event.getX(), event.getY());

        } else if (selection == 3) {

            graphicContext.moveTo(100, 100);

        }

    }

    @FXML
    private void onKeyReleased(KeyEvent event) {
    }

    @FXML
    private void myCanvasMouseReleased(MouseEvent event) {

        if (selection == 1) {

        } else if (selection == 2) {

        } else if (selection == 3) {
            lastX = event.getX();
            lastY = event.getY();
            graphicContext.fillRect(firstX, firstY, lastX - firstX, lastY - firstY);

        } else if (selection == 4) {
            lastX = event.getX();
            lastY = event.getY();
            graphicContext.fillOval(firstX, firstY, lastX - firstX, lastX - firstX);

        } else if (selection == 5) {
            // graphicContext.fillPolygon(xPoints, yPoints, selection);
            lastX = event.getX();
            lastY = event.getY();
            graphicContext.fillRoundRect(firstX, firstY, lastX - firstX, lastX - firstX, 10.0, 10.0);
        }

    }

    @FXML
    private void option4ButtonClicked(ActionEvent event) {
        selection = 5;
    }

    @FXML
    private void AddColorButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ColorPage.fxml"));
        Stage stage = new Stage();
        //stage.initOwner(btn1.getScene().getWindow());
        stage.setScene(new Scene((Parent) loader.load()));
        stage.setTitle("Color");
        // showAndWait will block execution until the window closes...
        stage.showAndWait();

        ColorPageController controller = loader.getController();

    }

}
