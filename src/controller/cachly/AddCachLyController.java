package controller.cachly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CachLyModel;
import model.NhanKhauModel;
import model.entity.CachLyInfo;
import view.cach_ly.AddCachLyView;

public class AddCachLyController {
	AddCachLyView addCachLyView = new AddCachLyView();
	CachLyModel cachLyModel = null;
	
	public AddCachLyController(CachLyModel cachLyModel) {
		this.cachLyModel = cachLyModel;
		addCachLyView.initialize();
		addCachLyView.setActionSubmitButton(new addTTCachLy());
	}
	
	class addTTCachLy implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				CachLyInfo cachLyInfo = new CachLyInfo(
					NhanKhauModel.getNhanKhau(addCachLyView.getId(), addCachLyView.getHoTen()),
					addCachLyView.getNgayBatDau(),
					addCachLyView.getMucDoCachLy(),
					addCachLyView.getDiaChiCachLy()
				);
				cachLyModel.insert(cachLyInfo);
				addCachLyView.showMessage("Thêm dữ liệu thành công");
				addCachLyView.clear();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				addCachLyView.showMessage(e.getMessage());
			}
		}	
	}
	
}
