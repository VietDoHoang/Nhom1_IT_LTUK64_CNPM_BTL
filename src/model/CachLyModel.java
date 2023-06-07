package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import model.entity.CachLyInfo;
import view.CachLyView;

public class CachLyModel {
	CachLyView cachLyView = null; 
	private final String databaseName = "ql_cach_ly";
	//primary key (id, ngay bat dau)
	private final String insertSQL = "INSERT INTO " + databaseName + " VALUE (?, ?, ?, ?, ?)"; 
	private final String updateSQL = "UPDATE " + databaseName + " SET HoTen = ?, Id = ?, NgayBatDau = ?, MucDoCachLy = ?, DiaChiCachLy = ? WHERE Id = ? AND NgayBatDau = ?";
	private final String selectAllSQL = "SELECT * FROM " + databaseName;
	private final String deleteSQL = "DELETE FROM " + databaseName + " WHERE Id = ? AND NgayBatDau = ?";
	
	public CachLyModel(CachLyView cachLyView) {
		this.cachLyView = cachLyView;
	}
	
	public void insert(CachLyInfo cachLy) throws Exception{		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(insertSQL);
//		HoTen	Id	NgayBatDau	MucDoCachLy	DiaChiCachLy
		
		stmt.setString(1, cachLy.getHoTen());
		stmt.setString(2, cachLy.getId());
		stmt.setDate(3, cachLy.getNgayBatDau());
		stmt.setString(4, cachLy.getMucDoCachLy());
		stmt.setString(5, cachLy.getDiaChiCachLy());
				
		try {
			stmt.execute();
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			con.close();
			throw new SQLException("Người có CCCD = " + cachLy.getId() + " đã có dữ liệu cách ly vào ngày " + cachLy.getNgayBatDau());
		}
		con.close();
		cachLyView.setDataForTable(getData(cachLyView.getTextToFind()));
	}
	
	public void update(CachLyInfo cachLy, CachLyInfo cachLyInfoCu) throws Exception{
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(updateSQL);
//		HoTen	Id	NgayBatDau	MucDoCachLy	DiaChiCachLy
		stmt.setString(1, cachLy.getHoTen());
		stmt.setString(2, cachLy.getId());
		stmt.setDate(3, cachLy.getNgayBatDau());
		stmt.setString(4, cachLy.getMucDoCachLy());
		stmt.setString(5, cachLy.getDiaChiCachLy());
		stmt.setString(6, cachLyInfoCu.getId());
		stmt.setDate(7, cachLyInfoCu.getNgayBatDau());
		
		try {
			stmt.execute();
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			con.close();
			throw new SQLException("Người có CCCD = " + cachLy.getId() + " đã có dữ liệu cách ly vào ngày " + cachLy.getNgayBatDau());
		}
		con.close();
		cachLyView.setDataForTable(getData(cachLyView.getTextToFind()));
	}
	
	public void delete(CachLyInfo cachLy) throws Exception {
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(deleteSQL);
		stmt.setString(1, cachLy.getId() );
		stmt.setDate(2, cachLy.getNgayBatDau());
		stmt.execute();
		con.close();
		cachLyView.setDataForTable(getData(cachLyView.getTextToFind()));
	}
	
	public ArrayList<CachLyInfo> getData(String condition) throws Exception{
		String query = selectAllSQL;
		if (!condition.equals("")) query = selectAllSQL + " WHERE Id LIKE ? OR HoTen LIKE ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
//		HoTen	Id	NgayBatDau	MucDoCachLy	DiaChiCachLy
		if (!condition.equals("")) {
			condition = "%" + condition + "%";
			stmt.setString(1, condition);
			stmt.setString(2, condition);
		}
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
	

}
