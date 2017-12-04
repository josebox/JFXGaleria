package application.view;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import application.Main;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controlador implements Initializable {

	@FXML
	private MediaView video;

	@FXML
	AnchorPane idGaleria;
	@FXML
	AnchorPane idVideos;
	@FXML
	AnchorPane idHistory;
	@FXML
	AnchorPane idPaisaje;
	// paneles fotos
	@FXML
	AnchorPane f1;
	@FXML
	AnchorPane f2;
	@FXML
	AnchorPane f3;
	// notones paneles
	@FXML
	JFXButton efecto1;
	@FXML
	JFXButton der;
	@FXML
	JFXButton izq;
	@FXML
	JFXButton btnG;
	@FXML
	JFXButton btnV;
	@FXML
	JFXButton btnH;
	@FXML
	JFXButton btnP;
	@FXML
	JFXButton nav;

	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Media media2 = new Media(getClass().getResource("M.mp4").toExternalForm());
		MediaPlayer player = new MediaPlayer(media2);
		video.setMediaPlayer(player);
		player.setVolume(0);
		player.play();
		// ---------------------------------------------//
		translateAnimation(0.5, idGaleria, 650);
		translateAnimation(0.5, idVideos, 650);
		translateAnimation(0.5, f1, 650);
		translateAnimation(0.5, f2, 650);
		/**
		 * boton que te rediricciona a la galeria
		 */
		btnG.setOnMouseClicked(event -> {

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), idGaleria);
			translateTransition1.setByX(-650);
			translateTransition1.play();

		});

		btnV.setOnMouseClicked(event -> {

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), idVideos);
			translateTransition1.setByX(-650);
			translateTransition1.play();

		});

	}
	
    public void showSendProfile() {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Vista2.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage sendStage = new Stage();
            Image image = new Image("file:Resource/homer.png");
            sendStage.setTitle("Superheader");
           
//            );
//    
//            ColorAdjust colorAdjust = new ColorAdjust();
//            colorAdjust.setContrast(1);
//            colorAdjust.setHue(0);
//            colorAdjust.setBrightness(0);
//            colorAdjust.setSaturation(0);
////            ceiling_image.setEffect(colorAdjust);
//            ceiling_image.setEffect(new GaussianBlur(5));
//            refugees.setClip(ceiling);
//            refugees.setEffect(new GaussianBlur(5));
            
            Scene scene = new Scene(page);
             sendStage.setScene(scene);

            
            sendStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	int showSlide = 0;

	@FXML
	void nextAction(ActionEvent event) {

		if (showSlide == 0) {
			translateAnimation(0.5, f1, -650);
			showSlide++; // showSlide=1
		} else if (showSlide == 1) {

			translateAnimation(0.5, f2, -650);
			showSlide++; // showSlide=2

		} else {
			System.out.println("No more slides");
		}

	}

	@FXML
	void backAction(ActionEvent event) {

		if (showSlide == 0) {
			System.out.println("No more slide");
		} else if (showSlide == 1) {
			translateAnimation(0.5, f1, 650);
			showSlide--; // showSlide=0

		} else if (showSlide == 2) {
			translateAnimation(0.5, f2, 650);
			showSlide--; // showSlide=1

		}

	}
}
