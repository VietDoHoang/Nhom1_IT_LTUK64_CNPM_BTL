package view.khaibao;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class AddKhaiBaoView {

	private JFrame frame;
	private JTextField hoTen;
	private JTextField id;
	private JButton submit;
	private JTextField ngayKhaiBao;
	private JRadioButton coTiepXucVoiNguoiBenh, khongTiepXucVoiNguoiBenh, coDiVeTuVungDich, khongDiVeTuVungDich, coTiepXucVoiNguoiTuVungDich, khongTiepXucVoiNguoiTuVungDich;

	public AddKhaiBaoView() {
//		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÊM THÔNG TIN SỨC KHỎE BẤT THƯỜNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 11, 401, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ & Tên:");
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
		
		JLabel lblNewLabel_2_1 = new JLabel("Thông tin yếu tố nguy cơ:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 123, 215, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		submit = new JButton("Submit");
		submit.setContentAreaFilled(false);
		submit.setBounds(256, 271, 109, 34);
		frame.getContentPane().add(submit);
		
		JButton close = new JButton("Close");
		close.setContentAreaFilled(false);
		close.setBounds(515, 284, 92, 29);
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.getContentPane().add(close);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Ngày khai báo (yyyy/MM/dd):");
		lblNewLabel_1_4_1.setBounds(10, 237, 172, 20);
		frame.getContentPane().add(lblNewLabel_1_4_1);
		
		ngayKhaiBao = new JTextField();
		ngayKhaiBao.setColumns(10);
		ngayKhaiBao.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ngayKhaiBao.setBackground(SystemColor.menu);
		ngayKhaiBao.setBounds(192, 238, 415, 20);
		frame.getContentPane().add(ngayKhaiBao);
		
		coTiepXucVoiNguoiBenh = new JRadioButton("Có");
		coTiepXucVoiNguoiBenh.setBounds(429, 154, 71, 23);
		frame.getContentPane().add(coTiepXucVoiNguoiBenh);
		
		khongTiepXucVoiNguoiBenh = new JRadioButton("Không");
		khongTiepXucVoiNguoiBenh.setBounds(507, 154, 100, 23);
		frame.getContentPane().add(khongTiepXucVoiNguoiBenh);
			
		khongDiVeTuVungDich = new JRadioButton("Không");
		khongDiVeTuVungDich.setBounds(507, 181, 100, 23);
		frame.getContentPane().add(khongDiVeTuVungDich);
		
		coDiVeTuVungDich = new JRadioButton("Có");
		coDiVeTuVungDich.setBounds(429, 181, 71, 23);
		frame.getContentPane().add(coDiVeTuVungDich);
		
		khongTiepXucVoiNguoiTuVungDich = new JRadioButton("Không");
		khongTiepXucVoiNguoiTuVungDich.setBounds(507, 207, 100, 23);
		frame.getContentPane().add(khongTiepXucVoiNguoiTuVungDich);
		
		coTiepXucVoiNguoiTuVungDich = new JRadioButton("Có");
		coTiepXucVoiNguoiTuVungDich.setBounds(429, 207, 71, 23);
		frame.getContentPane().add(coTiepXucVoiNguoiTuVungDich);
		
		ButtonGroup ho = new ButtonGroup();
		ho.add(coTiepXucVoiNguoiBenh);
		ho.add(khongTiepXucVoiNguoiBenh);
		khongTiepXucVoiNguoiBenh.setSelected(true);
		ButtonGroup sot = new ButtonGroup();
		sot.add(coDiVeTuVungDich);
		sot.add(khongDiVeTuVungDich);
		khongDiVeTuVungDich.setSelected(true);
		ButtonGroup khoTho = new ButtonGroup();
		khoTho.add(coTiepXucVoiNguoiTuVungDich);
		khoTho.add(khongTiepXucVoiNguoiTuVungDich);
		khongTiepXucVoiNguoiTuVungDich.setSelected(true);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Có tiếp xúc với trường hợp bệnh hoặc nghi ngờ mắc bệnh COVID?");
		lblNewLabel_1_4_1_1.setBounds(10, 154, 401, 20);
		frame.getContentPane().add(lblNewLabel_1_4_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("Có đi về từ vùng dịch bệnh COVID-19?");
		lblNewLabel_1_4_1_1_1.setBounds(10, 183, 401, 20);
		frame.getContentPane().add(lblNewLabel_1_4_1_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1 = new JLabel("Có tiếp xúc với trường hợp đi về từ vùng dịch?");
		lblNewLabel_1_4_1_1_1_1.setBounds(10, 210, 401, 20);
		frame.getContentPane().add(lblNewLabel_1_4_1_1_1_1);
		
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
		khongTiepXucVoiNguoiBenh.setSelected(true);
		khongDiVeTuVungDich.setSelected(true);
		khongTiepXucVoiNguoiTuVungDich.setSelected(true);
		ngayKhaiBao.setText("");
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
	
	public String getTiepXucVoiNguoiBenh() {
		if (coTiepXucVoiNguoiBenh.isSelected()) return "Có";
		else return "Không";
	}
	
	public String getDiVeTuVungDich() {
		if (coDiVeTuVungDich.isSelected()) return "Có";
		else return "Không";
	}
	
	public String getTiepXucVoiNguoiTuVungDich() {
		if (coTiepXucVoiNguoiTuVungDich.isSelected()) return "Có";
		else return "Không";
	}
	
	public String getNgayKhaiBao() throws Exception{
		String dateString = ngayKhaiBao.getText();

		if (dateString.equals("")) {
			ngayKhaiBao.requestFocus();
			throw new Exception("Chưa điền Ngày khai báo");
		}
	
		return dateString;
	}

	//done
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}
}
