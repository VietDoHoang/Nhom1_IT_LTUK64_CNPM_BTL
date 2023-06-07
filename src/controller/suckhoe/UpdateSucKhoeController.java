package controller.suckhoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.NhanKhauModel;
import model.SucKhoeModel;
import model.entity.SucKhoeInfo;
import view.suckhoe.UpdateSucKhoeView;

public class UpdateSucKhoeController {
	UpdateSucKhoeView updateSucKhoeView = new UpdateSucKhoeView();
	SucKhoeModel sucKhoeModel = null;
	SucKhoeInfo sucKhoeCu;
	public UpdateSucKhoeController(SucKhoeModel sucKhoeModel, SucKhoeInfo sucKhoeCu) {
		this.sucKhoeModel = sucKhoeModel;
		this.sucKhoeCu = sucKhoeCu;
		updateSucKhoeView.initialize();
		updateSucKhoeView.setData(sucKhoeCu);
		updateSucKhoeView.setActionSubmitButton(new updateTTSucKhoe());
	}
	
	class updateTTSucKhoe implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				SucKhoeInfo sucKhoe = new SucKhoeInfo(	
					NhanKhauModel.getNhanKhau(updateSucKhoeView.getId(), updateSucKhoeView.getHoTen()),
					updateSucKhoeView.getHo(),
					updateSucKhoeView.getSot(),
					updateSucKhoeView.getKhoTho(),
					updateSucKhoeView.getDauNguoi(),
					updateSucKhoeView.getMatViGiac(),
					updateSucKhoeView.getBuonNon(),
					updateSucKhoeView.getTrieuChungKhac(),
					updateSucKhoeView.getNgayXuatHien()
				);
				sucKhoeModel.update(sucKhoe, sucKhoeCu);
				updateSucKhoeView.showMessage("Cập nhật dữ liệu thành công");
				updateSucKhoeView.dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				updateSucKhoeView.showMessage(e.getMessage());
			}
		}
	}
}
