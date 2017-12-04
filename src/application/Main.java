package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
	    FXMLLoader loader =new FXMLLoader(getClass().getResource("view/Vista.fxml"));
//	    Font.loadFont(getClass().getResourceAsStream("../view/font/hazel grace.ttf"), 20);
	    
	    //Font.loadFont(getClass().getResourceAsStream("../font/CashCurrency.ttf"), 20);
	    //Font.loadFont(getClass().getResourceAsStream("../font/hazel grace.ttf"), 20);
        AnchorPane pane=loader.load();
        
        Scene scene=new Scene(pane);
        scene.getStylesheets().addAll(getClass().getResource("application.css").toExternalForm());
        Image image = new Image("img/pingui.jpg");
		scene.setCursor(new ImageCursor(image));
        primaryStage.setTitle("Galery");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
