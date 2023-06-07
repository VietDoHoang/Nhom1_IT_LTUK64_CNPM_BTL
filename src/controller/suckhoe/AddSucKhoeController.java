package controller.suckhoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.NhanKhauModel;
import model.SucKhoeModel;
import model.entity.SucKhoeInfo;
import view.suckhoe.AddSucKhoeView;

public class AddSucKhoeController {
	AddSucKhoeView addSucKhoeView = new AddSucKhoeView();
	SucKhoeModel sucKhoeModel = null;
	
	public AddSucKhoeController(SucKhoeModel sucKhoeModel) {
		this.sucKhoeModel = sucKhoeModel;
		addSucKhoeView.initialize();
		addSucKhoeView.setActionSubmitButton(new addTTSucKhoe());
	}
	
	class addTTSucKhoe implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				//HoTen	Id	KetQua	LoaiTest NgayTest
				SucKhoeInfo sucKhoe = new SucKhoeInfo(	
					NhanKhauModel.getNhanKhau(addSucKhoeView.getId(), addSucKhoeView.getHoTen()),
					addSucKhoeView.getHo(),
					addSucKhoeView.getSot(),
					addSucKhoeView.getKhoTho(),
					addSucKhoeView.getDauNguoi(),
					addSucKhoeView.getMatViGiac(),
					addSucKhoeView.getBuonNon(),
					addSucKhoeView.getTrieuChungKhac(),
					addSucKhoeView.getNgayXuatHien()
				);
				sucKhoeModel.insert(sucKhoe);
				addSucKhoeView.showMessage("Thêm dữ liệu thành công");
				addSucKhoeView.clear();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				addSucKhoeView.showMessage(e.getMessage());
			}
		}	
	}
	
}

