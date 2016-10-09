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
	int player1 = 1;
	int player2 = 2;
	String sign="X";

	public Model() {

		try {

			socket = new Socket("127.0.0.1", 9876);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	/*
	 * private void updateView() { try { String messageFromServer =
	 * in.readLine(); while (messageFromServer != null) {
	 * 
	 * System.out.println(messageFromServer); } } catch (IOException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public String handleSqr() {
		String input;
		boolean excuted = false;
		/*if (!excuted) {
			try {
				int player = in.read();
				System.out.println(player + "the guy");
				if (player == player1)
					sign = "X";
				else
					sign = "O";

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				excuted = true;
			}
		}*/

		System.out.println("click worked");

		try {

			out.write(sign + "\n");
			// .....

			out.flush();
			String messageFromServer = in.readLine();
			if (messageFromServer.equalsIgnoreCase("X")) {
				System.out.println("WE ARE HERE IN HANDLE FOR X ");
				return "X";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "O";

	}

	@Override
	public void run() {

	}
}