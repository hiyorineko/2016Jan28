/**
 *	写経です
 *	http://krr.blog.shinobi.jp/javafx/javafx%20scenegraph
 */
 
import java.io.File;
 
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.LightBase;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
 
public class Fxtest4 extends Application{
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		//サブシーンづくり
		SubScene sg3D = create3DScene();
		SubScene sg2D = create2DScene();
		
		//シーンを乗せる(シーングラフを構成)
		Pane root = new Pane();
		root.getChildren().add(sg3D);
		root.getChildren().add(sg2D);
		sg2D.relocate(10,sg3D.getHeight() - sg2D.getHeight()-10);
		
		//シーンの作成
		Scene scene = new Scene(root);
		
		//ステージの作成
		primaryStage.setScene(scene);
		primaryStage.setTitle("Scene Graphのテスト");
		primaryStage.show();
	}
	
	private SubScene create3DScene(){
		Group sg3D = new Group();
		
		//立方体の追加
		Box box = new Box(10,10,10);
		box.setRotationAxis(new Point3D(1.0,1.0,1.0));
		box.setRotate(30.0);
		sg3D.getChildren().add(box);
		
		//立方体の色を設定
		PhongMaterial material = new PhongMaterial();
		material.setDiffuseColor(Color.AZURE);
		box.setMaterial(material);
		
		//カメラ設定
		Camera camera = new PerspectiveCamera(true);
		camera.setTranslateZ(-25.30);
		sg3D.getChildren().add(camera);
		
		//スポットライト
		LightBase light = new PointLight();
		light.setTranslateX(20.0);
		light.setTranslateY(-20.0);
		light.setTranslateZ(-30.0);
		sg3D.getChildren().add(light);
		
		//シーンの作成
		SubScene subscene = new SubScene(sg3D,400,400);
		subscene.setFill(Color.BLACK);
		subscene.setCamera(camera);
	
		return subscene;
	}
	
	private SubScene create2DScene(){
		
		Pane sg2D = new Pane();
		
		//長方形を追加
		Rectangle rect = new Rectangle(200,50);
		rect.setArcHeight(10);
		rect.setArcWidth(10);
		rect.setFill(Color.GREENYELLOW);
		rect.setOpacity(0.75);
		sg2D.getChildren().add(rect);
		
		//円を追加
		Circle circle = new Circle(17.5);
		circle.setLayoutX(25.0);
		circle.setLayoutY(25.0);
		circle.setFill(Color.WHITE);
		sg2D.getChildren().add(circle);
		
		//画像を追加
		ImageView iv = new ImageView();
		Image img = new Image(new File("ziki.png").toURI().toString());
		iv.setImage(img);
		iv.setSmooth(true);
		iv.setPreserveRatio(true);
		iv.setFitWidth(30);
		iv.setLayoutX(10.0);
		iv.setLayoutY(10.0);
		sg2D.getChildren().add(iv);
		
		//テキストを追加
		Text txt = new Text();
		txt.setText("四角いでしょ");
		txt.setFont(new Font(12));
		txt.setFill(Color.BLACK);
		txt.setWrappingWidth(140);
		txt.setLayoutX(50.0);
		txt.setLayoutY(15.0);
		sg2D.getChildren().add(txt);
		
		SubScene subscene = new SubScene(sg2D,rect.getWidth(),rect.getHeight());
		
		return subscene;
		
	}
	
}