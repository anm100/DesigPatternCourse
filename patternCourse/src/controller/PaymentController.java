package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.AddToPaymentGUI;
import GUI.AirConditionersPanel;
import GUI.PaymentPanel;
import Models.*;
import Utils.Logger;
import Utils.Messages;

public class PaymentController implements ActionListener {
	
	static ArrayList<Payment> payment = new ArrayList<Payment>();
	private Product product; 
	private JFrame app ; 

	public static void addProduct(Payment p){
		payment.add(p);
	}
	public static void  removeProduct(Payment p){
		payment.remove(p);
	}
	public static void  clearPayment(){
		payment.clear();
	}
	
	//ArrayList<Product> 
	public PaymentController(AddToPaymentGUI thisref,Product product ) {
		// TODO Auto-generated constructor stub
		app=thisref;
		this.product=product;
	}
	public PaymentController(PaymentPanel thisref) {
		// TODO Auto-generated constructor stub
	}
	public void getProductsToGUI(PaymentPanel app) {
		((PaymentPanel) app).setdata(payment); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row ;
		switch (e.getActionCommand())
		{
		case ("_add_product_to_payment"):
			Logger.getInstance().debug("click  add to payment button");
		int counter=Integer.parseInt(((AddToPaymentGUI) app).getTextField()) ; 
		if (counter > product.getQuantity() ){
			Messages.errorMessage("Quantity More Than Enough product Store", "Quantity", null);
			return;	
		}else {
			product.setQuantity(product.getQuantity()-counter);
			product.updateProduct();
			Payment p = new Payment();
			p.addProduct(product);
			p.setQuantity(counter);
			addProduct(p);
			Messages.successMessage("product added to payment", "payment", null);
			Logger.getInstance().debug("added to payment"+payment.toString());
			row=((AirConditionersPanel) ((AddToPaymentGUI)app).getParentPanel()).getApps_table().getSelectedRow();
			((AirConditionersPanel) ((AddToPaymentGUI)app).getParentPanel()).getApps_list().set(row, product);
			((AirConditionersPanel) ((AddToPaymentGUI)app).getParentPanel()).getApps_table().updateUI();
			app.dispose();
			
		}
		

	
		}
		
	}

}

		
		