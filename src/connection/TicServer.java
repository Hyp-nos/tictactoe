package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


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
				Socket socket = serverSocket.accept(); 
				Player player1 = new Player(socket, " X ");
			//	Player player2 = new Player(serverSocket.accept(), " O ");
			//	player1.setOpponent(player2);
			//	player2.setOpponent(player1);
				//game.setOnTurn(player1);
				Thread thread = new Thread(player1);
				thread.start();
		//		new Thread(player2).start();
				System.out.println("we found a Match!! ");
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
