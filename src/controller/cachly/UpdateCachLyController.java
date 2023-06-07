package controller.cachly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CachLyModel;
import model.NhanKhauModel;
import model.entity.CachLyInfo;
import view.cach_ly.UpdateCachLyView;

public class UpdateCachLyController {
	UpdateCachLyView updateCachLyView = new UpdateCachLyView();
	CachLyModel cachLyModel = null;
	CachLyInfo cachLyInfoCu;
	
	public UpdateCachLyController(CachLyModel cachLyModel, CachLyInfo cachLyInfoCu) {
		this.cachLyModel = cachLyModel;
		this.cachLyInfoCu = cachLyInfoCu;
		updateCachLyView.initialize();
		updateCachLyView.setData(cachLyInfoCu);
		updateCachLyView.setActionSubmitButton(new updateTTCachLy());
	}
	
	class updateTTCachLy implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				CachLyInfo cachLyInfo = new CachLyInfo(
					NhanKhauModel.getNhanKhau(updateCachLyView.getId(), updateCachLyView.getHoTen()),
					updateCachLyView.getNgayBatDau(),
					updateCachLyView.getMucDoCachLy(),
					updateCachLyView.getDiaChiCachLy()
				);
				cachLyModel.update(cachLyInfo, cachLyInfoCu);
				updateCachLyView.showMessage("Cập nhật dữ liệu thành công");
				updateCachLyView.dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				updateCachLyView.showMessage(e.getMessage());
			}
		}
	}
}
