package view.nhankhau;

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

import model.entity.NhanKhauInfo;

public class UpdateNhanKhauView {

	private JFrame frame;
	private JTextField hoTen;
	private JTextField id;
	private JButton submit;
	private ButtonGroup gioiTinh;
	private JTextField ngaySinh;
	private JTextField sdt;
	private JTextField soBHYT;
	private JTextField email;
	private JTextField quocTich;
	private JTextField thuongTruTamTru;
	private JRadioButton nam, nu, khac; 

	public UpdateNhanKhauView() {
//		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SỬA THÔNG TIN NHÂN KHẨU");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(134, 11, 338, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên:");
		lblNewLabel_1.setBounds(10, 56, 148, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		hoTen = new JTextField();
		hoTen.setBackground(UIManager.getColor("TextField.disabledBackground"));
		hoTen.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		hoTen.setBounds(155, 56, 127, 20);
		frame.getContentPane().add(hoTen);
		hoTen.setColumns(10);
		
		id = new JTextField();
		id.setBackground(UIManager.getColor("TextField.disabledBackground"));
		id.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		id.setColumns(10);
		id.setBounds(480, 56, 127, 20);
		frame.getContentPane().add(id);
		
		JLabel lblNewLabel_1_1 = new JLabel("S\u1ED1 h\u1ED9 chi\u1EBFu/CCCD:");
		lblNewLabel_1_1.setBounds(335, 56, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
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
		
		JLabel lblNewLabel_1_2 = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblNewLabel_1_2.setBounds(10, 87, 69, 20);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		nam = new JRadioButton("Nam");
		nam.setBounds(104, 84, 69, 23);
		frame.getContentPane().add(nam);
		
		nu = new JRadioButton("Nữ");
		nu.setBounds(174, 84, 61, 23);
		frame.getContentPane().add(nu);
		
		khac = new JRadioButton("Khác");
		khac.setBounds(232, 84, 61, 23);
		frame.getContentPane().add(khac);
		
		gioiTinh = new ButtonGroup();
		gioiTinh.add(nam);
		gioiTinh.add(nu);
		gioiTinh.add(khac);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ng\u00E0y sinh:");
		lblNewLabel_1_1_1.setBounds(335, 87, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		ngaySinh = new JTextField();
		ngaySinh.setColumns(10);
		ngaySinh.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ngaySinh.setBackground(SystemColor.menu);
		ngaySinh.setBounds(480, 87, 127, 20);
		frame.getContentPane().add(ngaySinh);
		
		JLabel lblNewLabel_1_3 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblNewLabel_1_3.setBounds(10, 118, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		sdt = new JTextField();
		sdt.setColumns(10);
		sdt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		sdt.setBackground(SystemColor.menu);
		sdt.setBounds(155, 118, 127, 20);
		frame.getContentPane().add(sdt);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("S\u1ED1 th\u1EBB BHYT:");
		lblNewLabel_1_1_2.setBounds(335, 118, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		soBHYT = new JTextField();
		soBHYT.setColumns(10);
		soBHYT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		soBHYT.setBackground(SystemColor.menu);
		soBHYT.setBounds(480, 118, 127, 20);
		frame.getContentPane().add(soBHYT);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email:");
		lblNewLabel_1_4.setBounds(10, 149, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		email.setBackground(SystemColor.menu);
		email.setBounds(155, 149, 127, 20);
		frame.getContentPane().add(email);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Qu\u1ED1c t\u1ECBch:");
		lblNewLabel_1_1_3.setBounds(335, 149, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		quocTich = new JTextField();
		quocTich.setColumns(10);
		quocTich.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		quocTich.setBackground(SystemColor.menu);
		quocTich.setBounds(480, 149, 127, 20);
		frame.getContentPane().add(quocTich);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Th\u01B0\u1EDDng tr\u00FA/T\u1EA1m tr\u00FA:");
		lblNewLabel_1_4_1.setBounds(10, 180, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_4_1);
		
		thuongTruTamTru = new JTextField();
		thuongTruTamTru.setColumns(10);
		thuongTruTamTru.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		thuongTruTamTru.setBackground(SystemColor.menu);
		thuongTruTamTru.setBounds(155, 180, 452, 20);
		frame.getContentPane().add(thuongTruTamTru);
		
		frame.getRootPane().setDefaultButton(submit);
		frame.setVisible(true);
	}
	//done
	public void setActionSubmitButton(ActionListener a) {
		submit.addActionListener(a);
	}
	
	public void setData(NhanKhauInfo nhanKhau) {
		hoTen.setText(nhanKhau.getHoTen());
		id.setText(nhanKhau.getId());
		if (nhanKhau.getGioiTinh().equals("Nam")) nam.setSelected(true);
		else if (nhanKhau.getGioiTinh().equals("Nữ")) nu.setSelected(true);
		else khac.setSelected(true);
		ngaySinh.setText(nhanKhau.getNgaySinh().toString());
		sdt.setText(nhanKhau.getSoDienThoai());
		soBHYT.setText(nhanKhau.getSoTheBHYT());
		email.setText(nhanKhau.getEmail());
		quocTich.setText(nhanKhau.getQuocTich());
		thuongTruTamTru.setText(nhanKhau.getThuongTruTamTru());
		hoTen.requestFocus();
	}
	
	//done
	public String getHoTen() throws Exception{
		String name = hoTen.getText();
		if (name.equals("")) {
			hoTen.requestFocus();
			throw new Exception("Chưa điền họ tên");
		}
		return name;
		
	}
	//done
	public String getId() throws Exception {
		String cccd = id.getText();
		if (cccd.equals("")) {
			id.requestFocus();
			throw new Exception("Chưa điền số hộ chiếu/CCCD");
		}
		return cccd;
	}
	//done
	public String getNgaySinh() throws Exception{
		String dateString = ngaySinh.getText();
		if (dateString.equals("")) {
			ngaySinh.requestFocus();
			throw new Exception("Chưa điền Ngày sinh");
		}
		return dateString;
	}
	
	//done
	public String getGioiTinh() throws Exception {
		try{
			if (nam.isSelected()) return "Nam";
			if (nu.isSelected()) return "Nữ";
			if (khac.isSelected()) return "Khác";
			throw new Exception();
		} catch (Exception e){
			throw new Exception("Chưa chọn Giới tính");
		}
	}
	
	//done
	public String getSoDienThoai(){
		String soDT = sdt.getText();
		return soDT;
	}
	
	//done
	public String getSoTheBHYT(){
		String bhyt = soBHYT.getText();
		return bhyt;
	}
	
	//done
	public String getEmail(){
		String e = email.getText();
		return e;
	}
	
	public String getQuocTich() throws Exception {
		String qt = quocTich.getText();
		if (qt.equals("")) {
			id.requestFocus();
			throw new Exception("Chưa điền quốc tịch");
		}
		return qt;
	}
	
	//done
	public String getThuongTruTamTru() throws Exception {
		String address = thuongTruTamTru.getText();
		if (address.equals("")) {
			thuongTruTamTru.requestFocus();
			throw new Exception("Chưa điền địa chỉ thường trú/tạm trú");
		}
		return address;
	}
	//done
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}
	
	public void dispose() {
		frame.dispose();
	}
}
