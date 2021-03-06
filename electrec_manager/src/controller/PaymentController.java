package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import GUI.AddToPaymentGUI;
import GUI.AirConditionersPanel;
import GUI.MainScreen;
import GUI.PaymentPanel;
import Models.*;
import Utils.Logger;
import Utils.Messages;

public class PaymentController implements ActionListener {
	
	final static ArrayList<Payment> payment = new ArrayList<Payment>();
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
		app=thisref;
	}
	public PaymentController(MainScreen mainScreen) {
		// TODO Auto-generated constructor stub
		app=mainScreen;
	}
	public void getProductsToGUI(PaymentPanel app) {
		((PaymentPanel) app).setdata(payment); 
	}
	public int calcSum(){
		int totall=0; 
	for(Payment i:payment){
		totall+=i.getPrice()*i.getQuantity();
		}
	return totall; 
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
			Payment p = new Payment(product.getSid(),product.getProductName(),product.getPrice(),counter);
			addProduct(p);
			Messages.successMessage("product added to payment", "payment", null);
			Logger.getInstance().debug("added to payment"+payment.toString());
			row=((((AddToPaymentGUI)app).getParentPanel()).getApps_table().getSelectedRow());
			( ((AddToPaymentGUI)app).getParentPanel()).getApps_list().set(row, product);
			( ((AddToPaymentGUI) app).getParentPanel()).getApps_table().getModel().setValueAt(product.getQuantity(), row, 4);
			( ((AddToPaymentGUI)app).getParentPanel()).getApps_table().updateUI();
			app.dispose();
		}
		break;
		case "_payment_show": 
			PaymentPanel guiPayment =new  PaymentPanel(payment,calcSum());
			guiPayment.getFrame().setVisible(true);
			break; 
		case "_purchase_product":
			row = ((PaymentPanel) app).getApps_table().getSelectedRow();
			if(row<0){
				Messages.errorMessage("payment empty ", "payment empty ", null);
				return;
			}
			if(Messages.confirmMessage("Do you purchase products in this Payment", "product", null)==0){
				clearPayment();
				DefaultTableModel dm = (DefaultTableModel) ( (PaymentPanel) app).getApps_table().getModel();
				((PaymentPanel) app).getFrame().dispose();	
				Messages.successMessage("Payment has been purchased", "product", null);
				}
			break; 
		case "_Cancel_product_payment":
			if(Messages.confirmMessage("product delete", "product", null)==0){
				row = ((PaymentPanel) app).getApps_table().getSelectedRow();

				Payment	product2= (Payment) ((PaymentPanel) app).getApps_list().get(row);
				((PaymentPanel) app).getApps_list().remove(row);
				DefaultTableModel dm = (DefaultTableModel) ((PaymentPanel) app).getApps_table().getModel();
				dm.removeRow(row);		
				Messages.successMessage("product canceled from this payment", "product", null);
				}
		break; 
		}
		
	}

}

		
		