package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import Models.AirConditioners;
import Models.Product;
import Models.VacuumCleaners;
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

import controller.AirConditionController;
import controller.RefrigeratorsController;
import controller.VacuumCleanerController;

import java.util.ArrayList;
import java.util.List;

public class VacumCleanerPanel extends JPanel implements InterfaceComposite{

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

	private VacumCleanerPanel thisref=this;
	private ArrayList<Product> apps_list= new  ArrayList<Product>();
	private ArrayList<VacuumCleaners> data;
	VacuumCleanerController cont;
	MainScreen mainScreen; 

	/**
	 * 
	 * @param mainScreen 
	 * 
	 *            : Models Patient instance
	 */
	public VacumCleanerPanel(MainScreen mainScreen) {
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
		
				JLabel logo = new JLabel("Air conditions products ");
				logo.setBounds(340, 0, 242, 45);
				panel.add(logo);
				logo.setForeground(Color.DARK_GRAY);
				logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
				logo.setBackground(Color.WHITE);

		 cont=new VacuumCleanerController(thisref);

		cancel_btn = new JButton("delete selected product");
		cancel_btn.addActionListener((ActionListener) cont);
		cancel_btn.setActionCommand("_delete_product");
		cancel_btn.setEnabled(false);

		cancel_btn.setBounds(194, 112, 174, 30);
		app.add(cancel_btn);

		JScrollPane apps_scrollPane = new JScrollPane();
		apps_scrollPane.setBounds(10, 147, 732, 307);
		app.add(apps_scrollPane);

		String[] doc_columnNames = { "sid","product name","production Year","price","quantity in store"};
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
		TableColumn action1 = apps_table.getColumn("price");
		action1.setPreferredWidth(1);
		TableColumn action2 = apps_table.getColumn("quantity in store");
		action2.setPreferredWidth(30);
		JButton button = new JButton("order more product");
		button.setEnabled(false);
		button.setActionCommand("_order_product");
		button.addActionListener((ActionListener) cont);
		button.setBounds(377, 112, 174, 30);
		app.add(button);
		JButton newApp_btn = new JButton("Buy & add to Payment");
		newApp_btn.setEnabled(false);
		newApp_btn.addActionListener((ActionListener) cont);
		newApp_btn.setActionCommand("_add_product_card");

		JButton button_1 = new JButton("Add new Product");
		button_1.addActionListener(cont);
		button_1.setActionCommand("_add_production");
		button_1.setBounds(10, 112, 174, 30);
		app.add(button_1);
		
		apps_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				cancel_btn.setEnabled(true);
				button.setEnabled(true);
				newApp_btn.setEnabled(true);

			}
		});

		
		newApp_btn.setBounds(561, 112, 174, 30);
		app.add(newApp_btn);

		// ---------------------------------
	//	app.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { logo }));
		app.setBounds(100, 100, 905, 547);
		
	
		initData();

	}

	private void initData() {
		// TODO Auto-generated method stub
		if (data != null) {
			DefaultTableModel dm = (DefaultTableModel) apps_table.getModel();
			dm.setRowCount(0);
			if (apps_list != null && apps_list.size() > 0)
				apps_list.clear();
			for (Product  a : data) {
				dm.addRow(new Object[] { a.getSid(),a.getProductName()
						,a.getProductionYear(),a.getPrice(),a.getQuantity()});
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
	public ArrayList<Product> getApps_list() {
		return apps_list;
	}
	public void setdata(ArrayList<VacuumCleaners> list){
		
		 this.data=list;
	}	
}
