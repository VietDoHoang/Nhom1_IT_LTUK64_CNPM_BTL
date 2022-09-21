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

import struct.Device;

/*
 * Show all device are being in the cart, 
 * then fill info of customer owning this cart to pay
 * Author: Dinh Duc Lam
 */
public class Cart extends JFrame{
	
	List<Device> list;
	private JTable table;
	
	
	public Cart(struct.MainProcess mp){
		list = mp.getCustomer().getCart().getList();
		setLayout(new BorderLayout(0, 10));
		
		JPanel pnWest = new JPanel();
		add(pnWest, BorderLayout.WEST);
		
		JPanel pnEast = new JPanel();
		add(pnEast, BorderLayout.EAST);
		
		JLabel title = new JLabel("CART");
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
		
		TextField fullName = new TextField();
		info.add(fullName);
		
		info.add(new JLabel("Address"));
		
		TextField address = new TextField();
		info.add(address);
		
		info.add(new JLabel("Phone Number"));
		
		TextField phoneNumber = new TextField();
		info.add(phoneNumber);
		
		JPanel pnSouth = new JPanel();
		pnSouth.setPreferredSize(new Dimension(0, 50));
		add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
		Button pay = new Button(Button.NOMAL_BUTTON, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mp.pay(fullName.getText(), address.getText(), phoneNumber.getText());
				dispose();
			}
		}, "Pay");
		pay.setPreferredSize(new Dimension(100, 32));
		pnSouth.add(pay);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String[] t = {"Type", "Brand", "Name", "Model", "Year", "Color", "Amount", "Sell Price"};
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
	
//	public void 
	
	
	private void set() {
		setSize(600, 500);
		setLocationRelativeTo(null);
		setTitle("Cart");
		setVisible(true);
	}
	
	
}
