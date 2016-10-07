package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import application.Game;


public class TicServer {
	private static int port=9876;
	private  ServerSocket serverSocket;

	public static void main(String[] args) {
		new TicServer().start();
	}
	public void start(){
		try {
			 serverSocket = new ServerSocket(port);
			System.out.println("Tic Tac Toe Server is waiting clients ....");
			while (true){
				Game game = new Game();
				Player player1 = new Player(serverSocket.accept(), " X ", game);
				Player player2 = new Player(serverSocket.accept(), " O ", game);
				player1.setOpponent(player2);
				player2.setOpponent(player1);
				game.setOnTurn(player1);
				new Thread(player1).start();
				new Thread(player2).start();
				System.out.println("a player found!! ");
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
