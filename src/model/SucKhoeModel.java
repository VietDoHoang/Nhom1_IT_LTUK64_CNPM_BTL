package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.SucKhoeInfo;
import view.SucKhoeView;

public class SucKhoeModel {
	SucKhoeView sucKhoeView = null; 
	private static final String databaseName = "ql_suc_khoe";
//	MaKhaiBao HoTen	Id	Ho	Sot	KhoTho	DauNguoi	MatViGiac	BuonNon	TrieuChungKhac	NgayXuatHien
//	primary key (maKhaiBao)
	private final String insertSQL = "INSERT INTO " + databaseName + "(HoTen, Id, Ho, Sot, KhoTho, DauNguoi, MatViGiac, BuonNon, TrieuChungKhac, NgayXuatHien) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
	private final String updateSQL = "UPDATE " + databaseName + " SET HoTen = ?, Id = ?, Ho = ?, Sot = ?, KhoTho = ?, DauNguoi = ?, MatViGiac = ?, BuonNon = ?, TrieuChungKhac = ?, NgayXuatHien = ? WHERE MaKhaiBao = ?";
	private final String selectAllSQL = "SELECT * FROM " + databaseName;
	private final String deleteSQL = "DELETE FROM " + databaseName + " WHERE MaKhaiBao = ?";
	
	public SucKhoeModel(SucKhoeView sucKhoeView) {
		this.sucKhoeView = sucKhoeView;
	}
	
	public void insert(SucKhoeInfo sucKhoeInfo) throws Exception{	
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(insertSQL);
		//STT HoTen	Id	Ho	Sot	KhoTho	DauNguoi	MatViGiac	BuonNon	TrieuChungKhac	NgayXuatHien
		stmt.setString(1, sucKhoeInfo.getHoTen());
		stmt.setString(2, sucKhoeInfo.getId());
		stmt.setString(3, sucKhoeInfo.getHo());
		stmt.setString(4, sucKhoeInfo.getSot());
		stmt.setString(5, sucKhoeInfo.getKhoTho());
		stmt.setString(6, sucKhoeInfo.getDauNguoi());
		stmt.setString(7, sucKhoeInfo.getMatViGiac());
		stmt.setString(8, sucKhoeInfo.getBuonNon());
		stmt.setString(9, sucKhoeInfo.getTrieuChungKhac());
		stmt.setDate(10, sucKhoeInfo.getNgayXuatHien());
		
		stmt.execute();
		
		con.close();
		sucKhoeView.setDataForTable(getData(sucKhoeView.getTextToFind()));
	}
	
	public void update(SucKhoeInfo sucKhoeMoi, SucKhoeInfo sucKhoeCu) throws Exception{
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(updateSQL);
		//MaKhaiBao HoTen	Id	Ho	Sot	KhoTho	DauNguoi	MatViGiac	BuonNon	TrieuChungKhac	NgayXuatHien
		
		stmt.setString(1, sucKhoeMoi.getHoTen());
		stmt.setString(2, sucKhoeMoi.getId());
		stmt.setString(3, sucKhoeMoi.getHo());
		stmt.setString(4, sucKhoeMoi.getSot());
		stmt.setString(5, sucKhoeMoi.getKhoTho());
		stmt.setString(6, sucKhoeMoi.getDauNguoi());
		stmt.setString(7, sucKhoeMoi.getMatViGiac());
		stmt.setString(8, sucKhoeMoi.getBuonNon());
		stmt.setString(9, sucKhoeMoi.getTrieuChungKhac());
		stmt.setDate(10, sucKhoeMoi.getNgayXuatHien());
		stmt.setInt(11, sucKhoeCu.getMaKhaiBao());
		stmt.execute();
		con.close();
		sucKhoeView.setDataForTable(getData(sucKhoeView.getTextToFind()));
	}
	
	public void delete(SucKhoeInfo sucKhoeInfo) throws Exception {
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(deleteSQL);
		stmt.setInt(1, sucKhoeInfo.getMaKhaiBao());
		stmt.execute();
		con.close();
		sucKhoeView.setDataForTable(getData(sucKhoeView.getTextToFind()));
	}
	
	public ArrayList<SucKhoeInfo> getData(String condition) throws Exception{
		String query = selectAllSQL;
		if (!condition.equals("")) query = selectAllSQL + " WHERE Id LIKE ? OR HoTen LIKE ? OR MaKhaiBao LIKE ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
		//	STT HoTen	Id	Ho	Sot	KhoTho	DauNguoi	MatViGiac	BuonNon	TrieuChungKhac	NgayXuatHien
		if (!condition.equals("")) {
			condition = "%" + condition + "%";
			stmt.setString(1, condition);
			stmt.setString(2, condition);
			stmt.setString(3, condition);
		}
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

}
