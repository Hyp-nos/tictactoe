package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import application.View.SquareSpot;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Controller implements Observer {
	private Model model;
	private static View view;
	Socket socket;
	BufferedWriter out;
	BufferedReader in;
	SquareSpot ss;
	
	public Controller (Model model, View view){
		this.model=model;
		this.view=view;
		
	}
	public void setSquareSpot(SquareSpot ss){
		this.ss=ss;
	}

	public static View getView(){
		return view;
	}

	@Override
	public void update(Observable sender, Object arg1) {
		ArrayList data = (ArrayList)arg1;
		SquareSpot s= ss.create()
	}
	

	
}
