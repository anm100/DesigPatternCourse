package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import GUI.AirConditionersGUI;
import Models.*;
import Utils.Logger;

public class controller implements ActionListener {


	//ArrayList<Product> 
	private JPanel app;
	public controller(AirConditionersGUI app) {
		// TODO Auto-generated constructor stub
	this.app=app;
	getProductsToGUI(app);
	}
	public void getProductsToGUI(AirConditionersGUI app) {
		((AirConditionersGUI) app).setdata((ArrayList<AirConditioners>) AirConditioners.getProducts()); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row ;
		Product product;
		switch (e.getActionCommand())
		{
		case ("_order_product"):
			Logger.getInstance().debug("click order button");

			row = ((AirConditionersGUI) app).getApps_table().getSelectedRow();
			product= (AirConditioners) ((AirConditionersGUI) app).getApps_list().get(row);
			
			Logger.getInstance().debug("add quntity to "+product.getProductName());
			product.setQuantity(product.getQuantity()+30);
			((AirConditionersGUI) app).getApps_list().set(row, product);
			
			Logger.getInstance().debug("update value in gui ");
			((AirConditionersGUI) app).getApps_table().getModel().setValueAt(product.getQuantity(), row, 4);
			((AirConditionersGUI) app).getApps_table().updateUI();
			Logger.getInstance().debug("update value in gui ");
			try {
				product.update();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case ("_add_product_card"):
			Logger.getInstance().debug("product add to payment /card");
		row = ((AirConditionersGUI) app).getApps_table().getSelectedRow();
		product= (AirConditioners) ((AirConditionersGUI) app).getApps_list().get(row);
		Payment p = new Payment();
		
		break;

		}
		
	}

}

		
		