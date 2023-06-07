package controller.nhankhau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.NhanKhauModel;
import model.entity.NhanKhauInfo;
import view.nhankhau.UpdateNhanKhauView;

public class UpdateNhanKhauController {
	UpdateNhanKhauView updateNhanKhauView = new UpdateNhanKhauView();
	NhanKhauModel nhanKhauModel = null;
	NhanKhauInfo nhanKhauCu;
	
	public UpdateNhanKhauController(NhanKhauModel nhanKhauModel, NhanKhauInfo nhanKhauCu) {
		this.nhanKhauModel = nhanKhauModel;
		this.nhanKhauCu = nhanKhauCu;
		updateNhanKhauView.initialize();
		updateNhanKhauView.setData(nhanKhauCu);
		updateNhanKhauView.setActionSubmitButton(new updateTTNhanKhau());
	}
	
	class updateTTNhanKhau implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				NhanKhauInfo nhanKhauMoi = new NhanKhauInfo(
					updateNhanKhauView.getHoTen(),
					updateNhanKhauView.getId(),
					updateNhanKhauView.getGioiTinh(),
					updateNhanKhauView.getNgaySinh(),
					updateNhanKhauView.getSoDienThoai(),
					updateNhanKhauView.getSoTheBHYT(),
					updateNhanKhauView.getEmail(),
					updateNhanKhauView.getQuocTich(),
					updateNhanKhauView.getThuongTruTamTru()
				);
				nhanKhauModel.update(nhanKhauMoi, nhanKhauCu);
				updateNhanKhauView.showMessage("Cập nhật dữ liệu thành công");
				updateNhanKhauView.dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				updateNhanKhauView.showMessage(e.getMessage());
			}
		}
	}
}
