package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import model.entity.NhanKhauInfo;
import view.NhanKhauView;

public class NhanKhauModel {
	
	private NhanKhauView nhanKhauView = null; 
	private final static String databaseName = "ql_nhan_khau";
	// HoTen Id	GioiTinh NgaySinh SoDienThoai SoTheBHYT Email QuocTich ThuongTruTamTru
	//primary key (hoTen, id)
	private final String insertSQL = "INSERT INTO " + databaseName + " VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
	private final String updateSQL = "UPDATE " + databaseName + " SET HoTen = ?, Id = ?, GioiTinh = ?, NgaySinh = ?, SoDienThoai = ?, SoTheBHYT = ?, Email = ?, QuocTich = ?, ThuongTruTamTru = ? WHERE Id = ?";
	private final String selectAllSQL = "SELECT * FROM " + databaseName;
	private final String deleteSQL = "DELETE FROM " + databaseName + " WHERE Id = ?";
	
	public NhanKhauModel(NhanKhauView nhanKhauView) {
		this.nhanKhauView = nhanKhauView;
	}
	
	public void insert(NhanKhauInfo nhanKhau) throws Exception{
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(insertSQL);
		// HoTen Id	GioiTinh NgaySinh SoDienThoai SoTheBHYT Email QuocTich ThuongTruTamTru
		
		stmt.setString(1, nhanKhau.getHoTen());
		stmt.setString(2, nhanKhau.getId());
		stmt.setString(3, nhanKhau.getGioiTinh());
		stmt.setDate(4, nhanKhau.getNgaySinh());
		stmt.setString(5, nhanKhau.getSoDienThoai());
		stmt.setString(6, nhanKhau.getSoTheBHYT());
		stmt.setString(7, nhanKhau.getEmail());
		stmt.setString(8, nhanKhau.getQuocTich());
		stmt.setString(9, nhanKhau.getThuongTruTamTru());
		
		try{
			stmt.execute();
		}catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			throw new Exception("Đã tồn tại nhân khẩu có CCCD là " + nhanKhau.getId());
		}
		con.close();
		nhanKhauView.setDataForTable(getData(nhanKhauView.getTextToFind()));
	}
	
	public void update(NhanKhauInfo nhanKhauMoi, NhanKhauInfo nhanKhauCu) throws Exception{
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(updateSQL);
		// HoTen Id	GioiTinh NgaySinh SoDienThoai SoTheBHYT Email QuocTich ThuongTruTamTru
		stmt.setString(1, nhanKhauMoi.getHoTen());
		stmt.setString(2, nhanKhauMoi.getId());
		stmt.setString(3, nhanKhauMoi.getGioiTinh());
		stmt.setDate(4, nhanKhauMoi.getNgaySinh());
		stmt.setString(5, nhanKhauMoi.getSoDienThoai());
		stmt.setString(6, nhanKhauMoi.getSoTheBHYT());
		stmt.setString(7, nhanKhauMoi.getEmail());
		stmt.setString(8, nhanKhauMoi.getQuocTich());
		stmt.setString(9, nhanKhauMoi.getThuongTruTamTru());
		stmt.setString(10, nhanKhauCu.getId());
		
		try{
			stmt.execute();
		}catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			throw new Exception("Đã tồn tại nhân khẩu có CCCD là " + nhanKhauMoi.getId());
		}
		
		con.close();
		nhanKhauView.setDataForTable(getData(nhanKhauView.getTextToFind()));
	}
	
	public void delete(NhanKhauInfo nhanKhau) throws Exception {
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(deleteSQL);
		stmt.setString(1, nhanKhau.getId());
		stmt.execute();
		con.close();
		nhanKhauView.setDataForTable(getData(nhanKhauView.getTextToFind()));
	}
	
	public ArrayList<NhanKhauInfo> getData(String condition) throws Exception{
		String query = selectAllSQL;
		if (!condition.equals("")) query = selectAllSQL + " WHERE Id LIKE ? OR HoTen LIKE ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
		if (!condition.equals("")) {
			condition = "%" + condition + "%";
			stmt.setString(1, condition);
			stmt.setString(2, condition);
		}
		ResultSet rs = stmt.executeQuery();
		ArrayList<NhanKhauInfo> data = new ArrayList<>();
		while (rs.next()) {
			// HoTen Id	GioiTinh NgaySinh SoDienThoai SoTheBHYT Email QuocTich ThuongTruTamTru
			NhanKhauInfo nhanKhau = new NhanKhauInfo(
					rs.getString("HoTen"),
					rs.getString("Id"),
					rs.getString("GioiTinh"),
					rs.getDate("NgaySinh").toString(),
					rs.getString("SoDienThoai"),
					rs.getString("SoTheBHYT"),
					rs.getString("Email"),
					rs.getString("QuocTich"),
					rs.getString("ThuongTruTamTru"));
			data.add(nhanKhau);
		}
		con.close();
		return data;
	}
	
	public static NhanKhauInfo getNhanKhau(String id, String hoTen) throws Exception{
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM " + databaseName + " WHERE Id = ?");
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			if (!rs.getString("HoTen").equals(hoTen)) throw new Exception("Nhân khẩu có mã CCCD = " + id + " tên là " + rs.getString("HoTen"));
			return new NhanKhauInfo(rs.getString("HoTen"),
					rs.getString("Id"),
					rs.getString("GioiTinh"),
					rs.getDate("NgaySinh").toString(),
					rs.getString("SoDienThoai"),
					rs.getString("SoTheBHYT"),
					rs.getString("Email"),
					rs.getString("QuocTich"),
					rs.getString("ThuongTruTamTru"));
		}
			
		throw new Exception("Không tồn tại người có CCCD = " + id + " trong CSDL nhân khẩu");
	}

}
