package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javafx.scene.input.MouseEvent;

public class Model implements Runnable {

	Socket socket;
	BufferedWriter out;
	BufferedReader in;
	int player;

	String sign;
	boolean excuted = false;
	 int myTurn = 2;

	public Model() {

		try {

			socket = new Socket("127.0.0.1", 9876);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	private void updateView() {
		try {
			Controller.getView().group.
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String handleSqr() {
		String input;
		// this get excuted only once
		if (!excuted) {
			try {
				player = Integer.parseInt(in.readLine());
				System.out.println(player);
				
				if (player == 1){
					sign = "X";
					System.out.println("You are the first player, your Sign is X");
				}
				else {
					player = 2;
					sign = "O";
					System.out.println("You are the Second player, your Sign is O");
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				excuted = true;
			}
		}
		if (sign.equalsIgnoreCase("x")&&myTurn%2==0) {
		
			System.out.println("player one turn");

			try {
				updateView();
				myTurn++;
				return sign;
			} catch (Exception e) {e.printStackTrace();}

		} else if (sign.equalsIgnoreCase("O")&&myTurn%2!=0) {
		
			System.out.println("player 2 turn");
			try {
				updateView();
				myTurn++;
			return "O";
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
			myTurn=false;
		
		return null;
	}

	

	@Override
	public void run() {

	}
}