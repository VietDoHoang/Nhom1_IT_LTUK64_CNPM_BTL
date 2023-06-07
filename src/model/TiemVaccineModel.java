package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import model.entity.TiemVaccineInfo;
import view.TiemVaccineView;

public class TiemVaccineModel {
	TiemVaccineView tiemVaccineView = null; 
	private final String databaseName = "ql_tiem_vaccine";
	private final String insertSQL = "INSERT INTO " + databaseName + " VALUE (?, ?, ?, ?, ?, ?, ?)"; 
	private final String updateSQL = "UPDATE " + databaseName + " SET HoTen = ?, Id = ?, LanTiem = ?, LoaiVaccine = ?, LoVaccine = ?, NgayTiem = ?, DonViTiemChung = ? WHERE Id = ? AND LanTiem = ?";
	private final String selectAllSQL = "SELECT * FROM " + databaseName;
	private final String deleteSQL = "DELETE FROM " + databaseName + " WHERE Id = ? AND LanTiem = ?";
//	HoTen	Id	LanTiem	LoaiVaccine	LoVaccine	NgayTiem	DonViTiemChung
	// primary key (id, lanTiem)
	public TiemVaccineModel(TiemVaccineView tiemVaccineView) {
		this.tiemVaccineView = tiemVaccineView;
	}
	
	public void insert(TiemVaccineInfo tiemVaccineInfo) throws Exception{	
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(insertSQL);
//		HoTen	Id	LanTiem	LoaiVaccine	LoVaccine	NgayTiem	DonViTiemChung
		stmt.setString(1, tiemVaccineInfo.getHoTen());
		stmt.setString(2, tiemVaccineInfo.getId());
		stmt.setInt(3, tiemVaccineInfo.getLanTiem());
		stmt.setString(4, tiemVaccineInfo.getLoaiVaccine());
		stmt.setString(5, tiemVaccineInfo.getLoVaccine());
		stmt.setDate(6, tiemVaccineInfo.getNgayTiem());
		stmt.setString(7, tiemVaccineInfo.getDonViTiemChung());
		
		try {
			stmt.execute();
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			con.close();
			throw new SQLException(tiemVaccineInfo.getHoTen() + " (CCCD = " + tiemVaccineInfo.getId() + ") đã tiêm mũi " + tiemVaccineInfo.getLanTiem());
		}
		con.close();
		tiemVaccineView.setDataForTable(getData(tiemVaccineView.getTextToFind()));
	}
	
	public void update(TiemVaccineInfo tiemVaccineInfo, TiemVaccineInfo tiemVaccineCu) throws Exception{
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(updateSQL);
//		HoTen	Id	LanTiem	LoaiVaccine	LoVaccine	NgayTiem	DonViTiemChung
		stmt.setString(1, tiemVaccineInfo.getHoTen());
		stmt.setString(2, tiemVaccineInfo.getId());
		stmt.setInt(3, tiemVaccineInfo.getLanTiem());
		stmt.setString(4, tiemVaccineInfo.getLoaiVaccine());
		stmt.setString(5, tiemVaccineInfo.getLoVaccine());
		stmt.setDate(6, tiemVaccineInfo.getNgayTiem());
		stmt.setString(7, tiemVaccineInfo.getDonViTiemChung());
		stmt.setString(8, tiemVaccineCu.getId());
		stmt.setInt(9, tiemVaccineCu.getLanTiem());
		try {
			stmt.execute();
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			con.close();
			throw new SQLException(tiemVaccineInfo.getHoTen() + " (CCCD = " + tiemVaccineInfo.getId() + ") đã tiêm mũi " + tiemVaccineInfo.getLanTiem());
		}
		con.close();
		tiemVaccineView.setDataForTable(getData(tiemVaccineView.getTextToFind()));
	}
	
	public void delete(TiemVaccineInfo tiemVaccineInfo) throws Exception {
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(deleteSQL);
		stmt.setString(1, tiemVaccineInfo.getId());
		stmt.setInt(2, tiemVaccineInfo.getLanTiem());
		stmt.execute();
		con.close();
		tiemVaccineView.setDataForTable(getData(tiemVaccineView.getTextToFind()));
	}
	
	public ArrayList<TiemVaccineInfo> getData(String condition) throws Exception{
		String query = selectAllSQL;
		if (!condition.equals("")) query = selectAllSQL + " WHERE Id LIKE ? OR HoTen LIKE ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
//		HoTen	Id	LanTiem	LoaiVaccine	LoVaccine	NgayTiem	DonViTiemChung
		if (!condition.equals("")) {
			condition = "%" + condition + "%";
			stmt.setString(1, condition);
			stmt.setString(2, condition);
		}
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
}
