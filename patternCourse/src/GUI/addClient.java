package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

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
public class addClient {

	private JFrame addClient;
	
	/**
	 * Patient Controller instance
	 */
//	private clientController idctrl = new clientController(this);
	private JTextField FnameField;

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
	private Client item ; 
	private JLabel label;
	ClientPanel parent; 
	private JLabel lblProductId;
	private JTextField ClientID;
	private JTextField lastName;

	public addClient(Client item, ClientPanel parent ) {
		this.item=item;
		this.parent=parent;
		initialize();
		addClient.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addClient = new JFrame();
		addClient.setTitle("Add New Client");
		addClient.setResizable(false);
		addClient.setForeground(Color.BLACK);
		addClient.setFont(new Font("Dialog", Font.PLAIN, 16));
		addClient.setBackground(Color.WHITE);
		addClient.getContentPane().setBackground(Color.WHITE);
		addClient.getContentPane().setLayout(null);

		JTextField textField = new JTextField(15);

		JLabel logo = new JLabel("Add New Client");
		logo.setBounds(10, 0, 346, 35);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Tahoma", Font.BOLD, 16));
		logo.setBackground(Color.WHITE);
		addClient.getContentPane().add(logo);


		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(22, 87, 90, 26);
		addClient.getContentPane().add(lblFirstName);

		FnameField = new JTextField();
		FnameField.setColumns(10);
		FnameField.setBounds(105, 87, 200, 26);

		addClient.getContentPane().add(FnameField);
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
				addClient.setBounds(addClient.getX(), addClient.getY(), 350, addClient.getHeight());
				item.setClientID(ClientID.getText().toString());
				item.setFirstName(FnameField.getText().toString());
				item.setLastName(lastName.getText().toString());
				
				DefaultTableModel dm2 = (DefaultTableModel) parent.getApps_table().getModel();
				dm2.addRow(new Object[] {item.getSid(),item.getClientID(),item.getFirstName(),item.getLastName()});
				parent.getApps_list().add(item);
				item.addItem();
				/**
				 * Patient Controller 
				 */					
				Messages.successMessage("product was added successfully", "Success", null);
				addClient.dispose();
				return;
			}

		});
		addClient.getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int result = Messages.confirmMessage("Are you sure you want to cancel?","CLient" , null);
				if(result == JOptionPane.YES_OPTION)
						addClient.dispose();
			}
		});

		btnNewButton_1.setBounds(176, 203, 118, 23);
		addClient.getContentPane().add(btnNewButton_1);

		msqlbl = new JLabel("");
		msqlbl.setForeground(Color.RED);
		msqlbl.setBounds(345, 71, 145, 35);
		addClient.getContentPane().add(msqlbl);

		msqlbl_1 = new JLabel("");
		msqlbl_1.setForeground(Color.RED);
		msqlbl_1.setBounds(345, 101, 145, 35);
		addClient.getContentPane().add(msqlbl_1);

		msqlbl_2 = new JLabel("");
		msqlbl_2.setForeground(Color.RED);
		msqlbl_2.setBounds(345, 131, 145, 35);
		addClient.getContentPane().add(msqlbl_2);

		msqlbl_4 = new JLabel("");
		msqlbl_4.setForeground(Color.RED);
		msqlbl_4.setBounds(345, 191, 145, 35);
		addClient.getContentPane().add(msqlbl_4);

		msqlbl_5 = new JLabel("");
		msqlbl_5.setForeground(Color.RED);
		msqlbl_5.setBounds(345, 221, 155, 35);
		addClient.getContentPane().add(msqlbl_5);

		msqlbl_6 = new JLabel("");
		msqlbl_6.setForeground(Color.RED);
		msqlbl_6.setBounds(345, 251, 145, 35);
		addClient.getContentPane().add(msqlbl_6);

		msqlbl_7 = new JLabel("");
		msqlbl_7.setForeground(Color.RED);
		msqlbl_7.setBounds(345, 281, 145, 35);
		addClient.getContentPane().add(msqlbl_7);
		
		label = new JLabel((String) null);
		label.setBounds(22, 71, 64, 35);
		addClient.getContentPane().add(label);
		
		lblProductId = new JLabel("Client ID");
		lblProductId.setBounds(20, 50, 90, 26);
		addClient.getContentPane().add(lblProductId);
		
		ClientID = new JTextField();
		ClientID.setColumns(10);
		ClientID.setBounds(105, 51, 200, 26);
		addClient.getContentPane().add(ClientID);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(20, 124, 90, 26);
		addClient.getContentPane().add(lblLastName);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(105, 126, 200, 26);
		addClient.getContentPane().add(lastName);

		addClient.setBounds(100, 100, 352, 274);
		addClient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public Client getProduct() {
		return item;
	}
}
