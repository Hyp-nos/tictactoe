package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import application.View.SquareSpot;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Controller   {
	private Model model;
	private static View view;
	Socket socket;
	BufferedWriter out;
	BufferedReader in;
	SquareSpot ss;
	static int id;
	
	public Controller (Model model, View view){
		this.model=model;
		this.view=view;
		// credits for some part of this method goes to http://stackoverflow.com/questions/28320110/javafx-how-to-get-column-and-row-index-in-gridpane
		view.board.addEventHandler(MouseEvent.MOUSE_CLICKED, new  EventHandler<MouseEvent>(){
		@Override
		public void handle (MouseEvent e){
			for (Node node: view.board.getChildren()){
				if (node instanceof SquareSpot){
					if (node.getBoundsInParent().contains(e.getSceneX(), e.getSceneY())){
						 id = Integer.parseInt(Integer.toString(GridPane.getRowIndex(node))+(Integer.toString(GridPane.getColumnIndex(node))));
						System.out.println(id);
						((SquareSpot) node).setSign(model.handleSqr());
					}
				}
			}
		}
				
		}	
				
				);
	}
	public void setSquareSpot(SquareSpot ss){
		this.ss=ss;
	}

	public static View getView(){
		return view;
	}

	
	

	
}
