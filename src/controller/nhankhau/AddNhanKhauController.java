package controller.nhankhau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.NhanKhauModel;
import model.entity.NhanKhauInfo;
import view.nhankhau.AddNhanKhauView;

public class AddNhanKhauController {
	AddNhanKhauView addNhanKhauView = new AddNhanKhauView();
	NhanKhauModel nhanKhauModel = null;
	
	public AddNhanKhauController(NhanKhauModel nhanKhauModel) {
		this.nhanKhauModel = nhanKhauModel;
		addNhanKhauView.initialize();
		addNhanKhauView.setActionSubmitButton(new addTTCachLy());
	}
	
	class addTTCachLy implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				//HoTen Id	GioiTinh NgaySinh SoDienThoai SoTheBHYT Email QuocTich ThuongTruTamTru
				NhanKhauInfo nhanKhau = new NhanKhauInfo(
					addNhanKhauView.getHoTen(),
					addNhanKhauView.getId(),
					addNhanKhauView.getGioiTinh(),
					addNhanKhauView.getNgaySinh(),
					addNhanKhauView.getSoDienThoai(),
					addNhanKhauView.getSoTheBHYT(),
					addNhanKhauView.getEmail(),
					addNhanKhauView.getQuocTich(),
					addNhanKhauView.getThuongTruTamTru()
				);
				nhanKhauModel.insert(nhanKhau);
				addNhanKhauView.showMessage("Thêm dữ liệu thành công");
				addNhanKhauView.clear();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				addNhanKhauView.showMessage(e.getMessage());
			}
		}	
	}
	
}
