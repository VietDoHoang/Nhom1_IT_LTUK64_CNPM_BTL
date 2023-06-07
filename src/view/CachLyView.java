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
import model.entity.CachLyInfo;

public class CachLyView {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textFind;
	private JButton btnAdd, btnUpdate, btnDelete, btnClose, btnView;
	public static final String colName[] = {"Họ tên", "Số hộ chiếu/CCCD", "Ngày bắt đầu", "Mức độ cách ly", "Địa chỉ cách ly", "Số lần test Covid"};
	/**
	 * @wbp.parser.entryPoint
	 */
	public CachLyView() {
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
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ THÔNG TIN CÁCH LY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 856, 38);
		frame.getContentPane().add(lblNewLabel);
		
		textFind = new JTextField();
		textFind.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textFind.setBackground(UIManager.getColor("TextField.disabledBackground"));
		textFind.setBounds(665, 343, 201, 30);
		frame.getContentPane().add(textFind);
		textFind.setColumns(10);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBounds(10, 338, 144, 38);
		frame.getContentPane().add(btnAdd);
		
		btnUpdate = new JButton("Sửa");
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBounds(164, 338, 144, 38);
		frame.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBounds(164, 387, 144, 38);
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
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm (Bằng Tên hoặc ID):");
		lblNewLabel_1.setBounds(483, 338, 172, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnView = new JButton("Xem chi tiết");
		btnView.setContentAreaFilled(false);
		btnView.setBounds(10, 387, 144, 38);
		frame.getContentPane().add(btnView);
		
		frame.setVisible(true);
	}
	
	public void setDataForTable(ArrayList<CachLyInfo> data) {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colName);
		for (CachLyInfo  cachLyInfo : data) {
			Object[] row = {
				cachLyInfo.getHoTen(),
				cachLyInfo.getId(),
				cachLyInfo.getNgayBatDau(),
				cachLyInfo.getMucDoCachLy(),
				cachLyInfo.getDiaChiCachLy(),
				cachLyInfo.getTestCovid().size()
			};
			model.addRow(row);
		}
		table.setModel(model);
	}
	
	public CachLyInfo getSelectedInfo() throws Exception{
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) throw new Exception("Chưa chọn thông tin"); 
		return new CachLyInfo(
				NhanKhauModel.getNhanKhau((String) table.getValueAt(selectedRow, 1), (String) table.getValueAt(selectedRow, 0)),
				table.getValueAt(selectedRow, 2).toString(),
				table.getValueAt(selectedRow, 3).toString(),
				table.getValueAt(selectedRow, 4).toString()
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
	
	public void setActionViewButton(ActionListener action) {
		btnView.addActionListener(action);
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
