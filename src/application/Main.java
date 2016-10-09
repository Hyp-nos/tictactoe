package application;
	

import java.net.Socket;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;



public class Main extends Application {
	View view;
	Model model;
	Controller controller;
	@Override
	public void start(Stage primaryStage) {
		
			try {
				 model = new Model();
				 view = new View(primaryStage, model);
				 controller = new Controller(model, view);
				view.start();
			}  catch (Exception e) {
				e.printStackTrace();
			}	
			
			
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void stop(){
		if (view !=null) view.stop();
	}
}
