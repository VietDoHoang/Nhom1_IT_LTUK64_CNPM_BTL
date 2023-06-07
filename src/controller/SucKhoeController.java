/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import controller.suckhoe.AddSucKhoeController;
import controller.suckhoe.UpdateSucKhoeController;
import model.SucKhoeModel;
import view.SucKhoeView;

/**
 * @author Acer
 *
 */
public class SucKhoeController {
	private SucKhoeView sucKhoeView = new SucKhoeView();
	private SucKhoeModel sucKhoeModel = new SucKhoeModel(sucKhoeView);
	
	public SucKhoeController() {
		sucKhoeView.initialize();
		sucKhoeView.setActionAddButton(new addBtnAction());
		sucKhoeView.setActionUpdateButton(new updateBtnAction());
		sucKhoeView.setActionDeleteButton(new deleteBtnAction());
		sucKhoeView.setKeyListenerFind(new findKeyListener());
		try {
			sucKhoeView.setDataForTable(sucKhoeModel.getData(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sucKhoeView.showMessage(e.getMessage());
		}
	}
	
	class addBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new AddSucKhoeController(sucKhoeModel);
		}
	}
	
	class updateBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				new UpdateSucKhoeController(sucKhoeModel, sucKhoeView.getSelectedInfo());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				sucKhoeView.showMessage(e.getMessage());
			}
		}
	}
	
	class deleteBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
//			SucKhoeView.getSelectedRow();
			try {
				sucKhoeModel.delete(sucKhoeView.getSelectedInfo());
				sucKhoeView.showMessage("Xóa dữ liệu thành công");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				sucKhoeView.showMessage("Loi databse");
			} catch (Exception e1) {
				// TODO: handle exception
				sucKhoeView.showMessage(e1.getMessage());
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
				sucKhoeView.setDataForTable(sucKhoeModel.getData(sucKhoeView.getTextToFind()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				sucKhoeView.showMessage("Loi databse");
			} catch (Exception e1) {
				// TODO: handle exception
				sucKhoeView.showMessage(e1.getMessage());
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
