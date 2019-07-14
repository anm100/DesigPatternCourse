package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import Models.Insurance;
import Models.CarInsurance;
import Models.CustomerClaims;
import Utils.MyTableModel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.clientController;
import controller.CarInsuranceController;
import controller.ClaimsController;

import java.util.ArrayList;
import java.util.List;

public class ClaimsPanel2 extends JPanel{

	/**
	 * appointments frame
	 */
	private JPanel app;
	/**
	 * all future patient's appointments table
	 */
	private JTable apps_table;
	JButton cancel_btn;

	/**
	 * the patient to show his information
	 */

	private ClaimsPanel2 thisref=this;
	private ArrayList<CustomerClaims> apps_list= new  ArrayList<CustomerClaims>();
	private ArrayList<CustomerClaims> data;
	ClaimsController cont;
	MainScreen mainScreen; 

	/**
	 * 
	 * @param mainScreen 
	 * 
	 *            : Models Patient instance
	 */
	public ClaimsPanel2(MainScreen mainScreen) {
		this.mainScreen=mainScreen;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		app = new JPanel();

		app.setForeground(Color.BLACK);
		app.setFont(new Font("Dialog", Font.PLAIN, 16));
		app.setBackground(Color.WHITE);
		app.setBackground(Color.WHITE);
		app.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 39, 905, 45);
		app.add(panel);
		panel.setLayout(null);

		JLabel lblPhone = new JLabel("");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(298, 11, 49, 21);
		panel.add(lblPhone);
		
				JLabel logo = new JLabel("Clients Claims");
				logo.setBounds(340, 0, 242, 45);
				panel.add(logo);
				logo.setForeground(Color.DARK_GRAY);
				logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
				logo.setBackground(Color.WHITE);

		 cont=new ClaimsController(thisref);

		cancel_btn = new JButton("delete selected Claim");
		cancel_btn.addActionListener((ActionListener) cont);
		cancel_btn.setActionCommand("_delete_product");
		cancel_btn.setEnabled(false);

		cancel_btn.setBounds(194, 112, 174, 30);
		app.add(cancel_btn);

		JScrollPane apps_scrollPane = new JScrollPane();
		apps_scrollPane.setBounds(10, 147, 732, 307);
		app.add(apps_scrollPane);

		String[] doc_columnNames = { "sid","Client ID","Type","Creation Date","Description"};
		Object[][] doc_data = {};
		apps_table = new JTable();
		apps_table.setModel(new MyTableModel(doc_columnNames, doc_data));
		//getProducts();
		apps_table.setFillsViewportHeight(true);
		apps_table.setSurrendersFocusOnKeystroke(true);
		apps_table.setShowVerticalLines(false);
		apps_table.setRowHeight(30);
		apps_table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		apps_scrollPane.setViewportView(apps_table);
		apps_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		apps_table.setBackground(Color.WHITE);
		
		TableColumn action = apps_table.getColumn("sid");
		action.setPreferredWidth(3);
		TableColumn action1 = apps_table.getColumn("Client ID");
		action1.setPreferredWidth(1);
		TableColumn action2 = apps_table.getColumn("Type");
		action2.setPreferredWidth(3);

		JButton btnAddInsurance = new JButton("Add Claim");
		btnAddInsurance.addActionListener(cont);
		btnAddInsurance.setActionCommand("_add_production");
		btnAddInsurance.setBounds(10, 112, 174, 30);
		app.add(btnAddInsurance);
		
		apps_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				cancel_btn.setEnabled(true);


			}
		});

		// ---------------------------------
	//	app.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { logo }));
		app.setBounds(100, 100, 905, 547);
		
	
		initData();

	}
	//String[] doc_columnNames = { "sid","Client ID","Type","Creation Date","Description"};
	private void initData() {
		// TODO Auto-generated method stub
		if (data != null) {
			DefaultTableModel dm = (DefaultTableModel) apps_table.getModel();
			dm.setRowCount(0);
			if (apps_list != null && apps_list.size() > 0)
				apps_list.clear();
			for (CustomerClaims  a : data) {
				dm.addRow(new Object[] { a.getSid(),a.getClientID(),a.getInsuranceType(),a.getCreationDate(),a.getDescription()});
				apps_list.add(a);
			}
		}
	}
		
	
	/**
	 * 
	 * @return current JFrame
	 */
	public JPanel getFrame() {
		return app;
	}


	public JTable getApps_table() {
		return apps_table;
	}
	public ArrayList<CustomerClaims> getApps_list() {
		return apps_list;
	}
	public void setdata(ArrayList<CustomerClaims> list){
		
		 this.data=list;
	}	
}
