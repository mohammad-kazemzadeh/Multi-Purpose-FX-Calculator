package application;

import codes.BigInt;
import codes.Functions;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BigIntScene extends Application {

	Scene BigInt;
	Button BackToMain;
	TextField BigInt1, BigInt2, BigInt_res;
	Button Calculate, BigInt_C;
	BorderPane Layout;
	HBox HorB;
	VBox VerB;
	Label fB, sB, ResB, LABEL;
	BigInt first, Second, Res;
	final int HEIGHT = 530;
	final int WIDTH = 400;

	BigIntScene() {
		super();

		Layout = new BorderPane();
		HorB = new HBox(8);
		VerB = new VBox(8);
		BigInt1 = new TextField();
		BigInt2 = new TextField();
		BigInt_res = new TextField();
		Calculate = new Button("Calculate");
		BigInt_C = new Button("Clear");
		BackToMain = new Button("back");
		fB = new Label("First");
		sB = new Label("Second");
		ResB = new Label("Result");

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		fB.getStyleClass().add("LB");
		fB.setAlignment(Pos.TOP_LEFT);

		sB.getStyleClass().add("LB");

		ResB.getStyleClass().add("LB");

		LABEL = new Label("BigInt Multiplication");
		LABEL.getStyleClass().add("LB");
		LABEL.setAlignment(Pos.CENTER);

		BigInt1.addEventFilter(KeyEvent.KEY_TYPED, Functions.filterINPUTforNumbers());
		BigInt1.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.lastIndexOf("-") > 0) {
				BigInt1.setText(oldValue);
			} else {
				BigInt1.setText(newValue);
			}
		});
		BigInt1.getStyleClass().add("Tfield");

		BigInt2.addEventFilter(KeyEvent.KEY_TYPED, Functions.filterINPUTforNumbers());
		BigInt2.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.lastIndexOf("-") > 0) {
				BigInt2.setText(oldValue);
			} else {
				BigInt2.setText(newValue);
			}
		});
		BigInt2.getStyleClass().add("Tfield");

		BigInt_res.setEditable(false);
		BigInt_res.getStyleClass().add("Tfield");

		Calculate.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (BigInt1.getText().length() != 0 && BigInt2.getText().length() != 0) {

					first = new BigInt(BigInt1.getText().toString());
					Second = new BigInt(BigInt2.getText().toString());
					Res = new BigInt();
					Res.Multiply(first, Second);
					BigInt_res.setText(Res.toString());

				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Input Error!");
					alert.setContentText("Fields cannot be empty!");
					alert.showAndWait();

				}
			}
		});
		Calculate.getStyleClass().add("bt");

		BigInt_C.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				BigInt1.setText("");
				BigInt2.setText("");
				BigInt_res.setText("");

			}
		});
		BigInt_C.getStyleClass().add("bt");

		BackToMain.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				PMain main = new PMain();
				main.start(primaryStage);
//				primaryStage.setScene(Mainscene);

			}
		});
		BackToMain.getStyleClass().add("bt");

		HorB.getChildren().addAll(BackToMain, Calculate, BigInt_C);
		HorB.setAlignment(Pos.CENTER);

		VerB.setAlignment(Pos.TOP_LEFT);
		VerB.getChildren().addAll(LABEL, fB, BigInt1, sB, BigInt2, ResB, BigInt_res);
		BorderPane.setAlignment(HorB, Pos.CENTER);
		Layout.setTop(VerB);
		Layout.setBottom(HorB);
		BigInt = new Scene(Layout, 400, 530);

		BigInt.getStylesheets().add(getClass().getResource("BigIntScene.css").toExternalForm());

		primaryStage.setScene(BigInt);

	}

}
