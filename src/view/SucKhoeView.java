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
import model.entity.SucKhoeInfo;

public class SucKhoeView {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textFind;
	private JButton btnAdd, btnUpdate, btnDelete, btnClose;
	public static final String colName[] = {"Mã khai báo", "Họ tên", "Số hộ chiếu/CCCD", "Ho", "Sốt", "Khó thở", "Đau người", "Mất vị giác", "Buồn nôn", "Triệu chứng khác", "Ngày xuất hiện"};
	
	public SucKhoeView() {
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
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ THÔNG TIN SỨC KHỎE BẤT THƯỜNG");
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
	
	public void setDataForTable(ArrayList<SucKhoeInfo> data) {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colName);
		for (SucKhoeInfo sucKhoe : data) {
			Object row[]= {
				sucKhoe.getMaKhaiBao(),
				sucKhoe.getHoTen(),
				sucKhoe.getId(),
				sucKhoe.getHo(),
				sucKhoe.getSot(),
				sucKhoe.getKhoTho(),
				sucKhoe.getDauNguoi(),
				sucKhoe.getMatViGiac(),
				sucKhoe.getBuonNon(),
				sucKhoe.getTrieuChungKhac(),
				sucKhoe.getNgayXuatHien()
			};
			
			model.addRow(row);
		}
		table.setModel(model);
	}
	
	public SucKhoeInfo getSelectedInfo() throws Exception{
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) throw new Exception("Chưa chọn thông tin"); 
		return new SucKhoeInfo(
				NhanKhauModel.getNhanKhau(table.getValueAt(selectedRow, 2).toString(), table.getValueAt(selectedRow, 1).toString()),
				(int) table.getValueAt(table.getSelectedRow(), 0),
				table.getValueAt(table.getSelectedRow(), 3).toString(),
				table.getValueAt(table.getSelectedRow(), 4).toString(),
				table.getValueAt(table.getSelectedRow(), 5).toString(),
				table.getValueAt(table.getSelectedRow(), 6).toString(),
				table.getValueAt(table.getSelectedRow(), 7).toString(),
				table.getValueAt(table.getSelectedRow(), 8).toString(),
				table.getValueAt(table.getSelectedRow(), 9).toString(),
				table.getValueAt(table.getSelectedRow(), 10).toString()
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
