package view.tiemvaccine;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import model.entity.TiemVaccineInfo;

public class UpdateTiemVaccineView {

	private JFrame frame;
	private JTextField hoTen;
	private JTextField id;
	private JTextField donViTiemChung;
	private JButton submit;
	private JTextField loVaccine;
	private JTextField ngayTiem;
	private JComboBox<String> loaiVaccine;
	private JSpinner lanTiem;

	public UpdateTiemVaccineView() {
//		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÊM THÔNG TIN TIÊM VACCINE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(134, 11, 338, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1ECD & T\u00EAn:");
		lblNewLabel_1.setBounds(10, 83, 148, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		hoTen = new JTextField();
		hoTen.setBackground(UIManager.getColor("TextField.disabledBackground"));
		hoTen.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		hoTen.setBounds(155, 83, 127, 20);
		frame.getContentPane().add(hoTen);
		hoTen.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ph\u1EA7n h\u00E0nh ch\u00EDnh:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 52, 148, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBackground(UIManager.getColor("TextField.disabledBackground"));
		id.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		id.setColumns(10);
		id.setBounds(480, 83, 127, 20);
		frame.getContentPane().add(id);
		
		JLabel lblNewLabel_1_1 = new JLabel("S\u1ED1 h\u1ED9 chi\u1EBFu/CCCD:");
		lblNewLabel_1_1.setBounds(335, 83, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Thông tin test covid:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 123, 148, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Lần tiêm:");
		lblNewLabel_1_4.setBounds(10, 154, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Loại vaccine:");
		lblNewLabel_1_1_1.setBounds(335, 154, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Đơn vị tiêm chủng:");
		lblNewLabel_1_2_1.setBounds(10, 215, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		donViTiemChung = new JTextField();
		donViTiemChung.setBackground(UIManager.getColor("TextField.disabledBackground"));
		donViTiemChung.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		donViTiemChung.setColumns(10);
		donViTiemChung.setBounds(155, 215, 452, 20);
		frame.getContentPane().add(donViTiemChung);
		
		submit = new JButton("Submit");
		submit.setContentAreaFilled(false);
		submit.setBounds(257, 261, 109, 34);
		frame.getContentPane().add(submit);
		
		JButton close = new JButton("Close");
		close.setContentAreaFilled(false);
		close.setBounds(515, 280, 92, 29);
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.getContentPane().add(close);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Lô vaccine:");
		lblNewLabel_1_4_1.setBounds(10, 185, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_4_1);
		
		loVaccine = new JTextField();
		loVaccine.setColumns(10);
		loVaccine.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		loVaccine.setBackground(SystemColor.menu);
		loVaccine.setBounds(155, 185, 127, 20);
		frame.getContentPane().add(loVaccine);
		
		ngayTiem = new JTextField();
		ngayTiem.setColumns(10);
		ngayTiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ngayTiem.setBackground(SystemColor.menu);
		ngayTiem.setBounds(480, 185, 127, 20);
		frame.getContentPane().add(ngayTiem);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ngày tiêm:");
		lblNewLabel_1_1_1_1.setBounds(335, 185, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		lanTiem = new JSpinner();
		lanTiem.setBounds(155, 154, 31, 20);
		frame.getContentPane().add(lanTiem);
		
		loaiVaccine = new JComboBox<String>();
		loaiVaccine.setBounds(434, 154, 176, 20);
		frame.getContentPane().add(loaiVaccine);
		loaiVaccine.addItem("AstraZeneca");
		loaiVaccine.addItem("Pfizer/BioNTech");
		loaiVaccine.addItem("Sputnik V");
		loaiVaccine.addItem("Vero Cell");
		loaiVaccine.addItem("Moderna");
		loaiVaccine.addItem("Hayat-Vax");
		loaiVaccine.addItem("Abdala");
		loaiVaccine.addItem("Janssen");
		
		frame.getRootPane().setDefaultButton(submit);
		frame.setVisible(true);
	}
	//done
	public void setActionSubmitButton(ActionListener a) {
		submit.addActionListener(a);
	}
	
	public void setData(TiemVaccineInfo tiemVaccine) {
		hoTen.setText(tiemVaccine.getHoTen());
		id.setText(tiemVaccine.getId());
		lanTiem.setValue(tiemVaccine.getLanTiem());
		loaiVaccine.setSelectedItem(tiemVaccine.getLoaiVaccine());
		loVaccine.setText(tiemVaccine.getLoVaccine());
		ngayTiem.setText(tiemVaccine.getNgayTiem().toString());
		donViTiemChung.setText(tiemVaccine.getDonViTiemChung());
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
	//done
	public int getLanTiem() throws Exception {
		int a = (int) lanTiem.getValue(); 
		if (a <= 0)
			throw new Exception("Lần tiêm phải là số dương");
		return a;
	}
	
	public String getLoaiVaccine() {
		return (String) (loaiVaccine.getSelectedItem());
	}
	
	public String getLoVaccine() throws Exception {
		return loVaccine.getText();
	}
	
	public String getNgayTiem() throws Exception {
		String dateString = ngayTiem.getText();

		if (dateString.equals("")) {
			ngayTiem.requestFocus();
			throw new Exception("Chưa điền Ngày tiêm");
		}
		
		return dateString;
	}
	
	//done
	public String getDonViTiemChung() throws Exception {
		String dvi = donViTiemChung.getText();
		if (dvi.equals("")) {
			donViTiemChung.requestFocus();
			throw new Exception("Chưa điền Đơn vị tiêm chủng");
		}
		return dvi;
	}

	//done
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}
	
	public void dispose() {
		frame.dispose();
	}

}
