package application;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Controller implements EventHandler <MouseEvent> {
	private Model model;
	private static View view;
	
	public Controller (Model model, View view){
		this.model=model;
		this.view=view;

	}

	@Override
	public void handle(MouseEvent event) {
		try {
			System.out.println("click worked");
			if (model.in.readLine().equalsIgnoreCase("X"))
			view.drawX();
			else view.drawY();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public static void handleSqr() {
		view.sqr.getTxt().setText("WORKED");
		
	};
}
