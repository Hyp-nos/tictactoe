package application;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {
	Stage stage;
	BorderPane root;
	Pane board;

	ArrayList<SquareSpot> group;
	SquareSpot sqr;

	public View(Stage stage) {
		this.stage = stage;

		root = new BorderPane();
		board = new Pane();
		// create the main borad and fill it with 9 squares
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				sqr = new SquareSpot();
				// define coordinates
				sqr.setTranslateX(k * 200);
				sqr.setTranslateY(i * 200);
				// add them to the main board
				board.getChildren().add(sqr);
			}
		}
		root.setCenter(board);
		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
	}

	public void start() {
		stage.show();
	}

	public void stop() {
		stage.hide();
	}

	public void drawX() {
		sqr.getTxt().setText("X\n");

	}

	public void drawY() {
		sqr.getTxt().setText("Y\n");

	}

	public class SquareSpot extends StackPane {
		Text shape = new Text("hi");

		public Rectangle getRec() {
			return rec;
		}

		public void setRec(Rectangle rec) {
			this.rec = rec;
		}

		Rectangle rec;

		public SquareSpot() {

			rec = new Rectangle(200, 200);
			rec.setFill(null);
			rec.setStroke(Color.BLACK);
			rec.setStrokeWidth(10);
			this.getChildren().add(rec);
			this.getChildren().add(shape);
			this.setOnMouseClicked(e-> {
				Controller.handleSqr();
			});
		}

		private void setSign(String string) {
			shape.setText(string);

		}

		public Text getTxt() {
			return shape;
		}
		
	}
}
