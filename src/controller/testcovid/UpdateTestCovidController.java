package controller.testcovid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.NhanKhauModel;
import model.TestCovidModel;
import model.entity.TestCovidInfo;
import view.testcovid.UpdateTestCovidView;

public class UpdateTestCovidController {
	UpdateTestCovidView updateTestCovidView = new UpdateTestCovidView();
	TestCovidModel testCovidModel = null;
	TestCovidInfo testCovidCu;
	public UpdateTestCovidController(TestCovidModel testCovidModel, TestCovidInfo testCovidCu) {
		this.testCovidModel = testCovidModel;
		this.testCovidCu = testCovidCu;
		updateTestCovidView.initialize();
		updateTestCovidView.setData(testCovidCu);
		updateTestCovidView.setActionSubmitButton(new updateTTTestCovid());
	}
	
	class updateTTTestCovid implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				TestCovidInfo testCovid = new TestCovidInfo(
						NhanKhauModel.getNhanKhau(updateTestCovidView.getId(), updateTestCovidView.getHoTen()),
						updateTestCovidView.getMaCode(),
						updateTestCovidView.getKetQua(),
						updateTestCovidView.getLoaiTest(),
						updateTestCovidView.getNgayTest()
					);
				testCovidModel.update(testCovid, testCovidCu);
				updateTestCovidView.showMessage("Cập nhật dữ liệu thành công");
				updateTestCovidView.dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				updateTestCovidView.showMessage(e.getMessage());
			}
		}
	}
}
