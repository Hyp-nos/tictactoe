package application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game implements Runnable{

	private Thread thread;
	

	 
	private boolean yourTurn = false;
	private boolean circle = false;
	
	private String winString = "You Won!";
	private String lostString= "You Lost!";
	
	
	public Game(){
		Stage stage = new Stage();
		BorderPane root = new BorderPane();
		root.setCenter(new MainBoard());
		Scene scene = new Scene(root,700,700);
		stage.setScene(scene);
		stage.show();
	}
	@Override
	public void run() {
		try {
			// i need to find a way to initiate player as server and keep game as logic 
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	//if ()
		
		
		
		
		
	}

}
