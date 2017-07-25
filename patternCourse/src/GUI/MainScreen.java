package GUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.PaymentController;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {
	public MainScreen() {
		setSize(854,500);	
		PaymentController cont = new PaymentController (this);
		JButton button = new JButton("Payment");
		button.addActionListener(cont);
		button.setActionCommand("_payment_show");
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
							.addGap(22))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(34))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
					.addGap(17))
		);
		
		AirConditionersPanel airCond = new AirConditionersPanel(this);
		tabbedPane.addTab("AirConditioners", null,(new AirConditionersPanel(this)).getFrame(), null);
		getContentPane().setLayout(groupLayout);
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Refrigerators", null, panel1, null);
		
		getContentPane().setLayout(groupLayout);
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("VacuumCleaners", null, panel2, null);
		
	}
}
