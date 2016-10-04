package connection;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Player extends Thread {
	Socket clientSocket;
	static int id = 0;
	public Player(Socket client) {
		clientSocket = client;

	}

	@Override
	public void run() {
		try{
		clientSocket = new Socket("127.0.0.1", 9876);	
		
			id++;
		
		ObjectOutputStream ops = new ObjectOutputStream(clientSocket.getOutputStream());
		ObjectInputStream ips = new ObjectInputStream(clientSocket.getInputStream());
		
		while(ips.readObject()!=null){
			System.out.println(id);
			
			
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
