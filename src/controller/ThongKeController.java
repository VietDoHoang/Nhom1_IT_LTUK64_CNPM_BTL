package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.ThongKeModel;
import model.entity.CachLyInfo;
import model.entity.KhaiBaoInfo;
import model.entity.SucKhoeInfo;
import model.entity.TestCovidInfo;
import model.entity.TiemVaccineInfo;
import view.CachLyView;
import view.KhaiBaoView;
import view.SucKhoeView;
import view.TestCovidView;
import view.ThongKeView;
import view.TiemVaccineView;

public class ThongKeController {
	
	ThongKeView thongKeView = new ThongKeView();
	ThongKeModel thongKeModel = new ThongKeModel();
	
	public ThongKeController() {
		// TODO Auto-generated constructor stub
		thongKeView.initialize();
		thongKeView.setActionThongKe(new ThongKeAction());
	}
	
	class ThongKeAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				String choose = thongKeView.getChooseOption();
				String colName[];
				DefaultTableModel model = null;
				Date startDate = thongKeView.getNgayBatDau();
				Date endDate = thongKeView.getNgayKetThuc();
				
				if (startDate.compareTo(endDate) > 0) throw new Exception("Ngày bắt đầu phải trước ngày kết thúc");
				
				if (choose.equals("Thống kê người đã cách ly")) {
					colName = CachLyView.colName;
					ArrayList<CachLyInfo> data = thongKeModel.getCachLy(startDate, endDate);
					model = new DefaultTableModel();
					model.setColumnIdentifiers(colName);
					for (CachLyInfo  cachLyInfo : data) {
						Object[] row = {
							cachLyInfo.getHoTen(),
							cachLyInfo.getId(),
							cachLyInfo.getNgayBatDau(),
							cachLyInfo.getMucDoCachLy(),
							cachLyInfo.getDiaChiCachLy(),
							cachLyInfo.getTestCovid().size()
						};
						model.addRow(row);
					}
					thongKeView.setResult(data.size() + " trường hợp cách ly");
				}
				else if (choose.equals("Thống kê người có lịch sử dịch tễ")) {
					colName = KhaiBaoView.colName;
					ArrayList<KhaiBaoInfo> data = thongKeModel.getKhaiBao(startDate, endDate);
					model = new DefaultTableModel();
					model.setColumnIdentifiers(colName);
					for (KhaiBaoInfo khaiBaoInfo: data) {
						Object[] row = {
							khaiBaoInfo.getMaKhaiBao(),
							khaiBaoInfo.getHoTen(),
							khaiBaoInfo.getId(),
							khaiBaoInfo.getTiepXucVoiNguoiBenh(),
							khaiBaoInfo.getDiVeTuVungDich(),
							khaiBaoInfo.getTiepXucVoiNguoiTuVungDich(),
							khaiBaoInfo.getNgayKhaiBao()
						};
					
						model.addRow(row);
					}
					thongKeView.setResult(data.size() + " khai báo");
				} 
				else if (choose.equals("Thống kê người có sức khỏe bất thường")) {
					colName = SucKhoeView.colName;
					ArrayList<SucKhoeInfo> data = thongKeModel.getSucKhoe(startDate, endDate);
					model = new DefaultTableModel();
					model.setColumnIdentifiers(colName);
					for (SucKhoeInfo sucKhoe : data) {
						Object row[]= {
							sucKhoe.getMaKhaiBao(),
							sucKhoe.getHoTen(),
							sucKhoe.getId(),
							sucKhoe.getHo(),
							sucKhoe.getSot(),
							sucKhoe.getKhoTho(),
							sucKhoe.getDauNguoi(),
							sucKhoe.getMatViGiac(),
							sucKhoe.getBuonNon(),
							sucKhoe.getTrieuChungKhac(),
							sucKhoe.getNgayXuatHien()
						};
						
						model.addRow(row);
					}
					thongKeView.setResult(data.size() + " sức khỏe bất thường");
				} 
				else if (choose.equals("Thống kê người có kết quả test covid dương tính")) {
					colName = TestCovidView.colName;
					ArrayList<TestCovidInfo> data = thongKeModel.getTestCovid(startDate, endDate);
					model = new DefaultTableModel();
					model.setColumnIdentifiers(colName);
					for (TestCovidInfo testCovid : data) {
						Object[] row = {
							testCovid.getHoTen(),
							testCovid.getId(),
							testCovid.getMaCode(),
							testCovid.getKetQua(),
							testCovid.getLoaiTest(),
							testCovid.getNgayTest()
						};
						model.addRow(row);
					}
					thongKeView.setResult(data.size() + " lần test covid");
				} 
				else if (choose.equals("Thống kê người đã tiêm vaccine")) {
					colName = TiemVaccineView.colName;
					ArrayList<TiemVaccineInfo> data = thongKeModel.getTiemVaccine(startDate, endDate);
					model = new DefaultTableModel();
					model.setColumnIdentifiers(colName);
					for (TiemVaccineInfo tiemVaccine: data) {
						Object row[] = {
								tiemVaccine.getHoTen(),
								tiemVaccine.getId(),
								tiemVaccine.getLanTiem(),
								tiemVaccine.getLoaiVaccine(),
								tiemVaccine.getLoVaccine(),
								tiemVaccine.getNgayTiem(),
								tiemVaccine.getDonViTiemChung()		
						};
						model.addRow(row);
					}
					thongKeView.setResult(data.size() + " mũi tiêm");
				}
				thongKeView.setTable(model);
			}catch (Exception e) {
				thongKeView.showMessage(e.getMessage());
			}	
		}
	}
	
}
