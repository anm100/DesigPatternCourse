package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import Models.CarInsurance;
import Models.Client;
import Models.Insurance;


import Utils.Messages;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import controller.clientController;
import controller.itemController;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class addInsuranceUI {

	private JFrame addInsurance;
	
	/**
	 * Patient Controller instance
	 */
	private itemController idctrl = new itemController(this);
	private JTextField carNumber;
	private JTextField price;

	/**
	 * BirthDate chooses 
	 */
	private JDateChooser chooser= null;
	private JDateChooser chooser1= null;

	private JLabel msqlbl;
	private JLabel msqlbl_1;
	private JLabel msqlbl_2;
	private JLabel msqlbl_4;
	private JLabel msqlbl_5;
	private JLabel msqlbl_6;
	private JLabel msqlbl_7;
	private CarInsurance product ; 
	private JLabel label;
	InterfaceComposite parent; 
	private JLabel lblProductId;
	private JLabel lblExpDate;
	private JLabel lblCompany;
	private JTextField company;
	private JTextField policyNumber;
	JComboBox comboBox;
	public addInsuranceUI(CarInsurance product, InterfaceComposite parent ) {
		this.product=product;
		this.parent=parent;
		initialize();
		addInsurance.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addInsurance = new JFrame();
		addInsurance.setTitle("Add New insurance");
		addInsurance.setResizable(false);
		addInsurance.setForeground(Color.BLACK);
		addInsurance.setFont(new Font("Dialog", Font.PLAIN, 16));
		addInsurance.setBackground(Color.WHITE);
		addInsurance.getContentPane().setBackground(Color.WHITE);
		addInsurance.getContentPane().setLayout(null);

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
		
		chooser1 = new JDateChooser();

		
		chooser1.enableInputMethods(false);
		chooser1.setBackground(Color.GRAY);
		chooser1.setLocale(Locale.US);
		chooser1.setBounds(105, 166, 200, 26);
		chooser1.setVisible(true);
		chooser1.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				JDateChooser chooser = (JDateChooser) evt.getSource();
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				textField.setText(formatter.format(chooser.getDate()));
			}
		});
		JTextFieldDateEditor editor1 = (JTextFieldDateEditor) chooser1.getDateEditor();
		editor1.setEditable(false);
		chooser1.setDate(new Date());
	
		addInsurance.getContentPane().add(chooser1);
		addInsurance.getContentPane().add(chooser);

		JLabel logo = new JLabel("Add New insurance");
		logo.setBounds(10, 0, 346, 35);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Tahoma", Font.BOLD, 16));
		logo.setBackground(Color.WHITE);
		addInsurance.getContentPane().add(logo);


		JLabel lblCarNumber = new JLabel("car number");
		lblCarNumber.setBounds(20, 87, 90, 26);
		addInsurance.getContentPane().add(lblCarNumber);

		JLabel lblStartDate = new JLabel("start date");
		lblStartDate.setBounds(20, 124, 90, 26);
		addInsurance.getContentPane().add(lblStartDate);

		JLabel lblPhone = new JLabel("price:");
		lblPhone.setBounds(20, 281, 77, 35);
		addInsurance.getContentPane().add(lblPhone);

		carNumber = new JTextField();
		carNumber.setColumns(10);
		carNumber.setBounds(105, 87, 200, 26);

		addInsurance.getContentPane().add(carNumber);
		/**
		 * check if all requirement field is filled . call to
		 * AddNewPatient method in PatientController to add the
		 * patient show success message to user or warning message if patient is exist 
		 */
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(59, 347, 110, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInsurance.setBounds(addInsurance.getX(), addInsurance.getY(), 350, addInsurance.getHeight());
				product.setNumberofpolicy(policyNumber.getText().toString()); 
				product.setClientID(comboBox.getSelectedItem().toString());
				product.setCompanyInsurance(company.getText().toString());
				product.setCarNumber(carNumber.getText().toString());
				product.setPrice(Integer.parseInt(price.getText().toString()));
				
				product.setStartDate(chooser.getDate());
				product.setEndDate(chooser1.getDate());
				product.addItem();
				//		String[] doc_columnNames = { "sid","Policy Number","Client ID","Car Number","Company insurance","start date","expiration date","price"};
				DefaultTableModel dm2 = (DefaultTableModel) parent.getApps_table().getModel();
				dm2.addRow(new Object[] {product.getSid(),product.getNumberofpolicy(),product.getClientID(),product.getCarNumber(),product.getCompanyInsurance(),product.getStartDate(),product.getEndDate(),product.getPrice()});
				parent.getApps_list().add(product);
				
				//idctrl.addNewProduct(product);
				/**
				 * Patient Controller 
				 */					
				Messages.successMessage("product was added successfully", "Success", null);
				addInsurance.dispose();
				return;
			}

		});
		addInsurance.getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int result = Messages.confirmMessage("Are you sure you want to cancel?","GHealth" , null);
				if(result == JOptionPane.YES_OPTION)
						addInsurance.dispose();
			}
		});

		btnNewButton_1.setBounds(193, 347, 118, 23);
		addInsurance.getContentPane().add(btnNewButton_1);

		price = new JTextField();
		price.setColumns(10);
		price.setBounds(105, 285, 77, 26);
		addInsurance.getContentPane().add(price);

		msqlbl = new JLabel("");
		msqlbl.setForeground(Color.RED);
		msqlbl.setBounds(345, 71, 145, 35);
		addInsurance.getContentPane().add(msqlbl);

		msqlbl_1 = new JLabel("");
		msqlbl_1.setForeground(Color.RED);
		msqlbl_1.setBounds(345, 101, 145, 35);
		addInsurance.getContentPane().add(msqlbl_1);

		msqlbl_2 = new JLabel("");
		msqlbl_2.setForeground(Color.RED);
		msqlbl_2.setBounds(345, 131, 145, 35);
		addInsurance.getContentPane().add(msqlbl_2);

		msqlbl_4 = new JLabel("");
		msqlbl_4.setForeground(Color.RED);
		msqlbl_4.setBounds(345, 191, 145, 35);
		addInsurance.getContentPane().add(msqlbl_4);

		msqlbl_5 = new JLabel("");
		msqlbl_5.setForeground(Color.RED);
		msqlbl_5.setBounds(345, 221, 155, 35);
		addInsurance.getContentPane().add(msqlbl_5);

		msqlbl_6 = new JLabel("");
		msqlbl_6.setForeground(Color.RED);
		msqlbl_6.setBounds(345, 251, 145, 35);
		addInsurance.getContentPane().add(msqlbl_6);

		msqlbl_7 = new JLabel("");
		msqlbl_7.setForeground(Color.RED);
		msqlbl_7.setBounds(345, 281, 145, 35);
		addInsurance.getContentPane().add(msqlbl_7);
		
		label = new JLabel((String) null);
		label.setBounds(22, 71, 64, 35);
		addInsurance.getContentPane().add(label);
		
		lblProductId = new JLabel("Client");
		lblProductId.setBounds(20, 50, 90, 26);
		addInsurance.getContentPane().add(lblProductId);
		
		lblExpDate = new JLabel("Exp Date");
		lblExpDate.setBounds(20, 166, 90, 26);
		addInsurance.getContentPane().add(lblExpDate);
		
		lblCompany = new JLabel("company");
		lblCompany.setBounds(20, 205, 90, 26);
		addInsurance.getContentPane().add(lblCompany);
		
		company = new JTextField();
		company.setColumns(10);
		company.setBounds(105, 205, 200, 26);
		addInsurance.getContentPane().add(company);

		comboBox = new JComboBox();
		comboBox.setBounds(105, 52, 200, 22);
		addInsurance.getContentPane().add(comboBox);
		comboBox.addItem("");
		for (Client c : Client.getItems()) {
			comboBox.addItem(c.getClientID());
		}
		JLabel lblPolicyNumber = new JLabel("Policy Number");
		lblPolicyNumber.setBounds(20, 248, 90, 26);
		addInsurance.getContentPane().add(lblPolicyNumber);
		
		policyNumber = new JTextField();
		policyNumber.setColumns(10);
		policyNumber.setBounds(105, 251, 200, 26);
		addInsurance.getContentPane().add(policyNumber);

		addInsurance.setBounds(100, 100, 407, 418);
		addInsurance.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public Insurance getProduct() {
		return product;
	}
}
