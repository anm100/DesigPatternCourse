package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import Models.AirConditioners;
import Models.Payment;
import Models.Product;
import Utils.Messages;
import Utils.MyTableModel;

//import org.eclipse.wb.swing.FocusTraversalOnArray;












import javax.swing.JFrame;
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
import controller.PaymentController;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Muhamad Igbaria
 *
 */
public class PaymentPanel extends JFrame {

	private JFrame app;
	private JTable apps_table;
	JButton cancel_btn;


	private PaymentPanel thisref=this;
	private ArrayList<Payment> apps_list= new  ArrayList<Payment>();
	private ArrayList<Payment> data;
	private int totall; 

	public PaymentPanel(ArrayList<Payment> data, int sum) {
		this.data=data;
		totall=sum; 
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		app = new JFrame();
		PaymentController cont = new PaymentController (thisref);
		app.setForeground(Color.BLACK);
		app.setFont(new Font("Dialog", Font.PLAIN, 16));
		app.setBackground(Color.WHITE);
		app.setBackground(Color.WHITE);
		app.getContentPane().setLayout(null);
		setSize(305,317);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 39, 905, 45);
		app.getContentPane().add(panel);
		panel.setLayout(null);
		
				JLabel logo = new JLabel("Payment");
				logo.setBounds(77, 0, 242, 45);
				panel.add(logo);
				logo.setForeground(Color.DARK_GRAY);
				logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
				logo.setBackground(Color.WHITE);


		cancel_btn = new JButton("cancel selected product");
		cancel_btn.addActionListener((ActionListener) cont);
		cancel_btn.setActionCommand("_delete_product");
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

		cancel_btn.setBounds(10, 112, 174, 30);
		app.getContentPane().add(cancel_btn);

		JScrollPane apps_scrollPane = new JScrollPane();
		apps_scrollPane.setBounds(10, 147, 356, 218);
		app.getContentPane().add(apps_scrollPane);

		String[] doc_columnNames = { "sid","product name","price","quantity in store"};
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
		app.setBounds(100, 100, 557, 447);
		
		JButton button = new JButton("purchase");
		button.addActionListener((ActionListener) cont);
		button.setActionCommand("_purchase_product");
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(376, 319, 159, 45);
		app.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Totall:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(376, 168, 159, 45);
		app.getContentPane().add(lblNewLabel);
		
		JLabel lblNumber = new JLabel(""+totall);
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNumber.setBounds(376, 231, 159, 45);
		app.getContentPane().add(lblNumber);
		
	
		initData();

	}

	private void initData() {
		// TODO Auto-generated method stub
		if (data != null) {
			DefaultTableModel dm = (DefaultTableModel) apps_table.getModel();
			dm.setRowCount(0);
			if (apps_list != null && apps_list.size() > 0)
				apps_list.clear();
			for (Payment  a : data) {
				dm.addRow(new Object[] { a.getSid(),a.getProductName()
						,a.getPrice(),a.getQuantity()});
				apps_list.add(a);
			}
		}
	}
		
	
	/**
	 * 
	 * @return current JFrame
	 */
	public JFrame getFrame() {
		return app;
	}


	public JTable getApps_table() {
		return apps_table;
	}
	public ArrayList<Payment> getApps_list() {
		return apps_list;
	}
	public void setdata(ArrayList<Payment> list){
		
		 this.data=list;
	}
	public void refreshPayment(ArrayList<Payment> list){
		setdata(list);
		initData();
		apps_table.updateUI();
		repaint();
	}
}
