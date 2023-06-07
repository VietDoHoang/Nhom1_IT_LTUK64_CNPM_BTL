package view.cach_ly;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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

import model.entity.CachLyInfo;
import model.entity.TestCovidInfo;
import view.TestCovidView;

public class ViewDetailCachLy {

	private JFrame frame;
	private JTextField hoTen;
	private JTextField id;
	private JTextField ngayBatDau;
	private JTextField mucDoCachLy;
	private JTextField diaChiCachLy;
	private JTable table;
	private DefaultTableModel model;

	public ViewDetailCachLy() {
//		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("XEM TH\u00D4NG TIN C\u00C1CH LY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(134, 11, 338, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1ECD & T\u00EAn:");
		lblNewLabel_1.setBounds(10, 83, 148, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		hoTen = new JTextField();
		hoTen.setEditable(false);
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
		id.setEditable(false);
		id.setBackground(UIManager.getColor("TextField.disabledBackground"));
		id.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		id.setColumns(10);
		id.setBounds(480, 83, 127, 20);
		frame.getContentPane().add(id);
		
		JLabel lblNewLabel_1_1 = new JLabel("S\u1ED1 h\u1ED9 chi\u1EBFu/CCCD:");
		lblNewLabel_1_1.setBounds(335, 83, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Th\u00F4ng tin c\u00E1ch ly:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 123, 148, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u c\u00E1ch ly:");
		lblNewLabel_1_4.setBounds(10, 154, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("M\u1EE9c \u0111\u1ED9 c\u00E1ch ly:");
		lblNewLabel_1_1_1.setBounds(335, 154, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		ngayBatDau = new JTextField();
		ngayBatDau.setEditable(false);
		ngayBatDau.setBackground(UIManager.getColor("TextField.disabledBackground"));
		ngayBatDau.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ngayBatDau.setColumns(10);
		ngayBatDau.setBounds(155, 154, 127, 20);
		frame.getContentPane().add(ngayBatDau);
		
		mucDoCachLy = new JTextField();
		mucDoCachLy.setEditable(false);
		mucDoCachLy.setBackground(UIManager.getColor("TextField.disabledBackground"));
		mucDoCachLy.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		mucDoCachLy.setColumns(10);
		mucDoCachLy.setBounds(480, 154, 127, 20);
		frame.getContentPane().add(mucDoCachLy);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("\u0110\u1ECBa ch\u1EC9 c\u00E1ch ly:");
		lblNewLabel_1_2_1.setBounds(10, 181, 148, 20);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		diaChiCachLy = new JTextField();
		diaChiCachLy.setEditable(false);
		diaChiCachLy.setBackground(UIManager.getColor("TextField.disabledBackground"));
		diaChiCachLy.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		diaChiCachLy.setColumns(10);
		diaChiCachLy.setBounds(155, 181, 452, 20);
		frame.getContentPane().add(diaChiCachLy);
		
		JButton close = new JButton("Close");
		close.setContentAreaFilled(false);
		close.setBounds(515, 423, 92, 29);
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.getContentPane().add(close);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Thông tin xét nghiệm:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(10, 221, 148, 20);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 252, 584, 148);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		frame.setVisible(true);
	}
	
	public void setData(CachLyInfo cachLyInfo){
		hoTen.setText(cachLyInfo.getHoTen());
		id.setText(cachLyInfo.getId());
		ngayBatDau.setText(cachLyInfo.getNgayBatDau().toString());
		mucDoCachLy.setText(cachLyInfo.getMucDoCachLy());
		diaChiCachLy.setText(cachLyInfo.getDiaChiCachLy());
		setDataTestCovid(cachLyInfo.getTestCovid());
	}
	
	private void setDataTestCovid(ArrayList<TestCovidInfo> data) {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(TestCovidView.colName);
		for (TestCovidInfo testCovid : data) {
			Object[] row = {
				testCovid.getHoTen(),
				testCovid.getId(),
				testCovid.getMaCode(),
				testCovid.getKetQua(),
				testCovid.getLoaiTest(),
				testCovid.getNgayTest()
			};
			model.addRow(row);
		}
		table.setModel(model);
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}
}
