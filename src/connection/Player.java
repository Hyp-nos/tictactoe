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
	private static Socket socket;
	private  BufferedReader in;
	private  BufferedWriter out;
	private   String sign;
	//private  Player single;
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
		 System.out.println("checkkkk");
			out.write(String.valueOf(1));
			out.flush();
		while(true){
			
		String messageFromClient= in.readLine();
		
			out.write(messageFromClient+"\n");
			System.out.println(messageFromClient);
			System.out.println("in player class");
			out.flush();

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
	/*public static Player getPlayer(Socket s, String ss){
		socket = s;
		sign = ss;
		if (single==null){
			single = new Player( socket,  sign);
		}
		return single;
	}*/

	
}
