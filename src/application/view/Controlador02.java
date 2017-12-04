package application.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;

public class Controlador02 implements Initializable {
	@FXML
	JFXButton idEfectos;
	@FXML
	ImageView idImagen;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		idEfectos.setOnMouseClicked(event -> {
				idImagen.setEffect(new GaussianBlur(10));
		});

	}

}
