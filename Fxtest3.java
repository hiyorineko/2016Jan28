/**
 *	写経です
 *	http://krr.blog.shinobi.jp/javafx/javafx%20scene%E3%83%91%E3%83%83%E3%82%B1%E3%83%BC%E3%82%B8
 */

import java.io.File;
import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Fxtest3 extends Application{
	
	@Override
	public void start(Stage mainStage) throws Exception{
		
		Label l1 = new Label("Sceneパッケージテスト");
		
		Scene sc1 = new Scene(l1,400,200,Color.WHITE);
		
		String uri = new File("ziki.png").toURI().toString();;
		Image img = new Image(uri);
		ImageCursor cursor = new ImageCursor(img,img.getWidth()/2,img.getHeight());
		sc1.setCursor(cursor);
		
		mainStage.setScene(sc1);
		mainStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
}