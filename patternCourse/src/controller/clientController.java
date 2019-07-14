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

import GUI.addInsuranceUI;
import GUI.ClientPanel;
import GUI.addClient;
import Models.*;
import Utils.Logger;
import Utils.Messages;

public class clientController implements ActionListener {


	//ArrayList<Product> 
	private ClientPanel app;
	
	public clientController(ClientPanel app) {
		// TODO Auto-generated constructor stub
	this.app=app;
	getProductsToGUI(app);
	}
	public clientController(JFrame addProduct) {
		// TODO Auto-generated constructor stub
	}
	public void getProductsToGUI(ClientPanel app) {
		((ClientPanel) app).setdata((ArrayList<Client>) Client.getItems()); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row ;
		Client client;
		switch (e.getActionCommand())
		{
//		case ("_order_product"):
//			Logger.getInstance().debug("click order button");
//			
//			row = (app).getApps_table().getSelectedRow();
//			if(row<0){
//				Messages.errorMessage("Please select an product from the table below", "No product selected", null);
//				return;
//			}
//			client= (Client) (app).getApps_list().get(row);
//			
//			Logger.getInstance().debug("add quantity to "+client.getProductName());
//			client.setQuantity(client.getQuantity()+30);
//			( app).getApps_list().set(row, client);
//			
//			Logger.getInstance().debug("update value in gui ");
//			(app).getApps_table().getModel().setValueAt(client.getQuantity(), row, 4);
//			( app).getApps_table().updateUI();
//			( app).updateUI();
//			( app).repaint();
//			Logger.getInstance().debug("update value in gui ");
//			try {
//				client.update();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			break;
//		case ("_add_product_card"):
//			Logger.getInstance().debug("product add to payment /card");
//		row = (app).getApps_table().getSelectedRow();
//		if(row<0){
//			Messages.errorMessage("Please select an product from the table below", "No product selected", null);
//			return;
//		}
//		AddToPaymentGUI addGui=new AddToPaymentGUI((ClientPanel) app,(AirConditioners) ((ClientPanel) app).getApps_list().get(row));
//		addGui.setVisible(true);
//		
//		break;
		
		case "_add_production":
		//	Client c = new Client();
			addClient productGui = new  addClient(new Client(),app);

		break;
			case "_delete_product" : 
			Logger.getInstance().debug("delete product");
			row = ( app).getApps_table().getSelectedRow();
			if(row<0){
				Messages.errorMessage("Please select an product from the table below", "No product selected", null);
				return;
			}
			if(Messages.confirmMessage("product delete", "product", null)==0){
	
					client= (Client) (app).getApps_list().get(row);
					client.deleteItem();
					app.getApps_list().remove(row);
					DefaultTableModel dm = (DefaultTableModel) ((ClientPanel) app).getApps_table().getModel();
					dm.removeRow(row);
				
					Messages.successMessage("product delete", "product", null);
					}
			break; 
		}

		
	}

}

		
		