package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Controller {
	private Model model;
	private static View view;
	Socket socket;
	BufferedWriter out;
	BufferedReader in;
	
	public Controller (Model model, View view){
		this.model=model;
		this.view=view;
		
	}


	

	
}
