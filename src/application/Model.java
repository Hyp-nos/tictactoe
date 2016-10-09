package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Model implements Runnable{
	View view;
	Socket socket;
	BufferedWriter out;
	BufferedReader in;
	String message;

	public  Model(View view) {
		this.view = view;

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
		String input = "send to server method";
		try {
			
			out.write(input + "\n");
			//.....
			
			out.flush();
			updateView();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void updateView() {
		try {
			while ((message = in.readLine()) != null) {

				System.out.println(message);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
		
	
}
