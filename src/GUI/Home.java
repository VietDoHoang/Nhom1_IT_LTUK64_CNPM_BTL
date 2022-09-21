package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import struct.Device;
import struct.MainProcess;

/*
 * Author: Dinh Duc Lam
 */

public class Home extends JFrame implements ActionListener {
	private Button btLaptop, btPhone, btHistory, btCart;
	private JPanel pnChoose, pnCenter, cardDevice, laptop, phone, history;
	private CardLayout card;
	
	protected MainProcess mp = new MainProcess();
	
	public Home() {
		// TODO Auto-generated constructor stub
		window();
		laptop = new DeviceGUI(mp, btCart, "laptop", Device.LAPTOP_TYPE, Device.LAPTOP_COLUMN_TITLE.length, Device.LAPTOP_COLUMN_TITLE);
		phone = new DeviceGUI(mp, btCart, "smart phone", Device.PHONE_TYPE, Device.PHONE_COLUMN_TITLE.length, Device.PHONE_COLUMN_TITLE);
		history = new History();
		
		pnCenter = new JPanel();
		cardDevice = new JPanel();
		card = new CardLayout(15, 15);
		cardDevice.setLayout(card);

		cardDevice.add("laptop", laptop);
		cardDevice.add("phone", phone);
		cardDevice.add("history", history);
		
		pnCenter.setLayout(new BorderLayout());
		pnCenter.add(cardDevice, BorderLayout.CENTER);
		getContentPane().add(pnCenter);
		set();
	}

	private void window() {
		pnChoose = new JPanel();
		pnChoose.setPreferredSize(new Dimension(130, 10));
		pnChoose.setBackground(SystemColor.activeCaption);
		getContentPane().add(pnChoose, BorderLayout.WEST);
		pnChoose.setLayout(null);

		JLabel welcome = new JLabel("WELCOME!");
		welcome.setBounds(0, 2, 130, 64);
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnChoose.add(welcome);

		btLaptop = new Button(Button.CHOOSE_BUTTON, this, "Laptop");
		btLaptop.setBackground(SystemColor.activeCaptionBorder);
		btLaptop.setBounds(0, 90, 130, 47);
		pnChoose.add(btLaptop);
		
		btPhone = new Button(Button.CHOOSE_BUTTON, this, "Smartphone");
		btPhone.setBounds(0, 137, 130, 47);
		pnChoose.add(btPhone);
		
		btHistory = new Button(Button.CHOOSE_BUTTON, this, "History");
		btHistory.setBounds(0, 570, 130, 47);
		pnChoose.add(btHistory);
		
		JLabel lbTitle = new JLabel("STORE MANAGEMENT");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		

		btCart = new Button(this, new ImageIcon("src/icon/cart_empty.png"));
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new BorderLayout(20, 0));
		pnTitle.setBackground(SystemColor.activeCaption);
		pnTitle.add(lbTitle);
		pnTitle.add(btCart, BorderLayout.EAST);
		add(pnTitle, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == btCart) {
			new Cart(mp);
			btCart.setIcon(new ImageIcon("src/icon/cart_empty.png"));
		}
		else {
			btLaptop.setBackground(SystemColor.activeCaption);
			btPhone.setBackground(SystemColor.activeCaption);
			btHistory.setBackground(SystemColor.activeCaption);
			
			if (arg0.getSource() == btLaptop) {
				card.show(cardDevice, "laptop");
				btLaptop.setBackground(SystemColor.activeCaptionBorder);
			} else if (arg0.getSource() == btPhone) {
				card.show(cardDevice, "phone");
				btPhone.setBackground(SystemColor.activeCaptionBorder);
			}
			else if (arg0.getSource() == btHistory) {
				card.show(cardDevice, "history");
				btHistory.setBackground(SystemColor.activeCaptionBorder);
			}
		}
	}

	private void set() {
		setSize(1300, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("Device Management");
	}
}