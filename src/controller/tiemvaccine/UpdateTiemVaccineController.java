package controller.tiemvaccine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.NhanKhauModel;
import model.TiemVaccineModel;
import model.entity.TiemVaccineInfo;
import view.tiemvaccine.UpdateTiemVaccineView;

public class UpdateTiemVaccineController {
	UpdateTiemVaccineView updateTiemVaccineView = new UpdateTiemVaccineView();
	TiemVaccineModel tiemVaccineModel = null;
	TiemVaccineInfo tiemVaccineInfoCu;
	public UpdateTiemVaccineController(TiemVaccineModel tiemVaccineModel, TiemVaccineInfo tiemVaccineInfoCu) {
		this.tiemVaccineModel = tiemVaccineModel;
		this.tiemVaccineInfoCu = tiemVaccineInfoCu;
		updateTiemVaccineView.initialize();
		updateTiemVaccineView.setData(tiemVaccineInfoCu);
		updateTiemVaccineView.setActionSubmitButton(new updateTTTiemVaccine());
	}
	
	class updateTTTiemVaccine implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				TiemVaccineInfo tiemVaccine = new TiemVaccineInfo(
					NhanKhauModel.getNhanKhau(updateTiemVaccineView.getId(), updateTiemVaccineView.getHoTen()),
					updateTiemVaccineView.getLanTiem(),
					updateTiemVaccineView.getLoaiVaccine(),
					updateTiemVaccineView.getLoVaccine(),
					updateTiemVaccineView.getNgayTiem(),
					updateTiemVaccineView.getDonViTiemChung()
				);
				tiemVaccineModel.update(tiemVaccine, tiemVaccineInfoCu);
				updateTiemVaccineView.showMessage("Cập nhật dữ liệu thành công");
				updateTiemVaccineView.dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				updateTiemVaccineView.showMessage(e.getMessage());
			}
		}
	}
}
