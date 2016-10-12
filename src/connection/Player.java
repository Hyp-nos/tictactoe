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
	private BufferedReader in;
	private BufferedWriter out;
	private String sign;
	private Player single;
	private Player opponent;
	static String temp;
	boolean iGoFirst = true;
	static int turn = 4;
	boolean excuted = true;
	static String messageFromClient;

	public Player(Socket socket, String sign, boolean firstPlayer) {
		this.socket = socket;
		this.sign = sign;
		iGoFirst = firstPlayer;

	}

	@Override
	public void run() {
		try{

		 out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		 if(excuted){
				 if(iGoFirst){
					out.write(String.valueOf(1)+"\n");
				 out.flush();}
				 else {out.write(String.valueOf(2)+"\n");
					out.flush();
					}excuted = false;
		 }
		 System.out.println("checkkkk");
		}catch (Exception e){e.printStackTrace();}
			
		do{
			try{
			int i=Integer.parseInt(in.readLine());
				System.out.println(i+"  this is the message from client");
			//	out.write(messageFromClient+"\n");
				
			out.write(String.valueOf(turn)+"\n");
			out.flush();
			System.out.println("Turn "+turn);
			
			
			
			 System.out.println("i gave the client the turn of value "+turn);
			 ++turn;
			}catch( Exception e){e.printStackTrace();}
			
		}
			
			
		while(true);
		

	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public synchronized void setOpponent(Player player2) {
		this.opponent = player2;

	}

	public synchronized BufferedWriter getOut() {
		return out;
	}
	/*
	 * public static Player getPlayer(Socket s, String ss){ socket = s; sign =
	 * ss; if (single==null){ single = new Player( socket, sign); } return
	 * single; }
	 */

}
