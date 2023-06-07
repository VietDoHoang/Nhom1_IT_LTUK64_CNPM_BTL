package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.CachLyInfo;
import model.entity.KhaiBaoInfo;
import model.entity.SucKhoeInfo;
import model.entity.TestCovidInfo;
import model.entity.TiemVaccineInfo;

public class ThongKeModel {
	
	public ThongKeModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<TiemVaccineInfo> getTiemVaccine(Date startDate, Date endDate) throws Exception{
		String query = "SELECT * FROM ql_tiem_vaccine WHERE NgayTiem >= ? AND NgayTiem <= ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setDate(1, startDate);
		stmt.setDate(2, endDate);
		ResultSet rs = stmt.executeQuery();
		ArrayList<TiemVaccineInfo> data = new ArrayList<>();
		while (rs.next()) {
			TiemVaccineInfo tiemVaccine = new TiemVaccineInfo(
				NhanKhauModel.getNhanKhau(rs.getString("Id"), rs.getString("HoTen")),
				rs.getInt("LanTiem"),
				rs.getString("LoaiVaccine"),
				rs.getString("LoVaccine"),
				rs.getDate("NgayTiem").toString(),
				rs.getString("DonViTiemChung")
			);
			data.add(tiemVaccine);
		}
		con.close();
		return data;
	}
	public ArrayList<CachLyInfo> getCachLy(Date startDate, Date endDate) throws Exception{
		String query = "SELECT * FROM ql_cach_ly WHERE NgayBatDau >= ? AND NgayBatDau <= ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setDate(1, startDate);
		stmt.setDate(2, endDate);
		ResultSet rs = stmt.executeQuery();
		ArrayList<CachLyInfo> data = new ArrayList<>();
		while (rs.next()) {
			CachLyInfo cachLy = new CachLyInfo(
				NhanKhauModel.getNhanKhau(rs.getString("Id"), rs.getString("HoTen")),				
				rs.getString("NgayBatDau"),
				rs.getString("MucDoCachLy"),
				rs.getString("DiaChiCachLy")
			);
			data.add(cachLy);
		}
		con.close();
		return data;
	}
	
	
	public ArrayList<KhaiBaoInfo> getKhaiBao(Date startDate, Date endDate) throws Exception{
		String query = "SELECT * FROM ql_khai_bao WHERE NgayKhaiBao >= ? AND NgayKhaiBao <= ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setDate(1, startDate);
		stmt.setDate(2, endDate);
		ResultSet rs = stmt.executeQuery();
		ArrayList<KhaiBaoInfo> data = new ArrayList<>();
		while (rs.next()) {
			//	MaKhaiBao	HoTen	Id	TiepXucVoiNguoiBenh	DiVeTuVungDich	TiepXucVoiNguoiTuVungDich NgayKhaiBao	
			KhaiBaoInfo khaiBao = new KhaiBaoInfo(
				NhanKhauModel.getNhanKhau(rs.getString("Id"), rs.getString("HoTen")),
				rs.getInt("MaKhaiBao"),
				rs.getString("TiepXucVoiNguoiBenh"),
				rs.getString("DiVeTuVungDich"),
				rs.getString("TiepXucVoiNguoiTuVungDich"),
				rs.getDate("NgayKhaiBao").toString()
			);
			data.add(khaiBao);
		}
		con.close();
		return data;
	}
	
	public ArrayList<SucKhoeInfo> getSucKhoe(Date startDate, Date endDate) throws Exception{
		String query = "SELECT * FROM ql_suc_khoe WHERE NgayXuatHien >= ? AND NgayXuatHien <= ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setDate(1, startDate);
		stmt.setDate(2, endDate);
		ResultSet rs = stmt.executeQuery();
		ArrayList<SucKhoeInfo> data = new ArrayList<>();
		while (rs.next()) {
			//MaKhaiBao HoTen	Id	Ho	Sot	KhoTho	DauNguoi	MatViGiac	BuonNon	TrieuChungKhac	NgayXuatHien	
			SucKhoeInfo sucKhoe = new SucKhoeInfo(
				NhanKhauModel.getNhanKhau(rs.getString("Id"), rs.getString("HoTen")),
				rs.getInt("MaKhaiBao"),
				rs.getString("Ho"),
				rs.getString("Sot"),
				rs.getString("KhoTho"),
				rs.getString("DauNguoi"),
				rs.getString("MatViGiac"),
				rs.getString("BuonNon"),
				rs.getString("TrieuChungKhac"),
				rs.getDate("NgayXuatHien").toString()
			);
			
			data.add(sucKhoe);
		}
		con.close();
		return data;
	}
	
	public ArrayList<TestCovidInfo> getTestCovid(Date startDate, Date endDate) throws Exception {
		String query = "SELECT * FROM ql_test_covid WHERE NgayTest >= ? AND NgayTest <= ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setDate(1, startDate);
		stmt.setDate(2, endDate);
		ResultSet rs = stmt.executeQuery();
		ArrayList<TestCovidInfo> data = new ArrayList<>();
		while (rs.next()) {
//			HoTen	Id	MaCode KetQua	LoaiTest	NgayTest	
			TestCovidInfo testcovid = new TestCovidInfo(
				NhanKhauModel.getNhanKhau(rs.getString("Id"), rs.getString("HoTen")),
				rs.getString("MaCode"),
				rs.getString("KetQua"),
				rs.getString("LoaiTest"),
				rs.getDate("NgayTest").toString()
			);
			
			data.add(testcovid);
		}
		con.close();
		return data;
	}
}
