package application;

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
		 * like this we don't need to check the coordinates of the mouse 
		 * instead we just get which pane is clicked
		 */
		this.setOnMouseClicked(event ->{
			if ( game.currentPlayer.getSign().equalsIgnoreCase("X"))
				this.setSign("X");
			else this.setSign("O");
		
		});
	}
	
	private void setSign(String string) {
		shape.setText(string);
		
	}


	
}
