package GUI;

import java.util.ArrayList;

import javax.swing.JTable;

import Models.Insurance;

public interface InterfaceComposite {
	public JTable getApps_table();
	public ArrayList<Insurance> getApps_list();
}
