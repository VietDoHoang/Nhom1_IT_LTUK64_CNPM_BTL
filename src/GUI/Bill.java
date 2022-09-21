package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import struct.Customer;
import struct.Device;

/*
 * Author: Dinh Duc Lam
 * 
 */
public class Bill extends JFrame{
	
	List<Device> list;
	private JTable table;
	
	public Bill(Customer customer){
		list = customer.getCart().getList();
		setLayout(new BorderLayout(0, 10));
		
		JPanel pnWest = new JPanel();
		add(pnWest, BorderLayout.WEST);
		
		JPanel pnEast = new JPanel();
		add(pnEast, BorderLayout.EAST);
		
		JLabel title = new JLabel("BILL");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		title.setPreferredSize(new Dimension(0, 40));
		add(title, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(20, 20));
		
		JPanel info = new JPanel();
		info.setPreferredSize(new Dimension(0, 100));
		panel.add(info, BorderLayout.NORTH);
		info.setLayout(new GridLayout(0, 2, 0, 0));
		
		info.add(new JLabel("Full Name"));
		info.add(new JLabel(customer.getFullName()));
		
		info.add(new JLabel("Address"));
		info.add(new JLabel(customer.getAddress()));
		
		info.add(new JLabel("Phone Number"));
		info.add(new JLabel(customer.getPhoneNumber()));
		
		JPanel pnSouth = new JPanel();
		pnSouth.setPreferredSize(new Dimension(0, 70));
		pnSouth.setLayout(new BorderLayout(10, 10));
		add(pnSouth, BorderLayout.SOUTH);
		
		JLabel status = new JLabel("    Total Cost: " + String.valueOf(customer.getCart().getTotalCost()) + " USD");
		pnSouth.add(status, BorderLayout.NORTH);
		
		JPanel pnClose = new JPanel();
		pnClose.setLayout(new FlowLayout(FlowLayout.CENTER));
		Button close = new Button(Button.NOMAL_BUTTON, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		}, "Close");
		close.setPreferredSize(new Dimension(100, 32));
		pnClose.add(close);
		pnSouth.add(pnClose);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String[] t = {"Type", "Brand", "Name", "Model", "Year", "Color", "Amount", "Price"};
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(t);
		
		for (Device dv : list) {
			String[] s = dv.getStringArray();
			String type;
			if (dv.getType() == Device.LAPTOP_TYPE) type = "LAPTOP";
			else type = "PHONE";
			String ss[] = {type, s[0], s[1], s[2] , s[3], s[4], s[5], s[6]};
			model.addRow(ss);			
		}
		
		set();
	}
	
	private void set() {
		setSize(600, 500);
		setLocationRelativeTo(null);
		setTitle("Bill");
		setVisible(true);
	}
}
