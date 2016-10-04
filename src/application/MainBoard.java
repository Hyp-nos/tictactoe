package application;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MainBoard extends Pane{
	public MainBoard() {

		// create the main borad and fill it with 9 squares
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				SquareSpot sqr = new SquareSpot();
				// define coordinates
				sqr.setTranslateX(k * 200);
				sqr.setTranslateY(i * 200);
				// add them to the main board
				this.getChildren().add(sqr);
			}
		}
	}
}