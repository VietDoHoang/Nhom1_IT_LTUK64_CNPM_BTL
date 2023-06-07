/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import controller.khaibao.AddKhaiBaoController;
import controller.khaibao.UpdateKhaiBaoController;
import model.KhaiBaoModel;
import view.KhaiBaoView;

/**
 * @author Acer
 *
 */
public class KhaiBaoController {
	private KhaiBaoView khaiBaoView = new KhaiBaoView();
	private KhaiBaoModel khaiBaoModel = new KhaiBaoModel(khaiBaoView);
	
	public KhaiBaoController() {
		khaiBaoView.initialize();
		khaiBaoView.setActionAddButton(new addBtnAction());
		khaiBaoView.setActionUpdateButton(new updateBtnAction());
		khaiBaoView.setActionDeleteButton(new deleteBtnAction());
		khaiBaoView.setKeyListenerFind(new findKeyListener());
		try {
			khaiBaoView.setDataForTable(khaiBaoModel.getData(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			khaiBaoView.showMessage(e.getMessage());
		}
	}
	
	class addBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new AddKhaiBaoController(khaiBaoModel);
		}
	}
	
	class updateBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				new UpdateKhaiBaoController(khaiBaoModel, khaiBaoView.getSelectedInfo());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				khaiBaoView.showMessage(e.getMessage());
			}
		}
	}
	
	class deleteBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
//			KhaiBaoView.getSelectedRow();
			try {
				khaiBaoModel.delete(khaiBaoView.getSelectedInfo());
				khaiBaoView.showMessage("Xóa dữ liệu thành công");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				khaiBaoView.showMessage("Loi databse");
			} catch (Exception e1) {
				// TODO: handle exception
				khaiBaoView.showMessage(e1.getMessage());
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
				khaiBaoView.setDataForTable(khaiBaoModel.getData(khaiBaoView.getTextToFind()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				khaiBaoView.showMessage("Loi databse");
			} catch (Exception e1) {
				// TODO: handle exception
				khaiBaoView.showMessage(e1.getMessage());
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
		
}
