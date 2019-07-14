package GUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainScreen extends JFrame {
	public MainScreen() {
		setSize(1019,624);	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
		
		JLabel lblNewLabel = new JLabel("Logo  Insurance Systems");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(613, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
		);
		
		ClientPanel airCond = new ClientPanel(this);
		tabbedPane.addTab("Clients", null,(new ClientPanel(this)).getFrame(), null);
		getContentPane().setLayout(groupLayout);
		tabbedPane.addTab("Car Insurance", null, new CarInsurancePanel(this).getFrame(), null);
		getContentPane().setLayout(groupLayout);
		tabbedPane.addTab("another Insurance", null, new anotherInsurancePanel(this).getFrame(), null);
		getContentPane().setLayout(groupLayout);
		tabbedPane.addTab("Clients Claim", null, new ClaimsPanel2(this).getFrame(), null);
		
	}
}
