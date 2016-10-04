package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TicServer {

	public static void main(String[] args) {
		try {
			ServerSocket serversocket = new ServerSocket(9876);
			System.out.println("Tic Tac Toe Server is waiting clients ....");
			while (true){
				Socket client = serversocket.accept();
				Player player = new Player(client);
				player.start();
				System.out.println("a player found!! ");
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
