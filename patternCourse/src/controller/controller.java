package controller;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import GUI.AirConditionersGUI;
import Models.AirConditioners;

public class controller {


	private ArrayList<AirConditioners> products = new ArrayList<AirConditioners>();
	private AirConditionersGUI app; 
	
	public controller(AirConditionersGUI app) {
		// TODO Auto-generated constructor stub
	this.app=app;
	getProducts();
	}
	public void getProducts() {
		app.setdata((ArrayList<AirConditioners>) AirConditioners.getProducts()); 
	}
}

		
		