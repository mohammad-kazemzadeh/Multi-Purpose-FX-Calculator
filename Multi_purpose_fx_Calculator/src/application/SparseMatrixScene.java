package application;

import codes.Functions;
import codes.SparseMatrix;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SparseMatrixScene extends Application {

	Scene Matrix;
	BorderPane Layout;
	GridPane grid;
	FlowPane firstMatrix, secondMatrix, ResMatrix;
	HBox hbox;
	Stage newWindow;
	Label LABEL;
	Button dimensionData, Calculate, BackToMain, clear;
	int n, m, k, dataAmount_F, dataAmount_S;
	final int HEIGHT = 530;
	final int WIDTH = 800;

	public SparseMatrixScene() {
		super();
		Layout = new BorderPane();
		Matrix = new Scene(Layout, WIDTH, HEIGHT);
		grid = new GridPane();
		firstMatrix = new FlowPane();
		secondMatrix = new FlowPane();
		ResMatrix = new FlowPane();

		hbox = new HBox(10);
		LABEL = new Label("Sparse Matrix multiplication");
		dimensionData = new Button("Set Dimensions");
		Calculate = new Button("Calculate");
		clear = new Button("Clear");
		BackToMain = new Button("Back");
	}

	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) throws Exception {

		LABEL.getStyleClass().add("LB");

		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(10);
		grid.setVgap(10);

		firstMatrix.setPrefSize(170, 150);
		firstMatrix.setVgap(5);
		firstMatrix.setHgap(5);

		secondMatrix.setPrefSize(170, 150);
		secondMatrix.setVgap(5);
		secondMatrix.setHgap(5);

		ResMatrix.setPrefSize(170, 150);
		ResMatrix.setVgap(5);
		ResMatrix.setHgap(5);

		dimensionData.getStyleClass().add("bt");
		dimensionData.setOnAction(new EventHandler<ActionEvent>() {

			Label secondLabel = new Label("Enter Matrix Dimensions And Data Amount");
			Label DataAmountF = new Label("First Data Amount");
			Label DataAmountS = new Label("Second Data Amount");
			Label X;
			Label X2;
			BorderPane secondaryLayout;
			Scene secondScene;
			Label first = new Label("First");
			Label second = new Label("Second");
			TextField firstT_M;
			TextField firstT_N;
			TextField secondT_N;
			TextField secondT_K;
			TextField DAmount_f;
			TextField DAmount_S;
			GridPane grid_Secondary;
			Button Setbtn;

			@Override
			public void handle(ActionEvent event) {

				first.getStyleClass().add("LB");
				second.getStyleClass().add("LB");
				secondLabel.getStyleClass().add("LB");
				DataAmountF.getStyleClass().add("LB");
				DataAmountS.getStyleClass().add("LB");

//				Label secondLabel = new Label("Enter Matrix Dimensions And Data Amount");
				X = new Label("\u00D7");
				X2 = new Label("\u00D7");
				X.getStyleClass().add("LB");
				X2.getStyleClass().add("LB");

//				secondLabel.setPrefSize(300, 30);

				secondaryLayout = new BorderPane();
				secondScene = new Scene(secondaryLayout, 420, 400);

//				secondaryLayout.getChildren().add(secondLabel);
				secondaryLayout.setTop(secondLabel);
				secondaryLayout.setPadding(new Insets(10));
				BorderPane.setAlignment(secondLabel, Pos.TOP_CENTER);

				firstT_M = new TextField();
				firstT_M.getStyleClass().add("Tfield");

				firstT_M.setAlignment(Pos.CENTER);
				firstT_M.setPrefSize(40, 40);
				firstT_M.addEventFilter(KeyEvent.KEY_TYPED, Functions.filterMatrixIndcies());
				firstT_M.textProperty().addListener((observable, oldValue, newValue) -> {

					if (newValue.length() > 1) { // i suppose max length is 1
						firstT_M.setText(oldValue);

					} else {
						firstT_M.setText(newValue);
						if (firstT_N.getText().length() != 0) {
							DAmount_f.setEditable(true);
							DAmount_f.setFocusTraversable(true);
						}

					}
					if (newValue.length() == 0) {
						DAmount_f.setEditable(false);
						DAmount_f.setFocusTraversable(false);
						DAmount_f.setText("");
					}

				});

				firstT_N = new TextField();
				firstT_N.getStyleClass().add("Tfield");

				firstT_N.setAlignment(Pos.CENTER);
				firstT_N.setPrefSize(40, 40);
				firstT_N.addEventFilter(KeyEvent.KEY_TYPED, Functions.filterMatrixIndcies());
				firstT_N.textProperty().addListener((observable, oldValue, newValue) -> {

					if (newValue.length() > 1) { // i suppose max length is 1
						firstT_N.setText(oldValue);

					} else {
						firstT_N.setText(newValue);
						secondT_N.setText(newValue);
						if (firstT_M.getText().length() != 0) {
							DAmount_f.setEditable(true);
							DAmount_f.setFocusTraversable(true);
						}
					}

					if (newValue.length() == 0) {
						DAmount_f.setEditable(false);
						DAmount_f.setFocusTraversable(false);
						DAmount_f.setText("");

					}
				});

				secondT_N = new TextField();
				secondT_N.getStyleClass().add("Tfield");

				secondT_N.setAlignment(Pos.CENTER);
				secondT_N.setPrefSize(40, 40);
				secondT_N.setEditable(false);
				secondT_N.setFocusTraversable(false);

				secondT_K = new TextField();
				secondT_K.getStyleClass().add("Tfield");

				secondT_K.setAlignment(Pos.CENTER);
				secondT_K.setPrefSize(40, 40);
				secondT_K.addEventFilter(KeyEvent.KEY_TYPED, Functions.filterMatrixIndcies());
				secondT_K.textProperty().addListener((observable, oldValue, newValue) -> {

					if (newValue.length() > 1) { // i suppose max length is 1
						secondT_K.setText(oldValue);

					}

					if (newValue.length() == 0) {
						DAmount_S.setEditable(false);
						DAmount_S.setFocusTraversable(false);
						DAmount_S.setText("");

					} else {
						secondT_K.setText(newValue);
						DAmount_S.setEditable(true);
						DAmount_S.setFocusTraversable(true);

					}

				});

				DAmount_f = new TextField();
				DAmount_f.getStyleClass().add("Tfield");
				DAmount_f.setEditable(false);
				DAmount_f.setFocusTraversable(false);

				DAmount_f.setAlignment(Pos.CENTER);
				DAmount_f.setPrefSize(40, 40);
				DAmount_f.addEventFilter(KeyEvent.KEY_TYPED, Functions.filterMatrixIndcies());
				DAmount_f.textProperty().addListener((observable, oldValue, newValue) -> {

					if (newValue.length() != 0)
						if (Integer.parseInt(newValue) > (Integer.parseInt(firstT_N.getText()))
								* (Integer.parseInt(firstT_M.getText())) / 2) {
							DAmount_f.setText(oldValue);

							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Incorrect Input");
							alert.setHeaderText("Input Error!");
							alert.setContentText("Maximum Data amount is half of the matrix indices!");
							alert.showAndWait();

						} else {
							DAmount_f.setText(newValue);

						}
				});

				DAmount_S = new TextField();
				DAmount_S.getStyleClass().add("Tfield");
				DAmount_S.setEditable(false);
				DAmount_S.setFocusTraversable(false);

				DAmount_S.setAlignment(Pos.CENTER);
				DAmount_S.setPrefSize(40, 40);
				DAmount_S.addEventFilter(KeyEvent.KEY_TYPED, Functions.filterMatrixIndcies());
				DAmount_S.textProperty().addListener((observable, oldValue, newValue) -> {

					if (newValue.length() != 0)
						if (Integer.parseInt(newValue) > (Integer.parseInt(secondT_N.getText()))
								* (Integer.parseInt(secondT_K.getText())) / 2) {
							DAmount_S.setText(oldValue);

							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Incorrect Input");
							alert.setHeaderText("Input Error!");
							alert.setContentText("Maximum Data amount is half of the matrix indices!");
							alert.showAndWait();

						} else {
							DAmount_S.setText(newValue);

						}
				});

				grid_Secondary = new GridPane();
				grid_Secondary.setHgap(8);
				grid_Secondary.setVgap(5);

				grid_Secondary.setAlignment(Pos.CENTER_LEFT);
				grid_Secondary.setPadding(new Insets(15));
				grid_Secondary.add(first, 2, 0);
				grid_Secondary.add(firstT_M, 3, 0);
				grid_Secondary.add(X, 4, 0);
				grid_Secondary.add(firstT_N, 5, 0);

				grid_Secondary.add(second, 2, 1);
				grid_Secondary.add(secondT_N, 3, 1);
				grid_Secondary.add(X2, 4, 1);
				grid_Secondary.add(secondT_K, 5, 1);

				grid_Secondary.add(DataAmountF, 2, 2);
				grid_Secondary.add(DAmount_f, 3, 2);

				grid_Secondary.add(DataAmountS, 2, 3);
				grid_Secondary.add(DAmount_S, 3, 3);

				secondaryLayout.setCenter(grid_Secondary);
				Setbtn = new Button("Set");
				Setbtn.getStyleClass().add("bt");

				Setbtn.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						if (firstT_M.getText().length() != 0 && firstT_N.getText().length() != 0
								&& secondT_K.getText().length() != 0 && DAmount_f.getText().length() != 0
								&& DAmount_S.getText().length() != 0) {
							m = Integer.parseInt(firstT_M.getText().toString());
							n = Integer.parseInt(firstT_N.getText().toString());
							k = Integer.parseInt(secondT_K.getText().toString());
							dataAmount_F = Integer.parseInt(DAmount_f.getText().toString());
							dataAmount_S = Integer.parseInt(DAmount_S.getText().toString());

							firstMatrix.getChildren().clear();
							secondMatrix.getChildren().clear();
							ResMatrix.getChildren().clear();
							Functions.MakeEMPTYCompactMatrix(firstMatrix, dataAmount_F, "First");
							Functions.MakeEMPTYCompactMatrix(secondMatrix, dataAmount_S, "Second");

							newWindow.close();
							secondaryLayout.getChildren().clear();
							newWindow = null;

						}

						else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Empty Fields");
							alert.setHeaderText("Input Error!");
							alert.setContentText("Fields cannot be empty");
							alert.showAndWait();

						}

					}

				});
				secondaryLayout.setBottom(Setbtn);
				BorderPane.setAlignment(Setbtn, Pos.BOTTOM_CENTER);

				secondScene.getStylesheets().add(getClass().getResource("MatrixData.css").toExternalForm());

				newWindow = new Stage();
				newWindow.setTitle("Enter Data");
				newWindow.setScene(secondScene);

				newWindow.initModality(Modality.WINDOW_MODAL);

				newWindow.initOwner(primaryStage);

				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);
				newWindow.setResizable(false);
				newWindow.getIcons().add(new Image(PolyScene.class.getResourceAsStream("appicon.png")));

				newWindow.show();
			}

		});

		grid.add(firstMatrix, 0, 3);
		grid.add(secondMatrix, 2, 3);
		grid.add(ResMatrix, 4, 3);
		grid.setAlignment(Pos.TOP_CENTER);

		Calculate.getStyleClass().add("bt");
		Calculate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// if both matrices are filled then continue
				if (firstMatrix.getChildren().size() >= 4 && secondMatrix.getChildren().size() >= 4) {
					// minimum 4 nodes, because we have 1 label and at least a matrix with 3 indices

					if (!(Functions.childFILLCheck(firstMatrix)) && !(Functions.childFILLCheck(secondMatrix))) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("Empty indices found!");
						alert.setContentText("All indices must be filled!");
						alert.showAndWait();

					} else {
//						error.setText("");
						int[][] res = Multiply(firstMatrix, secondMatrix);

						Functions.MakeCompactMatrixFrom2DArray(ResMatrix, res, "Result");

						for (int i = 0; i < res.length; i++) {
							for (int j = 0; j < res[0].length; j++) {
								System.out.print(res[i][j] + " |");
							}
							System.out.println();
						}

					}
				}

				else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("No Matrix Created!");
					alert.setContentText("Create matrices by setting the dimensions");
					alert.showAndWait();
				}
			}
		});

		BackToMain.getStyleClass().add("bt");
		BackToMain.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				PMain MainScene = new PMain();
				MainScene.start(primaryStage);
			}
		});
		clear.getStyleClass().add("bt");

		clear.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				firstMatrix.getChildren().clear();
				secondMatrix.getChildren().clear();
				ResMatrix.getChildren().clear();

			}
		});

		hbox.getChildren().addAll(BackToMain, dimensionData, Calculate, clear);
		hbox.setAlignment(Pos.CENTER);

		Layout.setTop(LABEL);
		Layout.setBottom(hbox);
		Layout.setPadding(new Insets(5));

		Layout.setAlignment(LABEL, Pos.CENTER);

		Layout.setCenter(grid);
		Layout.getStylesheets().add(getClass().getResource("SparseMatrixScene.css").toExternalForm());

		primaryStage.setScene(Matrix);

	}

	public int[][] Multiply(FlowPane Given, FlowPane Given_2) {

		int[][] Ftemp = new int[dataAmount_F][3]; // 3 -> i j value
		int[][] Stemp = new int[dataAmount_S][3];
		int counter = 1;
		ObservableList<Node> GList = Given.getChildren();
		while (counter < GList.size())
			for (int i = 0; i < dataAmount_F; i++) {
				for (int j = 0; j < 3; j++) {
					TextField curr = (TextField) GList.get(counter++);
					Ftemp[i][j] = Integer.parseInt(curr.getText().toString());
				}
			}
		counter = 1;
		ObservableList<Node> G_2list = Given_2.getChildren();
		while (counter < G_2list.size())
			for (int i = 0; i < dataAmount_S; i++) {
				for (int j = 0; j < 3; j++) {
					TextField curr = (TextField) G_2list.get(counter++);
					Stemp[i][j] = Integer.parseInt(curr.getText().toString());
				}
			}
		int[][] t = new int[m][n];
		int[][] t2 = new int[n][k];
		t = SparseMatrix.CompactToSparse(Ftemp, m, n);
		t2 = SparseMatrix.CompactToSparse(Stemp, n, k);

		int[][] Res = SparseMatrix.Multiply(t, t2);

		int[][] finalRes = SparseMatrix.SparseToCompact(Res);

		return finalRes;

	}

}
