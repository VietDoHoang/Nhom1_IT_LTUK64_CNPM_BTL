package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class ThongKeView {

	private JFrame frame;
	private JTextField ngayBatDau;
	private JTextField ngayKetThuc;
	private JButton thongKeBtn;
	private JTable table;
	private JComboBox<String> choose;
	private JLabel result;
	
	public ThongKeView() {
//		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 892, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 856, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thống kê từ ngày:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 97, 142, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		ngayBatDau = new JTextField();
		ngayBatDau.setBackground(UIManager.getColor("TextField.disabledBackground"));
		ngayBatDau.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ngayBatDau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ngayBatDau.setBounds(136, 97, 178, 22);
		frame.getContentPane().add(ngayBatDau);
		ngayBatDau.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("đến ngày:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(324, 97, 71, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		ngayKetThuc = new JTextField();
		ngayKetThuc.setBackground(UIManager.getColor("TextField.disabledBackground"));
		ngayKetThuc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ngayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ngayKetThuc.setBounds(391, 97, 178, 22);
		frame.getContentPane().add(ngayKetThuc);
		ngayKetThuc.setColumns(10);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		closeBtn.setBounds(760, 372, 106, 37);
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.getContentPane().add(closeBtn);
		
		thongKeBtn = new JButton("Thống kê");
		thongKeBtn.setContentAreaFilled(false);
		thongKeBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		thongKeBtn.setBounds(607, 82, 169, 37);
		frame.getContentPane().add(thongKeBtn);
		
		JLabel lblNewLabel_3 = new JLabel("Thống kê theo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 63, 126, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		choose = new JComboBox<String>();
		choose.setBounds(106, 63, 342, 22);
		frame.getContentPane().add(choose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 856, 222);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		result = new JLabel("Tổng: 0 nhân khẩu");
		result.setFont(new Font("Tahoma", Font.PLAIN, 13));
		result.setBounds(10, 372, 585, 23);
		frame.getContentPane().add(result);
		
		choose.addItem("Thống kê người đã cách ly");
		choose.addItem("Thống kê người có lịch sử dịch tễ");
		choose.addItem("Thống kê người có sức khỏe bất thường");
		choose.addItem("Thống kê người có kết quả test covid dương tính");
		choose.addItem("Thống kê người đã tiêm vaccine");
		
		frame.setVisible(true);
	}
	
	public void setActionThongKe(ActionListener action) {
		thongKeBtn.addActionListener(action);
	}
	
	public String getChooseOption(){
		return (String) choose.getSelectedItem();
	}
	
	public Date getNgayBatDau() throws Exception {
		Date date = null;
		if (ngayBatDau.getText().equals("")) {
			ngayBatDau.requestFocus();
			throw new Exception("Chưa điền ngày bắt đầu");
		}
		String[] d = ngayBatDau.getText().split("[^0-9]");
		if (d.length != 3) throw new Exception("Sai định dạng (yyyy/MM/dd)");
		try {
			date = Date.valueOf(d[0] + "-" + d[1] + "-" + d[2]);
		} catch (Exception e) {
			throw new Exception("Ngày không hợp lệ (yyyy/MM/dd)");
		}
		return date;
	}
	
	public Date getNgayKetThuc() throws Exception {
		Date date = null;
		if (ngayKetThuc.getText().equals("")) {
			ngayKetThuc.requestFocus();
			throw new Exception("Chưa điền ngày kết thúc");
		}
		String[] d = ngayKetThuc.getText().split("[^0-9]");
		if (d.length != 3) throw new Exception("Sai định dạng (yyyy/MM/dd)");
		try {
			date = Date.valueOf(d[0] + "-" + d[1] + "-" + d[2]);
		} catch (Exception e) {
			throw new Exception("Ngày không hợp lệ (yyyy/MM/dd)");
		}
		return date;
	}
	
	public void setTable(DefaultTableModel model) {
		table.setModel(model);
	}
	
	public void setResult(String rs) {
		result.setText("Tổng: " + rs);
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}
}
