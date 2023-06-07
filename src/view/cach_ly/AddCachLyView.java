package view.cach_ly;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class AddCachLyView {

	private JFrame frame;
	private JTextField hoTen;
	private JTextField id;
	private JTextField ngayBatDau;
	private JTextField mucDoCachLy;
	private JTextField diaChiCachLy;
	private JButton submit;

	public AddCachLyView() {
//		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÊM THÔNG TIN CÁCH LY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(134, 11, 338, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên:");
		lblNewLabel_1.setBounds(10, 83, 148, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		hoTen = new JTextField();
		hoTen.setBackground(UIManager.getColor("TextField.disabledBackground"));
		hoTen.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		hoTen.setBounds(155, 83, 127, 20);
		frame.getContentPane().add(hoTen);
		hoTen.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phần hành chính:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 52, 148, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBackground(UIManager.getColor("TextField.disabledBackground"));
		id.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		id.setColumns(10);
		id.setBounds(480, 83, 127, 20);
		frame.getContentPane().add(id);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số hộ chiếu/CCCD:");
		lblNewLabel_1_1.setBounds(335, 83, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Thông tin cách ly:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 123, 148, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày bắt đầu cách ly:");
		lblNewLabel_1_4.setBounds(10, 154, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mức độ cách ly:");
		lblNewLabel_1_1_1.setBounds(335, 154, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		ngayBatDau = new JTextField();
		ngayBatDau.setBackground(UIManager.getColor("TextField.disabledBackground"));
		ngayBatDau.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ngayBatDau.setColumns(10);
		ngayBatDau.setBounds(155, 154, 127, 20);
		frame.getContentPane().add(ngayBatDau);
		
		mucDoCachLy = new JTextField();
		mucDoCachLy.setBackground(UIManager.getColor("TextField.disabledBackground"));
		mucDoCachLy.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		mucDoCachLy.setColumns(10);
		mucDoCachLy.setBounds(480, 154, 127, 20);
		frame.getContentPane().add(mucDoCachLy);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Địa chỉ cách ly:");
		lblNewLabel_1_2_1.setBounds(10, 185, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		diaChiCachLy = new JTextField();
		diaChiCachLy.setBackground(UIManager.getColor("TextField.disabledBackground"));
		diaChiCachLy.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		diaChiCachLy.setColumns(10);
		diaChiCachLy.setBounds(155, 185, 452, 20);
		frame.getContentPane().add(diaChiCachLy);
		
		submit = new JButton("Submit");
		submit.setContentAreaFilled(false);
		submit.setBounds(256, 225, 109, 34);
		frame.getContentPane().add(submit);
		
		JButton close = new JButton("Close");
		close.setContentAreaFilled(false);
		close.setBounds(515, 246, 92, 29);
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.getContentPane().add(close);
		frame.getRootPane().setDefaultButton(submit);
		frame.setVisible(true);
	}
	//done
	public void setActionSubmitButton(ActionListener a) {
		submit.addActionListener(a);
	}
	
	public void clear() {
		hoTen.setText("");
		id.setText("");
		ngayBatDau.setText("");
		mucDoCachLy.setText("");
		diaChiCachLy.setText("");
		hoTen.requestFocus();
	}
	
	//done
	public String getHoTen() throws Exception{
		String name = hoTen.getText();
		if (name.equals("")) {
			hoTen.requestFocus();
			throw new Exception("Chưa điền Họ & tên");
		}
		return name;
		
	}
	//done
	public String getId() throws Exception {
		String cccd = id.getText();
		if (cccd.equals("")) {
			id.requestFocus();
			throw new Exception("Chưa điền Số hộ chiếu/CCCD");
		}
		return cccd;
	}
	//done
	public String getNgayBatDau() throws Exception{
		String dateString = ngayBatDau.getText();

		if (dateString.equals("")) {
			ngayBatDau.requestFocus();
			throw new Exception("Chưa điền Ngày bắt đầu");
		}

		return dateString;
	}
	
	//done
	public String getMucDoCachLy() throws Exception {
		String f = mucDoCachLy.getText();
		if (f.equals("")) {
			mucDoCachLy.requestFocus();
			throw new Exception("Chưa điền Mức độ cách ly");
		}
		return f;
	}
	//done
	public String getDiaChiCachLy() throws Exception {
		String address = diaChiCachLy.getText();
		if (address.equals("")) {
			diaChiCachLy.requestFocus();
			throw new Exception("Chưa điền Địa chỉ cách ly");
		}
		return address;
	}
	//done
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}
}
