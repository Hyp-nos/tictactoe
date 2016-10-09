package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread {
	private Socket socket;
	private  BufferedReader in;
	private  BufferedWriter out;
	private  String sign;

	private Player opponent;
	
	
	
	

	public Player(Socket socket, String sign) {
		this.socket = socket;
		this.sign=sign;


	}

	@Override
	public void run() {
		try{

		 out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String messageFromClient= in.readLine();
		while(messageFromClient!=null){
			out.write(messageFromClient);
			System.out.println("in player class");
			
			
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
			
		
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public synchronized void setOpponent(Player player2) {
		this.opponent=player2;
		
	}

	public synchronized BufferedWriter getOut() {
		return out;
	}
	
}
