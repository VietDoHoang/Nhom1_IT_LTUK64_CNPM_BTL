package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entity.DangNhapInfo;
import view.MainView;

public class MainController {
	private MainView mainView = new MainView();
	private DangNhapInfo user;
	public MainController(DangNhapInfo user) {
		this.user = user;
		mainView.initialize();
		mainView.setUsername(user.getUsername());
		mainView.setActionCachLy(new CachLyBtn());
		mainView.setActionTestCovid(new TestCovidBtn());
		mainView.setActionNhanKhau(new NhanKhauBtn());
		mainView.setActionTiemVaccine(new TiemVaccineBtn());
		mainView.setActionKhaiBaoYTe(new KhaiBaoYTeBtn());
		mainView.setActionSucKhoe(new SucKhoeBtn());
		mainView.setActionThongKe(new ThongKeBtn());
	}
	
	class CachLyBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (user.getQLCachLy().equals("Y")) 
				new CachLyController();
			else mainView.showMessage("Bạn không có quyền truy cập vào chức năng này");
		}
	}
	
	class TestCovidBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if (user.getQLTestCovid().equals("Y")) 
				new TestCovidController();
			else mainView.showMessage("Bạn không có quyền truy cập vào chức năng này");
		}
	}
	

	class NhanKhauBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (user.getQLNhanKhau().equals("Y")) 
				new NhanKhauController();
			else mainView.showMessage("Bạn không có quyền truy cập vào chức năng này");
		}
	}
	
	class TiemVaccineBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if (user.getQLTiemVaccine().equals("Y")) 
				new TiemVaccineController();
			else mainView.showMessage("Bạn không có quyền truy cập vào chức năng này");
		}
	}
	
	class SucKhoeBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if (user.getQLSucKhoe().equals("Y")) 
				new SucKhoeController();
			else mainView.showMessage("Bạn không có quyền truy cập vào chức năng này");
		}
	}
	
	class KhaiBaoYTeBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if (user.getQLKhaiBao().equals("Y")) 
				new KhaiBaoController();
			else mainView.showMessage("Bạn không có quyền truy cập vào chức năng này");
		}
	}
	
	class ThongKeBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (user.getThongKe().equals("Y")) 
				new ThongKeController();
			else mainView.showMessage("Bạn không có quyền truy cập vào chức năng này");
			
		}
	}
}
