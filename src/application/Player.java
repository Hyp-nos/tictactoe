package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Player implements  Runnable {
	private Socket socket;
	private  BufferedReader in;
	private  BufferedWriter out;
	private  String sign;
	private  Game game;
	private Player opponent;
	
	
	
	
	static int id = 0;
	public Player(Socket socket, String sign, Game game) {
		this.socket = socket;
		this.sign=sign;
		this.game=game;

	}

	@Override
	public void run() {
		try{
		socket = new Socket("127.0.0.1", 9876);	
		
		 out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		
		while(in.readLine()!=null){
			System.out.println(id);
			
			
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
