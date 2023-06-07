package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
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

import model.NhanKhauModel;
import model.entity.TestCovidInfo;

public class TestCovidView {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textFind;
	private JButton btnAdd, btnUpdate, btnDelete, btnClose;
	public static final String colName[] = {"Họ tên", "Số hộ chiếu/CCCD", "Mã code", "Kết quả", "Kiểu test", "Ngày test"};
	public TestCovidView() {
//		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 892, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 856, 278);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ XÉT NGHIỆM COVID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 856, 38);
		frame.getContentPane().add(lblNewLabel);
	
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm (Bằng Tên, ID hoặc Mã):");
		lblNewLabel_1.setBounds(468, 338, 187, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFind = new JTextField();
		textFind.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFind.setBackground(UIManager.getColor("TextField.disabledBackground"));
		textFind.setBounds(665, 343, 201, 30);
		frame.getContentPane().add(textFind);
		textFind.setColumns(10);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBounds(10, 338, 256, 38);
		frame.getContentPane().add(btnAdd);
		
		btnUpdate = new JButton("Sửa");
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBounds(10, 387, 123, 38);
		frame.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBounds(143, 387, 123, 38);
		frame.getContentPane().add(btnDelete);
		
		btnClose = new JButton("Close");
		btnClose.setContentAreaFilled(false);
		btnClose.setBounds(743, 405, 123, 38);
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnClose);
		
		frame.setVisible(true);
	}
	
	public void setDataForTable(ArrayList<TestCovidInfo> data) {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colName);
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
	
	public TestCovidInfo getSelectedInfo() throws Exception{
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) throw new Exception("Chưa chọn thông tin"); 
	
		return new TestCovidInfo(
				NhanKhauModel.getNhanKhau(table.getValueAt(table.getSelectedRow(), 1).toString(), table.getValueAt(table.getSelectedRow(), 0).toString()),
				table.getValueAt(table.getSelectedRow(), 2).toString(),
				table.getValueAt(table.getSelectedRow(), 3).toString(),
				table.getValueAt(table.getSelectedRow(), 4).toString(),
				table.getValueAt(table.getSelectedRow(), 5).toString()
				);
	}
	
	public String getTextToFind() {
		return textFind.getText();
	}
	
	public void setActionAddButton(ActionListener action) {
		btnAdd.addActionListener(action);
	}
	
	public void setActionUpdateButton(ActionListener action) {
		btnUpdate.addActionListener(action);
	}
	
	public void setActionDeleteButton(ActionListener action) {
		btnDelete.addActionListener(action);
	}
	
	public void setKeyListenerFind(KeyListener action) {
		textFind.addKeyListener(action);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}
}
