package controller.khaibao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.KhaiBaoModel;
import model.NhanKhauModel;
import model.entity.KhaiBaoInfo;
import view.khaibao.AddKhaiBaoView;

public class AddKhaiBaoController {
	AddKhaiBaoView addKhaiBaoView = new AddKhaiBaoView();
	KhaiBaoModel khaiBaoModel = null;
	
	public AddKhaiBaoController(KhaiBaoModel khaiBaoModel) {
		this.khaiBaoModel = khaiBaoModel;
		addKhaiBaoView.initialize();
		addKhaiBaoView.setActionSubmitButton(new addTTKhaiBao());
	}
	
	class addTTKhaiBao implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				//HoTen	Id	KetQua	LoaiTest NgayTest
				KhaiBaoInfo khaiBao = new KhaiBaoInfo(
					NhanKhauModel.getNhanKhau(addKhaiBaoView.getId(), addKhaiBaoView.getHoTen()),
					addKhaiBaoView.getTiepXucVoiNguoiBenh(),
					addKhaiBaoView.getDiVeTuVungDich(),
					addKhaiBaoView.getTiepXucVoiNguoiTuVungDich(),
					addKhaiBaoView.getNgayKhaiBao()
				);
				khaiBaoModel.insert(khaiBao);
				addKhaiBaoView.showMessage("Thêm dữ liệu thành công");
				addKhaiBaoView.clear();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				addKhaiBaoView.showMessage(e.getMessage());
			}
		}	
	}
	
}

