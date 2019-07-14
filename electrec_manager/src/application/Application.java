package application;

import GUI.MainScreen;
import Utils.MyConnection;

import com.mysql.jdbc.Connection;

public class Application {

	public static void main(String[] args) {
		
		MyConnection con = MyConnection.getCon();
		MainScreen m=new MainScreen();
		con.printConfig();
		m.setVisible(true);
		
	}
}
