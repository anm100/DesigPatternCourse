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
import javax.swing.JLabel;

public class MainScreen extends JFrame {
	public MainScreen() {
		setSize(1019,624);	
		PaymentController cont = new PaymentController (this);
		JButton button = new JButton("Payment");
		button.addActionListener(cont);
		button.setActionCommand("_payment_show");
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
		
		JLabel lblNewLabel = new JLabel("Logo :Electronic Systems");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
		);
		
		AirConditionersPanel airCond = new AirConditionersPanel(this);
		tabbedPane.addTab("AirConditioners", null,(new AirConditionersPanel(this)).getFrame(), null);
		getContentPane().setLayout(groupLayout);
		tabbedPane.addTab("Refrigerators", null, new RefrigeratorsPanel(this).getFrame(), null);
		
		getContentPane().setLayout(groupLayout);
		tabbedPane.addTab("VacuumCleaners", null, new VacumCleanerPanel(this).getFrame(), null);
		
	}
}
