package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import GUI.AddProductUI;
import GUI.AddToPaymentGUI;
import GUI.VacumCleanerPanel;
import Models.*;
import Utils.Logger;
import Utils.Messages;

public class VacuumCleanerController implements ActionListener {


	//ArrayList<Product> 
	private VacumCleanerPanel app;
	public VacuumCleanerController(VacumCleanerPanel thisref) {
		// TODO Auto-generated constructor stub
	this.app=thisref;
	getProductsToGUI(thisref);
	}
	public VacuumCleanerController(JFrame addProduct) {
		// TODO Auto-generated constructor stub
	}
	public void getProductsToGUI(VacumCleanerPanel app) {
		((VacumCleanerPanel) app).setdata((ArrayList<VacuumCleaners>) VacuumCleaners.getProducts()); 
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
			
			row = (app).getApps_table().getSelectedRow();
			if(row<0){
				Messages.errorMessage("Please select an product from the table below", "No product selected", null);
				return;
			}
			product= (VacuumCleaners) (app).getApps_list().get(row);
			
			Logger.getInstance().debug("add quantity to "+product.getProductName());
			product.setQuantity(product.getQuantity()+30);
			( app).getApps_list().set(row, product);
			
			Logger.getInstance().debug("update value in gui ");
			(app).getApps_table().getModel().setValueAt(product.getQuantity(), row, 4);
			( app).getApps_table().updateUI();
			( app).updateUI();
			( app).repaint();
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
		row = (app).getApps_table().getSelectedRow();
		if(row<0){
			Messages.errorMessage("Please select an product from the table below", "No product selected", null);
			return;
		}
		AddToPaymentGUI addGui=new AddToPaymentGUI(app,app.getApps_list().get(row));
		addGui.setVisible(true);
		
		break;
		case "_add_production":
		AddProductUI productGui = new  AddProductUI(new VacuumCleaners(),app);

		break;
			case "_delete_product" : 
			Logger.getInstance().debug("delete product");
			row = ( app).getApps_table().getSelectedRow();
			if(row<0){
				Messages.errorMessage("Please select an product from the table below", "No product selected", null);
				return;
			}
			if(Messages.confirmMessage("product delete", "product", null)==0){
	
					product= (VacuumCleaners) (app).getApps_list().get(row);
					product.deleteProduct();
					app.getApps_list().remove(row);
					DefaultTableModel dm = (DefaultTableModel) (app).getApps_table().getModel();
					dm.removeRow(row);
				
					Messages.successMessage("product delete", "product", null);
					}
			break; 
		}

		
	}

}

		
		