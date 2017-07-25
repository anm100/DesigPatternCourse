package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import GUI.AddToPaymentGUI;
import GUI.AirConditionersPanel;
import Models.*;
import Utils.Logger;

public class AirConditionController implements ActionListener {


	//ArrayList<Product> 
	private JPanel app;
	public AirConditionController(AirConditionersPanel app) {
		// TODO Auto-generated constructor stub
	this.app=app;
	getProductsToGUI(app);
	}
	public void getProductsToGUI(AirConditionersPanel app) {
		((AirConditionersPanel) app).setdata((ArrayList<AirConditioners>) AirConditioners.getProducts()); 
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

			row = ((AirConditionersPanel) app).getApps_table().getSelectedRow();
			product= (AirConditioners) ((AirConditionersPanel) app).getApps_list().get(row);
			
			Logger.getInstance().debug("add quantity to "+product.getProductName());
			product.setQuantity(product.getQuantity()+30);
			((AirConditionersPanel) app).getApps_list().set(row, product);
			
			Logger.getInstance().debug("update value in gui ");
			((AirConditionersPanel) app).getApps_table().getModel().setValueAt(product.getQuantity(), row, 4);
			((AirConditionersPanel) app).getApps_table().updateUI();
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
		row = ((AirConditionersPanel) app).getApps_table().getSelectedRow();
		AddToPaymentGUI addGui=new AddToPaymentGUI(app,(AirConditioners) ((AirConditionersPanel) app).getApps_list().get(row));
		addGui.setVisible(true);
		
		break;

		}
		
	}

}

		
		