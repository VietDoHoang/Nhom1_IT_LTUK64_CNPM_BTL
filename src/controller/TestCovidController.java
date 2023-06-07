/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import controller.testcovid.AddTestCovidController;
import controller.testcovid.UpdateTestCovidController;
import model.TestCovidModel;
import view.TestCovidView;

/**
 * @author Acer
 *
 */
public class TestCovidController {
	private TestCovidView testCovidView = new TestCovidView();
	private TestCovidModel testCovidModel = new TestCovidModel(testCovidView);
	
	public TestCovidController() {
		testCovidView.initialize();
		testCovidView.setActionAddButton(new addBtnAction());
		testCovidView.setActionUpdateButton(new updateBtnAction());
		testCovidView.setActionDeleteButton(new deleteBtnAction());
		testCovidView.setKeyListenerFind(new findKeyListener());
		try {
			testCovidView.setDataForTable(testCovidModel.getData(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testCovidView.showMessage(e.getMessage());
		}
	}
	
	class addBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new AddTestCovidController(testCovidModel);
		}
	}
	
	class updateBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				new UpdateTestCovidController(testCovidModel, testCovidView.getSelectedInfo());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				testCovidView.showMessage(e.getMessage());
			}
		}
	}
	
	class deleteBtnAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
//			testCovidView.getSelectedRow();
			try {
				testCovidModel.delete(testCovidView.getSelectedInfo());
				testCovidView.showMessage("Xóa dữ liệu thành công");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				testCovidView.showMessage("Loi databse");
			} catch (Exception e1) {
				// TODO: handle exception
				testCovidView.showMessage(e1.getMessage());
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
				testCovidView.setDataForTable(testCovidModel.getData(testCovidView.getTextToFind()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				testCovidView.showMessage("Loi databse");
			} catch (Exception e1) {
				// TODO: handle exception
				testCovidView.showMessage(e1.getMessage());
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
