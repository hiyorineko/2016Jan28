/**
 *	�ʌo�ł�
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
		
		//�T�u�V�[���Â���
		SubScene sg3D = create3DScene();
		SubScene sg2D = create2DScene();
		
		//�V�[�����悹��(�V�[���O���t���\��)
		Pane root = new Pane();
		root.getChildren().add(sg3D);
		root.getChildren().add(sg2D);
		sg2D.relocate(10,sg3D.getHeight() - sg2D.getHeight()-10);
		
		//�V�[���̍쐬
		Scene scene = new Scene(root);
		
		//�X�e�[�W�̍쐬
		primaryStage.setScene(scene);
		primaryStage.setTitle("Scene Graph�̃e�X�g");
		primaryStage.show();
	}
	
	private SubScene create3DScene(){
		Group sg3D = new Group();
		
		//�����̂̒ǉ�
		Box box = new Box(10,10,10);
		box.setRotationAxis(new Point3D(1.0,1.0,1.0));
		box.setRotate(30.0);
		sg3D.getChildren().add(box);
		
		//�����̂̐F��ݒ�
		PhongMaterial material = new PhongMaterial();
		material.setDiffuseColor(Color.AZURE);
		box.setMaterial(material);
		
		//�J�����ݒ�
		Camera camera = new PerspectiveCamera(true);
		camera.setTranslateZ(-25.30);
		sg3D.getChildren().add(camera);
		
		//�X�|�b�g���C�g
		LightBase light = new PointLight();
		light.setTranslateX(20.0);
		light.setTranslateY(-20.0);
		light.setTranslateZ(-30.0);
		sg3D.getChildren().add(light);
		
		//�V�[���̍쐬
		SubScene subscene = new SubScene(sg3D,400,400);
		subscene.setFill(Color.BLACK);
		subscene.setCamera(camera);
	
		return subscene;
	}
	
	private SubScene create2DScene(){
		
		Pane sg2D = new Pane();
		
		//�����`��ǉ�
		Rectangle rect = new Rectangle(200,50);
		rect.setArcHeight(10);
		rect.setArcWidth(10);
		rect.setFill(Color.GREENYELLOW);
		rect.setOpacity(0.75);
		sg2D.getChildren().add(rect);
		
		//�~��ǉ�
		Circle circle = new Circle(17.5);
		circle.setLayoutX(25.0);
		circle.setLayoutY(25.0);
		circle.setFill(Color.WHITE);
		sg2D.getChildren().add(circle);
		
		//�摜��ǉ�
		ImageView iv = new ImageView();
		Image img = new Image(new File("ziki.png").toURI().toString());
		iv.setImage(img);
		iv.setSmooth(true);
		iv.setPreserveRatio(true);
		iv.setFitWidth(30);
		iv.setLayoutX(10.0);
		iv.setLayoutY(10.0);
		sg2D.getChildren().add(iv);
		
		//�e�L�X�g��ǉ�
		Text txt = new Text();
		txt.setText("�l�p���ł���");
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