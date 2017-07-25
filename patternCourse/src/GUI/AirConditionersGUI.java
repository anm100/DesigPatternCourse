package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import Models.AirConditioners;
import Models.Product;
import Utils.Messages;
import Utils.MyTableModel;

//import org.eclipse.wb.swing.FocusTraversalOnArray;








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

import controller.controller;

import java.util.ArrayList;
/**
 * Appointments window , shows all needed information about specific patient :
 * shows all patient's future appointments sorted in table by appointment time
 * Ascending. option for add new appointment for this patient option to cancel
 * specific appointment.
 * 
 * @author Muhamad Igbaria
 *
 */
public class AirConditionersGUI extends JPanel {

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

	private AirConditionersGUI thisref=this;
	private ArrayList<Product> apps_list= new  ArrayList<Product>();
	private ArrayList<Product> data;
	controller cont;

	/**
	 * 
	 * @param patient
	 *            : Models Patient instance
	 */
	public AirConditionersGUI() {
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

		JLabel logo = new JLabel("Air conditions products ");
		logo.setBounds(0, 0, 495, 59);
		logo.setForeground(Color.DARK_GRAY);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		//logo.setIcon(Resources.getIcon("logo.png"));
		app.add(logo);

		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 621, 45);
		app.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 126, 21);
		panel.add(lblNewLabel);

		JLabel name_lbl = new JLabel("");
		name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name_lbl.setBounds(146, 11, 140, 21);
		panel.add(name_lbl);

		JLabel lblPhone = new JLabel("");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(298, 11, 49, 21);
		panel.add(lblPhone);

		JLabel status_lbl = new JLabel("");
		status_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		status_lbl.setBounds(339, 11, 85, 21);
		panel.add(status_lbl);

		 cont=new controller(thisref);

		cancel_btn = new JButton("order more product");
		cancel_btn.addActionListener((ActionListener) cont);
		cancel_btn.setActionCommand("_order_product");
//		cancel_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				int row = apps_table.getSelectedRow();
//				if(row<0){
//					Messages.errorMessage("Please select an action from the table below", "No action selected", null);
//					return;
//				}
//			
//				/*	if (ActionCondController.deleteAppointment(apps_list.get(row)) == false) {
//						JOptionPane.showMessageDialog(cancel_btn, "Cannot complete the request", "Cancel Action",
//								JOptionPane.ERROR_MESSAGE);
//					} else {
//						apps_list.remove(row);
//						DefaultTableModel dm = (DefaultTableModel) apps_table.getModel();
//						dm.removeRow(row);
//						Messages.successMessage("Action Canceled", "Action Appointment", null);
//					}*/
//				
//				cancel_btn.setEnabled(false);
//			}
//		});
		cancel_btn.setEnabled(false);

		cancel_btn.setBounds(189, 112, 174, 30);
		app.add(cancel_btn);

		JScrollPane apps_scrollPane = new JScrollPane();
		apps_scrollPane.setBounds(10, 147, 710, 307);
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
		
		
		apps_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				cancel_btn.setEnabled(true);
			}
		});

		JButton newApp_btn = new JButton("Add selected product to card");
		newApp_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				actionGui=	new AddActionGUI();
//				actionGui.setAddActionListener(thisref);
//				actionGui.setVisible(true);
//			WorkSpace.getLog().debug("add new action button");
			}

			
		});
		newApp_btn.setBounds(10, 112, 174, 30);
		app.add(newApp_btn);

		// ---------------------------------
	//	app.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { logo }));
		app.setBounds(100, 100, 730, 547);
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
	public void setdata(ArrayList<Product> list){
		
		 this.data=list;
	}

}
