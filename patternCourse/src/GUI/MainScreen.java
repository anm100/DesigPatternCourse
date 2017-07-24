package GUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class MainScreen extends JFrame {
	public MainScreen() {
		
		JButton button = new JButton("New button");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
						.addComponent(button))
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(button)
					.addGap(47)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
					.addGap(17))
		);
		
		AirConditionersGUI airCond = new AirConditionersGUI();
		tabbedPane.addTab("AirConditioners", null, airCond.getFrame(), null);
		getContentPane().setLayout(groupLayout);
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Refrigerators", null, panel1, null);
		getContentPane().setLayout(groupLayout);
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("VacuumCleaners", null, panel2, null);
		getContentPane().setLayout(groupLayout);
	}
}
