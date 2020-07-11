package application;

import codes.Functions;
import codes.Poly;
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

public class PolyScene extends Application {

	Scene Poly;
	BorderPane Layout;
	VBox Vbox;
	HBox Hbox;
	TextField Poly1, Poly2, Poly_res;
	Button Poly_C, BackToMain, Calculate;
	Label fl, sl, resl, LABEL;
	final int HEIGHT = 530;
	final int WIDTH = 400;

	PolyScene() {

		Vbox = new VBox(8);
		Hbox = new HBox(8);
		Layout = new BorderPane();
		Poly = new Scene(Layout, WIDTH, HEIGHT);
		LABEL = new Label("Polynomial Multiplication");
		fl = new Label("First");
		sl = new Label("Second");
		resl = new Label("Result");
		Poly1 = new TextField();
		Poly2 = new TextField();
		Poly_res = new TextField();
		Calculate = new Button("Calculate");
		Poly_C = new Button("Clear");
		BackToMain = new Button("back");

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		fl.getStyleClass().add("Label");
		sl.getStyleClass().add("Label");
		resl.getStyleClass().add("Label");
		LABEL.getStyleClass().add("Label");
		LABEL.setAlignment(Pos.CENTER);

		Poly1.addEventFilter(KeyEvent.KEY_TYPED, Functions.filterINPUTforPoly());
		Poly1.getStyleClass().add("Tfield");

		Poly2.addEventFilter(KeyEvent.KEY_TYPED, Functions.filterINPUTforPoly());
		Poly2.getStyleClass().add("Tfield");

		Poly_res.setEditable(false);
		Poly_res.getStyleClass().add("Tfield");

		Calculate.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (Poly1.getText().length() != 0 && Poly2.getText().length() != 0) {
					if (Poly1.getText().contains("x") && Poly2.getText().contains("x")) {
						Poly first = new Poly(Poly1.getText().toString());
						Poly Second = new Poly(Poly2.getText().toString());
						String Res = "";
						Res = first.PMultiply(Second);
						Poly_res.setText(Res.toString());
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("Input Error!");
						alert.setContentText("Both expressinos should be Polynomials! ");
						alert.showAndWait();

					}

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

		Poly_C.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Poly1.setText("");
				Poly2.setText("");
				Poly_res.setText("");

			}
		});
		Poly_C.getStyleClass().add("bt");

		BackToMain.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				PMain mainScene = new PMain();
				mainScene.start(primaryStage);

			}
		});
		BackToMain.getStyleClass().add("bt");

		Vbox.setAlignment(Pos.CENTER);

		Hbox.setAlignment(Pos.CENTER);
		Hbox.getChildren().addAll(BackToMain, Calculate, Poly_C);

		Vbox.getChildren().addAll(LABEL, fl, Poly1, sl, Poly2, resl, Poly_res);

		Layout.setTop(Vbox);
		Layout.setBottom(Hbox);

		Poly.getStylesheets().add(getClass().getResource("PolyScene.css").toExternalForm());

		primaryStage.setScene(Poly);
	}

}
