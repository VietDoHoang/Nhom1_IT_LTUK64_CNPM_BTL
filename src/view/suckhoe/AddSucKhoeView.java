package view.suckhoe;

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

public class AddSucKhoeView {

	private JFrame frame;
	private JTextField hoTen;
	private JTextField id;
	private JButton submit;
	private JTextField ngayXuatHien;
	private JRadioButton coHo, khongHo, coSot, khongSot, coKhoTho, khongKhoTho, coDauNguoi, khongDauNguoi, coMatViGiac, khongMatViGiac, coBuonNon, khongBuonNon;
	private JTextField trieuChungKhac;

	public AddSucKhoeView() {
//		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 399);
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
		
		JLabel lblNewLabel_2_1 = new JLabel("Hiện tưởng sức khỏe:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 123, 148, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblHo = new JLabel("Ho:");
		lblHo.setBounds(10, 154, 66, 20);
		frame.getContentPane().add(lblHo);
		
		submit = new JButton("Submit");
		submit.setContentAreaFilled(false);
		submit.setBounds(256, 303, 109, 34);
		frame.getContentPane().add(submit);
		
		JButton close = new JButton("Close");
		close.setContentAreaFilled(false);
		close.setBounds(515, 320, 92, 29);
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.getContentPane().add(close);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Ngày xuất hiện (yyyy/MM/dd):");
		lblNewLabel_1_4_1.setBounds(10, 269, 172, 20);
		frame.getContentPane().add(lblNewLabel_1_4_1);
		
		ngayXuatHien = new JTextField();
		ngayXuatHien.setColumns(10);
		ngayXuatHien.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ngayXuatHien.setBackground(SystemColor.menu);
		ngayXuatHien.setBounds(192, 270, 415, 20);
		frame.getContentPane().add(ngayXuatHien);
		
		coHo = new JRadioButton("Có");
		coHo.setBounds(104, 153, 71, 23);
		frame.getContentPane().add(coHo);
		
		khongHo = new JRadioButton("Không");
		khongHo.setBounds(182, 153, 100, 23);
		frame.getContentPane().add(khongHo);
			
		khongSot = new JRadioButton("Không");
		khongSot.setBounds(182, 181, 100, 23);
		frame.getContentPane().add(khongSot);
		
		coSot = new JRadioButton("Có");
		coSot.setBounds(104, 181, 71, 23);
		frame.getContentPane().add(coSot);
		
		JLabel lblSt = new JLabel("Sốt");
		lblSt.setBounds(10, 182, 66, 20);
		frame.getContentPane().add(lblSt);
		
		khongDauNguoi = new JRadioButton("Không");
		khongDauNguoi.setBounds(507, 151, 100, 23);
		frame.getContentPane().add(khongDauNguoi);
		
		coDauNguoi = new JRadioButton("Có");
		coDauNguoi.setBounds(434, 151, 71, 23);
		frame.getContentPane().add(coDauNguoi);
		
		JLabel lblauNgi = new JLabel("Đau người:");
		lblauNgi.setBounds(335, 152, 66, 20);
		frame.getContentPane().add(lblauNgi);
		
		khongMatViGiac = new JRadioButton("Không");
		khongMatViGiac.setBounds(507, 181, 100, 23);
		frame.getContentPane().add(khongMatViGiac);
		
		coMatViGiac = new JRadioButton("Có");
		coMatViGiac.setBounds(434, 181, 71, 23);
		frame.getContentPane().add(coMatViGiac);
		
		JLabel lblMtVGic = new JLabel("Mất vị giác:");
		lblMtVGic.setBounds(335, 182, 66, 20);
		frame.getContentPane().add(lblMtVGic);
		
		khongKhoTho = new JRadioButton("Không");
		khongKhoTho.setBounds(182, 208, 100, 23);
		frame.getContentPane().add(khongKhoTho);
		
		coKhoTho = new JRadioButton("Có");
		coKhoTho.setBounds(104, 208, 71, 23);
		frame.getContentPane().add(coKhoTho);
		
		JLabel lblKhTh = new JLabel("Khó thở:");
		lblKhTh.setBounds(10, 209, 66, 20);
		frame.getContentPane().add(lblKhTh);
		
		khongBuonNon = new JRadioButton("Không");
		khongBuonNon.setBounds(507, 208, 100, 23);
		frame.getContentPane().add(khongBuonNon);
		
		coBuonNon = new JRadioButton("Có");
		coBuonNon.setBounds(434, 208, 71, 23);
		frame.getContentPane().add(coBuonNon);
		
		JLabel lblBunNn = new JLabel("Buồn nôn:");
		lblBunNn.setBounds(335, 209, 66, 20);
		frame.getContentPane().add(lblBunNn);
		
		ButtonGroup ho = new ButtonGroup();
		ho.add(coHo);
		ho.add(khongHo);
		khongHo.setSelected(true);
		ButtonGroup sot = new ButtonGroup();
		sot.add(coSot);
		sot.add(khongSot);
		khongSot.setSelected(true);
		ButtonGroup khoTho = new ButtonGroup();
		khoTho.add(coKhoTho);
		khoTho.add(khongKhoTho);
		khongKhoTho.setSelected(true);
		ButtonGroup dauNguoi = new ButtonGroup();
		dauNguoi.add(coDauNguoi);
		dauNguoi.add(khongDauNguoi);
		khongDauNguoi.setSelected(true);
		ButtonGroup matViGiac = new ButtonGroup();
		matViGiac.add(coMatViGiac);
		matViGiac.add(khongMatViGiac);
		khongMatViGiac.setSelected(true);
		ButtonGroup buonNon = new ButtonGroup();
		buonNon.add(coBuonNon);
		buonNon.add(khongBuonNon);
		khongBuonNon.setSelected(true);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Triệu chứng khác:");
		lblNewLabel_1_4_1_1.setBounds(10, 238, 172, 20);
		frame.getContentPane().add(lblNewLabel_1_4_1_1);
		
		trieuChungKhac = new JTextField();
		trieuChungKhac.setColumns(10);
		trieuChungKhac.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		trieuChungKhac.setBackground(SystemColor.menu);
		trieuChungKhac.setBounds(192, 239, 415, 20);
		frame.getContentPane().add(trieuChungKhac);
		
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
//		coHo.setSelected(false);
		khongHo.setSelected(true);
		khongSot.setSelected(true);
		khongKhoTho.setSelected(true);
		khongDauNguoi.setSelected(true);
		khongBuonNon.setSelected(true);
		khongMatViGiac.setSelected(true);
		trieuChungKhac.setText("");
		ngayXuatHien.setText("");
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
	
	public String getHo() {
		if (coHo.isSelected()) return "Có";
		else return "Không";
	}
	
	public String getSot() {
		if (coSot.isSelected()) return "Có";
		else return "Không";
	}
	
	public String getKhoTho() {
		if (coKhoTho.isSelected()) return "Có";
		else return "Không";
	}
	
	public String getDauNguoi() {
		if (coDauNguoi.isSelected()) return "Có";
		else return "Không";
	}
	
	public String getMatViGiac() {
		if (coMatViGiac.isSelected()) return "Có";
		else return "Không";
	}
	
	public String getBuonNon() {
		if (coBuonNon.isSelected()) return "Có";
		else return "Không";
	}
	
	public String getTrieuChungKhac() {
		String khac = trieuChungKhac.getText();
		return khac;
	}
	
	public String getNgayXuatHien() throws Exception{
		String dateString = ngayXuatHien.getText();
		
		if (dateString.equals("")) {
			ngayXuatHien.requestFocus();
			throw new Exception("Chưa điền Ngày xuất hiện");
		}
		
		return dateString;
	}

	//done
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frame, message);
	}
}
