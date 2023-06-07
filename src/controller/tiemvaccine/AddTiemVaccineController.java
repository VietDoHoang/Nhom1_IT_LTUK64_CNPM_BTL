package controller.tiemvaccine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.NhanKhauModel;
import model.TiemVaccineModel;
import model.entity.TiemVaccineInfo;
import view.tiemvaccine.AddTiemVaccineView;

public class AddTiemVaccineController {
	AddTiemVaccineView addTiemVaccineView = new AddTiemVaccineView();
	TiemVaccineModel tiemVaccineModel = null;
	
	public AddTiemVaccineController(TiemVaccineModel tiemVaccineModel) {
		this.tiemVaccineModel = tiemVaccineModel;
		addTiemVaccineView.initialize();
		addTiemVaccineView.setActionSubmitButton(new addTTTiemVaccine());
	}
	
	class addTTTiemVaccine implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				TiemVaccineInfo tiemVaccine = new TiemVaccineInfo(
					NhanKhauModel.getNhanKhau(addTiemVaccineView.getId(), addTiemVaccineView.getHoTen()),
					addTiemVaccineView.getLanTiem(),
					addTiemVaccineView.getLoaiVaccine(),
					addTiemVaccineView.getLoVaccine(),
					addTiemVaccineView.getNgayTiem(),
					addTiemVaccineView.getDonViTiemChung()
				);
				tiemVaccineModel.insert(tiemVaccine);
				addTiemVaccineView.showMessage("Thêm dữ liệu thành công");
				addTiemVaccineView.clear();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				addTiemVaccineView.showMessage(e.getMessage());
			}
		}	
	}
	
}
