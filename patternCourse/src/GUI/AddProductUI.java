package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import Models.Product;


import Utils.Messages;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import controller.AirConditionController;
import controller.productController;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 * Add new patient GUI 
 * @author Ahmad Mnasra 
 *
 */
public class AddProductUI {

	private JFrame addProduct;
	
	/**
	 * Patient Controller instance
	 */
	private productController idctrl = new productController(this);
	private JTextField FnameField;
	private JTextField PhoneField;
	private JTextField EmailField;

	/**
	 * BirthDate chooses 
	 */
	private JDateChooser chooser= null;

	private JLabel msqlbl;
	private JLabel msqlbl_1;
	private JLabel msqlbl_2;
	private JLabel msqlbl_4;
	private JLabel msqlbl_5;
	private JLabel msqlbl_6;
	private JLabel msqlbl_7;
	private Product product ; 
	private JLabel label;
	InterfaceComposite parent; 
	private JLabel lblProductId;
	private JTextField textField_1;

	public AddProductUI(Product product, InterfaceComposite parent ) {
		this.product=product;
		this.parent=parent;
		initialize();
		addProduct.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addProduct = new JFrame();
		addProduct.setTitle("Add New product");
		addProduct.setResizable(false);
		addProduct.setForeground(Color.BLACK);
		addProduct.setFont(new Font("Dialog", Font.PLAIN, 16));
		addProduct.setBackground(Color.WHITE);
		addProduct.getContentPane().setBackground(Color.WHITE);
		addProduct.getContentPane().setLayout(null);

		JTextField textField = new JTextField(15);
		chooser = new JDateChooser();

		
		chooser.enableInputMethods(false);
		chooser.setBackground(Color.GRAY);
		chooser.setLocale(Locale.US);
		chooser.setBounds(105, 124, 200, 26);
		chooser.setVisible(true);
		chooser.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				JDateChooser chooser = (JDateChooser) evt.getSource();
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				textField.setText(formatter.format(chooser.getDate()));
			}
		});
		JTextFieldDateEditor editor = (JTextFieldDateEditor) chooser.getDateEditor();
		editor.setEditable(false);
		chooser.setDate(new Date());
		
		
	
		addProduct.getContentPane().add(chooser);

		JLabel logo = new JLabel("Add New product");
		logo.setBounds(10, 0, 346, 35);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Tahoma", Font.BOLD, 16));
		logo.setBackground(Color.WHITE);
		addProduct.getContentPane().add(logo);


		JLabel label_1 = new JLabel("product Name:");
		label_1.setBounds(20, 87, 90, 26);
		addProduct.getContentPane().add(label_1);

		JLabel label_3 = new JLabel("production date:");
		label_3.setBounds(20, 124, 90, 26);
		addProduct.getContentPane().add(label_3);

		JLabel lblPhone = new JLabel("price:");
		lblPhone.setBounds(194, 157, 35, 35);
		addProduct.getContentPane().add(lblPhone);

		JLabel lblEmail = new JLabel("quantity:");
		lblEmail.setBounds(57, 157, 64, 35);
		addProduct.getContentPane().add(lblEmail);

		FnameField = new JTextField();
		FnameField.setColumns(10);
		FnameField.setBounds(105, 87, 200, 26);

		addProduct.getContentPane().add(FnameField);

		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setBounds(107, 161, 77, 26);
		addProduct.getContentPane().add(EmailField);
		/**
		 * check if all requirement field is filled . call to
		 * AddNewPatient method in PatientController to add the
		 * patient show success message to user or warning message if patient is exist 
		 */
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(42, 203, 110, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct.setBounds(addProduct.getX(), addProduct.getY(), 350, addProduct.getHeight());
				product.setSid(Integer.parseInt(textField_1.getText().toString())); 
				product.setProductName(FnameField.getText());
				product.setPrice(Integer.parseInt(EmailField.getText().toString()));
				product.setQuantity(Integer.parseInt(PhoneField.getText().toString()));
				product.setProductionYear((chooser.getDate()));
				
				DefaultTableModel dm2 = (DefaultTableModel) parent.getApps_table().getModel();
				dm2.addRow(new Object[] {product.getSid(),product.getProductName(),product.getProductionYear(),product.getPrice(),product.getQuantity()});
				parent.getApps_list().add(product);
				idctrl.addNewProduct(product);
				/**
				 * Patient Controller 
				 */					
				Messages.successMessage("product was added successfully", "Success", null);
				addProduct.dispose();
				return;
			}

		});
		addProduct.getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int result = Messages.confirmMessage("Are you sure you want to cancel?","GHealth" , null);
				if(result == JOptionPane.YES_OPTION)
						addProduct.dispose();
			}
		});

		btnNewButton_1.setBounds(176, 203, 118, 23);
		addProduct.getContentPane().add(btnNewButton_1);

		PhoneField = new JTextField();
		PhoneField.setColumns(10);
		PhoneField.setBounds(229, 161, 77, 26);
		addProduct.getContentPane().add(PhoneField);

		msqlbl = new JLabel("");
		msqlbl.setForeground(Color.RED);
		msqlbl.setBounds(345, 71, 145, 35);
		addProduct.getContentPane().add(msqlbl);

		msqlbl_1 = new JLabel("");
		msqlbl_1.setForeground(Color.RED);
		msqlbl_1.setBounds(345, 101, 145, 35);
		addProduct.getContentPane().add(msqlbl_1);

		msqlbl_2 = new JLabel("");
		msqlbl_2.setForeground(Color.RED);
		msqlbl_2.setBounds(345, 131, 145, 35);
		addProduct.getContentPane().add(msqlbl_2);

		msqlbl_4 = new JLabel("");
		msqlbl_4.setForeground(Color.RED);
		msqlbl_4.setBounds(345, 191, 145, 35);
		addProduct.getContentPane().add(msqlbl_4);

		msqlbl_5 = new JLabel("");
		msqlbl_5.setForeground(Color.RED);
		msqlbl_5.setBounds(345, 221, 155, 35);
		addProduct.getContentPane().add(msqlbl_5);

		msqlbl_6 = new JLabel("");
		msqlbl_6.setForeground(Color.RED);
		msqlbl_6.setBounds(345, 251, 145, 35);
		addProduct.getContentPane().add(msqlbl_6);

		msqlbl_7 = new JLabel("");
		msqlbl_7.setForeground(Color.RED);
		msqlbl_7.setBounds(345, 281, 145, 35);
		addProduct.getContentPane().add(msqlbl_7);
		
		label = new JLabel((String) null);
		label.setBounds(22, 71, 64, 35);
		addProduct.getContentPane().add(label);
		
		lblProductId = new JLabel("product id:");
		lblProductId.setBounds(20, 50, 90, 26);
		addProduct.getContentPane().add(lblProductId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(105, 51, 200, 26);
		addProduct.getContentPane().add(textField_1);

		addProduct.setBounds(100, 100, 352, 274);
		addProduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public Product getProduct() {
		return product;
	}
	
}
