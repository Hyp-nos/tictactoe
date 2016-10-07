package application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game  {
	Player currentPlayer;
	Stage stage ;
	BorderPane root;
	Pane board ;

	
	public Game() {
		createContent();
		stage.show();
		
	}

	private void createContent() {
		stage = new Stage();
		root = new BorderPane();
		board= new Pane();
		// create the main borad and fill it with 9 squares
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				SquareSpot sqr = new SquareSpot();
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

	public boolean makeMove(Player player) {
		synchronized (this) {
			if (player != currentPlayer)
				return false;
		}
		return true;

	}

	public synchronized void setOnTurn(Player player) {
		if (currentPlayer != null) {
			try {
				currentPlayer.getOut().write(("Wait the other guy..."));

				this.currentPlayer = player;
				currentPlayer.getOut().write("Your Turn ");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			currentPlayer = player;
		}
	}



}
