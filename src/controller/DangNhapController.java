package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DangNhapModel;
import model.entity.DangNhapInfo;
import view.DangNhapView;

public class DangNhapController {
	private DangNhapView dangNhapView = new DangNhapView();
	private DangNhapModel dangNhapModel = new DangNhapModel();
	
	
	public DangNhapController() {
		dangNhapView.initialize();
		dangNhapView.setActionSubmitButton(new SubmitBtnAction());
	}


	class SubmitBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				String username = dangNhapView.getUsername();
				String password = dangNhapView.getPassword();
				if(username.equals("")||password.equals("")) {
					dangNhapView.showMessage("Bạn chưa nhập tên đăng nhập hoặc mật khẩu");
				}else {
					DangNhapInfo user = dangNhapModel.getUser(username, password);
					if (user == null) dangNhapView.showMessage("Tên đăng nhập hoặc mật khẩu không đúng");
					else {
						dangNhapView.dispose();
						new MainController(user);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				dangNhapView.showMessage(e.getMessage());
			}
		}
	}
}
