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
import Models.CustomerClaims;
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
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
/**
 * Add new patient GUI 
 * @author Ahmad Mnasra 
 *
 */
public class addClaimUI {

	private JFrame addInsurance;

	/**
	 * BirthDate chooses 
	 */
	private JDateChooser chooser= null;
	private JDateChooser chooser1= null;
	private JLabel msqlbl_7;
	private CustomerClaims product ; 
	private JLabel label;
	ClaimsPanel2 parent; 
	private JLabel lblProductId;
	JComboBox comboBox;
	JTextArea description;
	private JComboBox comboBox_1;
	public addClaimUI(CustomerClaims product, ClaimsPanel2 app ) {
		this.product=product;
		this.parent=app;
		initialize();
		addInsurance.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addInsurance = new JFrame();
		addInsurance.setTitle("Add New claim");
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
		addInsurance.getContentPane().add(chooser);

		JLabel logo = new JLabel("Add New Claim");
		logo.setBounds(10, 0, 346, 35);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Tahoma", Font.BOLD, 16));
		logo.setBackground(Color.WHITE);
		addInsurance.getContentPane().add(logo);


		JLabel lblCarNumber = new JLabel("insurance Type");
		lblCarNumber.setBounds(10, 89, 90, 26);
		addInsurance.getContentPane().add(lblCarNumber);

		JLabel lblStartDate = new JLabel("start date");
		lblStartDate.setBounds(20, 124, 90, 26);
		addInsurance.getContentPane().add(lblStartDate);
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
				
				product.setClientID(comboBox.getSelectedItem().toString());
				product.setCreationDate(chooser.getDate());
				product.setInsuranceType(comboBox_1.getSelectedItem().toString());
				product.setDescription(description.getText().toString());;
				product.addItem();
				//String[] doc_columnNames = { "sid","Client ID","Type","Creation Date","Description"};
				DefaultTableModel dm2 = (DefaultTableModel) parent.getApps_table().getModel();
				dm2.addRow(new Object[] {product.getSid(),product.getClientID(),product.getInsuranceType(),product.getCreationDate(),product.getDescription()});
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

		comboBox = new JComboBox();
		comboBox.setBounds(105, 52, 200, 22);
		addInsurance.getContentPane().add(comboBox);
		comboBox.addItem("");
		for (Client c : Client.getItems()) {
			comboBox.addItem(c.getClientID());
		}
		JLabel lblPolicyNumber = new JLabel("description");
		lblPolicyNumber.setBounds(10, 163, 90, 26);
		addInsurance.getContentPane().add(lblPolicyNumber);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(105, 89, 200, 22);
		comboBox_1.addItem("Home");
		comboBox_1.addItem("Car");
		comboBox_1.addItem("Life");
		comboBox_1.addItem("Work disability");

		addInsurance.getContentPane().add(comboBox_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(105, 163, 200, 171);
		addInsurance.getContentPane().add(scrollPane_1);
		
		description = new JTextArea();
		scrollPane_1.setViewportView(description);
		description.setBackground(Color.WHITE);

		addInsurance.setBounds(100, 100, 407, 418);
		addInsurance.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public CustomerClaims getProduct() {
		return product;
	}
}
