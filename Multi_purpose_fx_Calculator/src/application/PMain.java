
/*
 * 						Mohammad Kazemzadeh
 * 								Finished: Saturday, July 10, 2020
 */

package application;

//import codes.Poly;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PMain extends Application {

	Scene Mainscene;
	VBox VerticalBox;
	BorderPane root;
	Button first, Second, Third;
	final int HEIGHT = 530;
	final int WIDTH = 400;

	public PMain() {
		super();
		root = new BorderPane();
		Mainscene = new Scene(root, WIDTH, HEIGHT);
		VerticalBox = new VBox(20);
		first = new Button("BigInt M");
		Second = new Button("Poly M");
		Third = new Button("sMatrix M");

	}

	@Override
	public void start(Stage primaryStage) {
		try {

			primaryStage.setTitle("Calculator");
			setUserAgentStylesheet(STYLESHEET_MODENA);

			first.getStyleClass().add("bt");
			first.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					BigIntScene BigIntScene = new BigIntScene();
					try {
						BigIntScene.start(primaryStage);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			});

			first.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					if (event.getCode().equals(KeyCode.ENTER)) {
						BigIntScene BigIntScene = new BigIntScene();
						try {
							BigIntScene.start(primaryStage);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});

			Second.getStyleClass().add("bt");

			Second.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					PolyScene PolyScene = new PolyScene();
					try {
						PolyScene.start(primaryStage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});

			Second.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					if (event.getCode().equals(KeyCode.ENTER)) {
						PolyScene PolyScene = new PolyScene();
						try {
							PolyScene.start(primaryStage);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});

			Third.getStyleClass().add("bt");

			Third.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {

					SparseMatrixScene MScene = new SparseMatrixScene();
					try {
						MScene.start(primaryStage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			Third.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					if (event.getCode().equals(KeyCode.ENTER)) {
						SparseMatrixScene MScene = new SparseMatrixScene();
						try {
							MScene.start(primaryStage);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			VerticalBox.setAlignment(Pos.CENTER);
			VerticalBox.getChildren().addAll(first, Second, Third);
			BorderPane.setAlignment(VerticalBox, Pos.CENTER);

			root.setCenter(VerticalBox);

			Mainscene.getStylesheets().add(getClass().getResource("MainScene.css").toExternalForm());
			primaryStage.setScene(Mainscene);
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(new Image(PMain.class.getResourceAsStream("appicon.png")));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void MakeCompactMatrixFrom2DArray(FlowPane flow, int[][] Given, String Name) {
		Label l = new Label(Name);
		l.setAlignment(Pos.CENTER);
		l.setPrefSize(150, 20);

		flow.getChildren().add(l);

		TextField[][] tf = new TextField[Given.length][3];
		for (int i = 0; i < Given.length; i++) {
			for (int j = 0; j < 3; j++) {

				tf[i][j] = new TextField();
				tf[i][j].setText(Given[i][j] + "");
				tf[i][j].setId(i + "+" + j);
				tf[i][j].setPrefHeight(50);
				tf[i][j].setPrefWidth(50);
				tf[i][j].setEditable(false);
				tf[i][j].setAlignment(Pos.CENTER);

				flow.getChildren().add(tf[i][j]);
			}
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
