package controller.khaibao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.KhaiBaoModel;
import model.NhanKhauModel;
import model.entity.KhaiBaoInfo;
import view.khaibao.UpdateKhaiBaoView;

public class UpdateKhaiBaoController {
	UpdateKhaiBaoView updateKhaiBaoView = new UpdateKhaiBaoView();
	KhaiBaoModel khaiBaoModel = null;
	KhaiBaoInfo khaiBaoCu;
	public UpdateKhaiBaoController(KhaiBaoModel khaiBaoModel, KhaiBaoInfo khaiBaoCu) {
		this.khaiBaoModel = khaiBaoModel;
		this.khaiBaoCu = khaiBaoCu;
		updateKhaiBaoView.initialize();
		updateKhaiBaoView.setData(khaiBaoCu);
		updateKhaiBaoView.setActionSubmitButton(new updateTTKhaiBao());
	}
	
	class updateTTKhaiBao implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				KhaiBaoInfo khaiBao = new KhaiBaoInfo(
					NhanKhauModel.getNhanKhau(updateKhaiBaoView.getId(), updateKhaiBaoView.getHoTen()),
					updateKhaiBaoView.getTiepXucVoiNguoiBenh(),
					updateKhaiBaoView.getDiVeTuVungDich(),
					updateKhaiBaoView.getTiepXucVoiNguoiTuVungDich(),
					updateKhaiBaoView.getNgayKhaiBao()
				);
				khaiBaoModel.update(khaiBao, khaiBaoCu);
				updateKhaiBaoView.showMessage("Cập nhật dữ liệu thành công");
				updateKhaiBaoView.dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				updateKhaiBaoView.showMessage(e.getMessage());
			}
		}
	}
}
