package GUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainScreen extends JFrame {
	public MainScreen() {
		
		JButton button = new JButton("New button");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
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
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("111111111111", null, panel, null);
		getContentPane().setLayout(groupLayout);
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("2111111111", null, panel1, null);
		getContentPane().setLayout(groupLayout);
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("311111111", null, panel2, null);
		getContentPane().setLayout(groupLayout);
	}
}
