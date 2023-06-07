package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainView {

	private JFrame frame;
	private JButton btnQLNhanKhau, btnQLKhaiBaoYTe, btnQLSucKhoe, btnQLCachLy, btnQLTestCovid, btnQLTiemVaccine, btnThongKe;
	private JLabel username;
	
	public MainView() {
//		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 892, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 876, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ PHÒNG TRÁNH COVID-19");
		lblNewLabel_1.setBounds(122, 0, 653, 50);
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 438, 876, 16);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel userInfoLabel = new JLabel("user: ");
		userInfoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userInfoLabel.setBounds(10, 0, 39, 14);
		panel_2.add(userInfoLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Phần mềm quản lý thông tin tổ dân cư | Tổ dân phố số 7 | Phường La Khê");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(246, -1, 435, 16);
		panel_2.add(lblNewLabel_2);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();

		JLabel dateLable = new JLabel(dateFormat.format(date));
		dateLable.setHorizontalAlignment(SwingConstants.RIGHT);
		dateLable.setBounds(772, 0, 94, 15);
		panel_2.add(dateLable);
		
		username = new JLabel("");
		username.setBounds(48, 0, 76, 14);
		panel_2.add(username);
		
		btnQLKhaiBaoYTe = new JButton("Quản lý khai báo dịch tễ");
		btnQLKhaiBaoYTe.setContentAreaFilled(false);
		btnQLKhaiBaoYTe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQLKhaiBaoYTe.setBounds(473, 72, 334, 70);
		frame.getContentPane().add(btnQLKhaiBaoYTe);
		
		btnQLSucKhoe = new JButton("Quản lý trạng thái sức khỏe bất thường");
		btnQLSucKhoe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQLSucKhoe.setContentAreaFilled(false);
		btnQLSucKhoe.setBounds(74, 161, 334, 70);
		frame.getContentPane().add(btnQLSucKhoe);
		
		btnQLCachLy = new JButton("Quản lý thông tin cách ly");
		btnQLCachLy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQLCachLy.setContentAreaFilled(false);
		btnQLCachLy.setBounds(473, 249, 334, 70);
		frame.getContentPane().add(btnQLCachLy);
		
		btnQLTestCovid = new JButton("Quản lý thông tin test covid");
		btnQLTestCovid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQLTestCovid.setContentAreaFilled(false);
		btnQLTestCovid.setBounds(473, 161, 334, 70);
		frame.getContentPane().add(btnQLTestCovid);
		
		btnQLTiemVaccine = new JButton("Quản lý thông tin tiêm vaccine");
		btnQLTiemVaccine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQLTiemVaccine.setContentAreaFilled(false);
		btnQLTiemVaccine.setBounds(74, 249, 334, 70);
		frame.getContentPane().add(btnQLTiemVaccine);
		
		btnThongKe = new JButton("THỐNG KÊ");
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThongKe.setContentAreaFilled(false);
		btnThongKe.setBounds(74, 338, 733, 70);
		frame.getContentPane().add(btnThongKe);
		
		btnQLNhanKhau = new JButton("Quản lý nhân khẩu");
		btnQLNhanKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQLNhanKhau.setContentAreaFilled(false);
		btnQLNhanKhau.setBounds(74, 72, 334, 70);
		frame.getContentPane().add(btnQLNhanKhau);
		frame.setVisible(true);
	}
	
	public void setUsername(String username) {
		this.username.setText(username);
	}
	
	public void setActionNhanKhau(ActionListener action) {
		btnQLNhanKhau.addActionListener(action);
	}
	public void setActionKhaiBaoYTe(ActionListener action) {
		btnQLKhaiBaoYTe.addActionListener(action);
	}
	public void setActionSucKhoe(ActionListener action) {
		btnQLSucKhoe.addActionListener(action);
	}
	public void setActionCachLy(ActionListener action) {
		btnQLCachLy.addActionListener(action);
	}
	public void setActionTestCovid(ActionListener action) {
		btnQLTestCovid.addActionListener(action);
	}	
	public void setActionTiemVaccine(ActionListener action) {
		btnQLTiemVaccine.addActionListener(action);
	}
	public void setActionThongKe(ActionListener action) {
		btnThongKe.addActionListener(action);
	}
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}
	public void hide() {
		frame.setVisible(false);
	}
	public void show() {
		frame.setVisible(true);
	}
}
