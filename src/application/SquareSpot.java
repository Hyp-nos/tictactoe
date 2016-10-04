package application;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.Text;

public class SquareSpot extends StackPane {
	 static  Text shape;
	 Game game;
	
	public SquareSpot (){
		
		Rectangle rec = new Rectangle(200,200);
		rec.setFill(null);
		rec.setStroke(Color.BLACK);
		rec.setStrokeWidth(10);
		this.getChildren().add(rec);
		/* since this is a stackpane we inhert all the methods including setOnMouseClicked
		 * like this we don't need to check the coordinates of the mouse like others are doing
		 * instead we just get which pane is clicked
		 */
		this.setOnMouseClicked(event ->{
	
		game.run();	
		});
	}
	
	public void handleType(final SquareSpot tile, String XorO) {
		tile.shape.setText(XorO);
		
		
	
	}

	private void xShape(){
		shape.setText( "X");
	}
	
	private void oShape(){
		shape.setText("O");
	}
	
}
