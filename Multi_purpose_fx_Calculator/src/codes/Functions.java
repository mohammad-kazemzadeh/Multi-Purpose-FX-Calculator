package codes;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;

public class Functions {

	public static void MakeCompactMatrixFrom2DArray(FlowPane flow, int[][] Given, String Name) {
		Label l = new Label(Name);
		l.setAlignment(Pos.CENTER);
		l.setPrefSize(150, 20);
		l.getStyleClass().add("LB");

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
				tf[i][j].getStyleClass().add("Tfield");
				tf[i][j].setAlignment(Pos.CENTER);

				flow.getChildren().add(tf[i][j]);
			}
		}

	}

	@SuppressWarnings("unused")
	public static void MakeEMPTYCompactMatrix(FlowPane flow, int amount, String Name) {
		Label l = new Label(Name);
		l.setAlignment(Pos.CENTER);
		l.setPrefSize(150, 20);
		l.getStyleClass().add("LB");

		flow.getChildren().add(l);

		TextField[][] tf = new TextField[amount][3];
		for (int i = 0; i < amount; i++) {
			for (int j = 0; j < 3; j++) {

				tf[i][j] = new TextField();
				tf[i][j].setId(i + "+" + j);
				tf[i][j].setPrefHeight(50);
				tf[i][j].setPrefWidth(50);
				tf[i][j].setAlignment(Pos.CENTER);
				tf[i][j].getStyleClass().add("Tfield");
				tf[i][j].addEventFilter(KeyEvent.KEY_TYPED, filterMatrixIndcies());

				// Iterate the Index using the loops
				flow.getChildren().add(tf[i][j]);
			}
		}
	}

	@SuppressWarnings("unused")
	public static boolean childFILLCheck(FlowPane flow) {
		boolean filled = true;
		for (int i = 1; i < flow.getChildren().size(); i++) {
			// i = 1 skipping the label in list
			TextField curr = (TextField) flow.getChildren().get(i);
			if (!(curr.getText().length() != 0)) {
				filled = false;
				break;
			}
		}

		return filled;
	}

	public static EventHandler<KeyEvent> filterINPUTforPoly() {

		return new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				if (!event.getCharacter().matches("[0-9.*+^x-]"))
					event.consume();
			}

		};

	}

	public static EventHandler<KeyEvent> filterINPUTforNumbers() {

		return new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				if (!event.getCharacter().matches("[0-9-]"))
					event.consume();
			}

		};

	}

	public static EventHandler<KeyEvent> filterMatrixIndcies() {

		return new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {

				if (!event.getCharacter().matches("[0-9]"))
					event.consume();

			}
		};

	}
}
