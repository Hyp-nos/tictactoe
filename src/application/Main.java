package application;
	



import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;



public class Main extends Application {
	View view;
	Model model;
	Controller controller;
	public Main(){}
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
	/*	System.out.println("starting first");
		Platform.runLater(() -> {
			new Main().start(new Stage());
		});
		System.out.println("starting second");
		Platform.runLater(() -> {
			new Main().start(new Stage());
		});*/
	
	}
	@Override
	public void stop(){
		if (view !=null) view.stop();
	}
}
