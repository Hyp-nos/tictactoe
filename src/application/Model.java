package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class Model implements Runnable {

	Socket socket;
	BufferedWriter out;
	BufferedReader in;
	int player;

	String sign;
	boolean excuted = false;
	int myTurn;

	public Model() {

		try {

			socket = new Socket("127.0.0.1", 9876);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// this get excuted only once
			if (!excuted) {
				try {
					player = Integer.parseInt(in.readLine());
					System.out.println("the player is : "+player);

					if (player == 1) {
						sign = "X";
						System.out.println("You are the first player, your Sign is X");
					} else {
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

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	private void updateView() {
		/*
		 * try { //Controller.getView().group. } } catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */

	}

	public String handleSqr() {
		try {
			out.write(String.valueOf(Controller.id)+"\n");
			out.flush();
			System.out.println("sent the server the node ID "+ Controller.id);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			System.out.println(myTurn +"before");
			
			myTurn = Integer.parseInt(in.readLine());
			System.out.println(myTurn +"after");
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		if (myTurn!=0 &&myTurn % 2 == 0) {

			System.out.println("player one turn");

			try {
				System.out.println(" in try after sign.equals method " + sign + "\n myTurn value " + myTurn);
			//	out.write("Yo what is up\n");
				
				System.out.println("checking ID "+Controller.id);
				return sign;

			} catch (Exception e) {
				e.printStackTrace();
			}

		} /*else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Look, an Information Dialog");
			alert.setContentText("NOT UR TURN player 1");
			alert.showAndWait();
			// myTurn++;
			System.out.println("My turn value " + myTurn);
		}*/

		if (myTurn % 2 != 0) {
			
			System.out.println("player 2 turn");
			try {
				out.write(String.valueOf(Controller.id)+"\n");
				// updateView();
			
				System.out.println("in second player turn ");
				System.out.println("ID "+ Controller.id);
				return sign;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return sign;
	}

	@Override
	public void run() {
		// this get excuted only once
			/*	if (!excuted) {
					try {
						player = Integer.parseInt(in.readLine());
						System.out.println("the player is : "+player);

						if (player == 1) {
							sign = "X";
							System.out.println("You are the first player, your Sign is X");
						} else {
							player = 2;
							sign = "O";
							System.out.println("You are the Second player, your Sign is O");
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						excuted = true;
					}
				}*/

	}
}