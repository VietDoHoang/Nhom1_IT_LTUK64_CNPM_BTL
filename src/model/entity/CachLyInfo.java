package model.entity;

import java.sql.Date;
import java.util.ArrayList;

import model.TestCovidModel;

public class CachLyInfo extends NhanKhauInfo{
	private Date ngayBatDau = null;
	private String mucDoCachLy = null;
	private String diaChiCachLy = null;
	private ArrayList<TestCovidInfo> testCovid= null;
	public CachLyInfo(NhanKhauInfo nhanKhauInfo, String ngayBatDau, String mucDoCachLy, String diaChiCachLy) throws Exception {
		super(nhanKhauInfo);
		setNgayBatDau(ngayBatDau);
		setMucDoCachLy(mucDoCachLy);
		this.diaChiCachLy = diaChiCachLy;
		testCovid = TestCovidModel.getTestCovidData(getId(), getNgayBatDau());
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public String getMucDoCachLy() {
		return mucDoCachLy;
	}
	public String getDiaChiCachLy() {
		return diaChiCachLy;
	}
	public ArrayList<TestCovidInfo> getTestCovid() {
		return testCovid;
	}
	public void setNgayBatDau(String ngayBatDau) throws Exception {
		Date date = null;
		String[] d = ngayBatDau.split("[^0-9]");
		if (d.length != 3) throw new Exception("Sai định dạng (yyyy/MM/dd)");
		try {
			date = Date.valueOf(d[0] + "-" + d[1] + "-" + d[2]);
		} catch (Exception e) {
			throw new Exception("Ngày không hợp lệ (yyyy/MM/dd)");
		}
		this.ngayBatDau = date;
	}
	public void setMucDoCachLy(String mucDoCachLy) throws Exception {
		if (mucDoCachLy.charAt(0) != 'f' && mucDoCachLy.charAt(0) != 'F') {
			throw new Exception("Sai định dạng (F1, F2, F3...)");
		}
		mucDoCachLy = mucDoCachLy.substring(1);
		try {
			this.mucDoCachLy = "F" + Integer.parseInt(mucDoCachLy);
		} catch (Exception e) {
			throw new Exception("Sai định dạng (F1, F2, F3...)");
		}
	}
	public void setDiaChiCachLy(String diaChiCachLy) {
		this.diaChiCachLy = diaChiCachLy;
	}
	public void setTestCovid(ArrayList<TestCovidInfo> testCovid) {
		this.testCovid = testCovid;
	}

}
