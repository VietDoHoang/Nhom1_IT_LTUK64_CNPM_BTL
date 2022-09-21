package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import function.CreateExcel;
import struct.Device;
import struct.DeviceList;
import struct.Laptop;
import struct.MainProcess;
import struct.Phone;

/*
 * Author: Dinh Duc Lam
 */
public class DeviceGUI extends JPanel implements ActionListener, KeyListener {
	private JButton add, update, clear, delete, export, addToCart;
	private JLabel status;
	private JTable table;
	private DefaultTableModel tableModel;
	private TextField[] stateTextFields;
	private TextField brandSearch, nameSearch;
	private String[] menu = {"All", "Stocking"};
	private JComboBox<String> comboBox = new JComboBox<String>(menu);
	
	private String deviceName;
	private int type;
	private int numberOfState;
	private String[] colTitle;
	private MainProcess mp;
	private Button btCart;
	
	private DeviceList deviceList = new DeviceList();
	private List<Device> searchedList = new ArrayList<>();
	
	DeviceGUI(MainProcess m, Button btCart, String deviceName, int type, int numberOfState, String[] colTitle) {
		this.mp = m;
		this.btCart = btCart;
		this.deviceName = deviceName;
		this.type = type;
		this.numberOfState = numberOfState;
		this.colTitle = colTitle;
		stateTextFields = new TextField[numberOfState];
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		createPnLeft();
		/*************/
		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(15, 0));
		add(separator);
		/*************/
		createPnRight();
//		loadDataTest();
	}

	/*
	 * Method loadDataTest use to load demo data declared at class struct.Device  
	 */
	
	/*
	public void loadDataTest() {
		String testData[][];
		if (type == Device.LAPTOP_TYPE) testData = Device.LAPTOP_TEST_DATA;
		else testData = Device.PHONE_TEST_DATA;
		
		for (String[] o : testData) {
			if (type == Device.LAPTOP_TYPE) deviceList.add(new Laptop(o));
			else deviceList.add(new Phone(o));
		}
		load(deviceList.searchByBrandAndName(brandSearch.getText(), nameSearch.getText(), comboBox.getSelectedIndex()));
	}
	*/
	
	private void createPnLeft() {
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BorderLayout(0, 0));
		
		/* Set title for the Panel
		 * title is deviceName (a parameter of DeviceGUI contructor) 
		 * Title of object Laptop is LAPTOP
		 * Title of object Phone is PHONE
		 * 
		 */
		JPanel pnTitle = new JPanel();
		pnTitle.setPreferredSize(new Dimension(0, 30));
		pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnLeft.add(pnTitle, BorderLayout.NORTH);

		JLabel title = new JLabel(deviceName.toUpperCase());
		title.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnTitle.add(title);

		/* Create JPanel to fill in information */
		
		JPanel 	pnFillInfor = new JPanel();
		pnFillInfor.setLayout(new GridLayout(0, 2, 10, 10));
		
		pnLeft.add(pnFillInfor, BorderLayout.CENTER);
		
		for (int i=0; i<numberOfState; i++) {
			pnFillInfor.add(new JLabel(colTitle[i]));
			stateTextFields[i] = new TextField();
			pnFillInfor.add(stateTextFields[i]);
		}

		/* Create Button */
		JPanel 	pnSouth = new JPanel();
		pnSouth.setLayout(new BorderLayout(0, 10));
		pnSouth.setPreferredSize(new Dimension(0, 230));

		pnLeft.add(pnSouth, BorderLayout.SOUTH);

		status = new JLabel("");
		status.setPreferredSize(new Dimension(0, 40));
		pnSouth.add(status, BorderLayout.NORTH);

		/* Create 6 buttons: Add, Update, Clear, Delete, Export, Payment
		 * pnButtonList contains 4 buttons: Add, Update, Clear, Delete
		 * 
		 */
		JPanel 	pnButtonList = new JPanel();
		pnButtonList.setLayout(new GridLayout(2, 2, 10, 10));
		
		JPanel 	pnExportAndPay = new JPanel();
		pnExportAndPay.setLayout(new GridLayout(2, 1, 10, 10));
		pnExportAndPay.setPreferredSize(new Dimension(0, 85));
		
		add = new Button(Button.NOMAL_BUTTON, this, "Add");
		update = new Button(Button.NOMAL_BUTTON, this, "Update");
		clear = new Button(Button.NOMAL_BUTTON, this, "Clear");
		delete = new Button(Button.NOMAL_BUTTON, this, "Delete");
		addToCart = new Button(Button.NOMAL_BUTTON, this, "Add To Cart", new ImageIcon("src/icon/cart.png"));
		export = new Button(Button.NOMAL_BUTTON, this, "Export (Excel)", new ImageIcon("src/icon/excel.png"));
		
		pnButtonList.add(add);
		pnButtonList.add(update);
		pnButtonList.add(clear);
		pnButtonList.add(delete);
		
		pnExportAndPay.add(addToCart);
		pnExportAndPay.add(export);
		
		pnSouth.add(pnButtonList);
		pnSouth.add(pnExportAndPay, BorderLayout.SOUTH);
		/*--------------*/

		add(pnLeft);
	}

	private void createPnRight() {
		JPanel 	pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout(0, 20));
		
		JPanel 	pnFind = new JPanel();
		pnFind.setLayout(new BoxLayout(pnFind, BoxLayout.X_AXIS));
		pnFind.setPreferredSize(new Dimension(0, 20));
		
		pnFind.add(new JLabel("Search by Brand: "));
		brandSearch = new TextField();
		brandSearch.addKeyListener(this);
		pnFind.add(brandSearch);
		
		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(50, 0));
		pnFind.add(separator);
		
		pnFind.add(new JLabel("Search by Name: "));
		nameSearch = new TextField();
		nameSearch.addKeyListener(this);
		pnFind.add(nameSearch);
		pnRight.add(pnFind, BorderLayout.NORTH);
		
		JPanel separator1 = new JPanel();
		separator1.setPreferredSize(new Dimension(50, 0));
		pnFind.add(separator1);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				load(deviceList.searchByBrandAndName(brandSearch.getText(), nameSearch.getText(), comboBox.getSelectedIndex()));
			}
		});
		pnFind.add(comboBox);
		
		table = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(colTitle);
		table.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		pnRight.add(scrollPane);

		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int rowIndx = table.getSelectedRow();
				for (int i=0; i<numberOfState; i++) stateTextFields[i].setText(table.getValueAt(rowIndx, i).toString());
			}
		});
		add(pnRight);
	}
	
	
	// clear all text in the stateTextFields (make, manufacturing year, price, color,...)
	private void clear() {
		for (int i=0; i<numberOfState; i++)
			stateTextFields[i].setText("");
	}

	// check
	private boolean check() {
		String noti = "Please fill all the form!";
		for (int i=0; i<numberOfState; i++)
			if (stateTextFields[i].getText().equals("")) {
				stateTextFields[i].requestFocus();
				status.setText(noti);
				return false;
			}
		return true;
	}

	private Device getInfo() {
		String t[] = getInfoReturnString();
		if (type == Device.LAPTOP_TYPE) return new struct.Laptop(t);
		else if (type == Device.PHONE_TYPE) return new struct.Phone(t);
		else return null;
	}
	
	private String[] getInfoReturnString() {
		String t[] = new String[numberOfState];
		for (int i=0; i<numberOfState; i++)
			t[i] = stateTextFields[i].getText();
		return t;
	}
	
	private void load(List<Device> searchedList) {
		this.searchedList = searchedList;
		tableModel.setNumRows(0);

		for (Device dv : searchedList) {
			tableModel.addRow(dv.getStringArray());
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == add) {
			if (check()) {
				deviceList.add(getInfo());
				load(deviceList.searchByBrandAndName(brandSearch.getText(), nameSearch.getText(), comboBox.getSelectedIndex()));
				clear();
			}
			
		}
		else if (arg0.getSource() == clear) {
			clear();
			status.setText("");
		}
		else if (arg0.getSource() == update) {
			int rowIndx = table.getSelectedRow();
			if (rowIndx < 0) status.setText("Please select a Device first!");
			else if (check()) {
				deviceList.modify(searchedList.get(rowIndx), getInfo());
				load(deviceList.searchByBrandAndName(brandSearch.getText(), nameSearch.getText(), comboBox.getSelectedIndex()));
				clear();
			}
		}
		else if (arg0.getSource() == delete) {
			int rowIndx = table.getSelectedRow();
			while (rowIndx >= 0) {
				deviceList.rm(searchedList.get(rowIndx));
				searchedList.remove(rowIndx);
				tableModel.removeRow(rowIndx);
				rowIndx = table.getSelectedRow();
				clear();
			}
		}
		else if (arg0.getSource() == export) {
			CreateExcel excel;
			try {
				excel = new CreateExcel(searchedList, colTitle, deviceName);
				status.setText("Created file: " + excel.getPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (arg0.getSource() == addToCart) {
			int rowIndx = table.getSelectedRow();
			if (rowIndx < 0) status.setText("Please select a Device first!");
			else {
				mp.addToCart(searchedList.get(rowIndx));
				load(deviceList.searchByBrandAndName(brandSearch.getText(), nameSearch.getText(), comboBox.getSelectedIndex()));
				clear();
				btCart.setIcon(new ImageIcon("src/icon/cart_noti.png"));
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		load(deviceList.searchByBrandAndName(brandSearch.getText(), nameSearch.getText(), comboBox.getSelectedIndex()));
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
