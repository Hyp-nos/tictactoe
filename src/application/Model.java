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


	public Model() {

		try {

			socket = new Socket("127.0.0.1", 9876);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	@Override
	public void run() {
		sendToServer();

	}

	private void sendToServer() {
		String input = "X";
		try {

			out.write(input + "\n");
			// .....

			out.flush();
			updateView();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void updateView() {
		try {
		String	messageFromServer = in.readLine();
			while (messageFromServer != null) {

				System.out.println(messageFromServer);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String handleSqr() {
		Thread th = new Thread(this);
		th.start();
		System.out.println("click worked");
		try {
			
			if (in.readLine().equalsIgnoreCase("X"))
		
				return "X";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "O";

	}
}