package GUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Models.Product;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.PaymentController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddToPaymentGUI extends JFrame {
	private JTextField textField;
	private JPanel parent;

	public AddToPaymentGUI(JPanel app,Product p) {
		this.parent=app;
		PaymentController con = new PaymentController (this,p);
		setSize(305,317);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("product Name"+p.getProductName());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(20, 11, 135, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("id: "+p.getSid());
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(20, 45, 135, 34);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("production date:"+p.getProductionYear());
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(20, 105, 135, 34);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("price: "+p.getPrice());
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(20, 71, 135, 34);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("quantity:"+p.getQuantity());
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(20, 131, 135, 34);
		getContentPane().add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("Enter quantity of product");
		lblNewLabel_1.setBounds(83, 165, 147, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(71, 190, 159, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAddToPayment = new JButton("add to payment");
		btnAddToPayment.addActionListener(con);
		btnAddToPayment.setBounds(32, 244, 109, 23);
		btnAddToPayment.setActionCommand("_add_product_to_payment");
		getContentPane().add(btnAddToPayment);
		
		JButton button = new JButton("Cancel");
		button.setBounds(152, 244, 109, 23);
		getContentPane().add(button);
		
	}
	public String getTextField() {
		return textField.getText().toString();
	}
	public JPanel getParentPanel() {
		return parent;
	}
	
}
