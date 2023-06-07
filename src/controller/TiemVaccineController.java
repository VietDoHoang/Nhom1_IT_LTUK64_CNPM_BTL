/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import controller.tiemvaccine.AddTiemVaccineController;
import controller.tiemvaccine.UpdateTiemVaccineController;
import model.TiemVaccineModel;
import view.TiemVaccineView;

/**
 * @author Acer
 *
 */
public class TiemVaccineController {
	private TiemVaccineView tiemVaccineView = new TiemVaccineView();
	private TiemVaccineModel tiemVaccineModel = new TiemVaccineModel(tiemVaccineView);
	//	HoTen	Id	LanTiem	LoaiVaccine	LoVaccine	NgayTiem	DonViTiemChung	
	public TiemVaccineController() {
		tiemVaccineView.initialize();
		tiemVaccineView.setActionAddButton(new addBtnAction());
		tiemVaccineView.setActionUpdateButton(new updateBtnAction());
		tiemVaccineView.setActionDeleteButton(new deleteBtnAction());
		tiemVaccineView.setKeyListenerFind(new findKeyListener());
		try {
			tiemVaccineView.setDataForTable(tiemVaccineModel.getData(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tiemVaccineView.showMessage(e.getMessage());
		}
	}
	
	class addBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new AddTiemVaccineController(tiemVaccineModel);
		}
	}
	
	class updateBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				new UpdateTiemVaccineController(tiemVaccineModel, tiemVaccineView.getSelectedInfo());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				tiemVaccineView.showMessage(e.getMessage());
			}
		}
	}
	
	class deleteBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
//			TiemVaccineView.getSelectedRow();
			try {
				tiemVaccineModel.delete(tiemVaccineView.getSelectedInfo());
				tiemVaccineView.showMessage("Xóa dữ liệu thành công");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				tiemVaccineView.showMessage("Loi databse");
			} catch (Exception e1) {
				// TODO: handle exception
				tiemVaccineView.showMessage(e1.getMessage());
			}
		}
	}
	
	class findKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			try {
				tiemVaccineView.setDataForTable(tiemVaccineModel.getData(tiemVaccineView.getTextToFind()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				tiemVaccineView.showMessage("Loi databse");
			} catch (Exception e1) {
				// TODO: handle exception
				tiemVaccineView.showMessage(e1.getMessage());
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
