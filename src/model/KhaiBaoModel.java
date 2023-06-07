package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.KhaiBaoInfo;
import view.KhaiBaoView;


public class KhaiBaoModel {
	KhaiBaoView khaiBaoView = null; 
	private static final String databaseName = "ql_khai_bao";
//	MaKhaiBao	HoTen	Id	TiepXucVoiNguoiBenh	DiVeTuVungDich	TiepXucVoiNguoiTuVungDich	
//	primary key (maKhaiBao)
	private final String insertSQL = "INSERT INTO " + databaseName + "(HoTen, Id, TiepXucVoiNguoiBenh, DiVeTuVungDich, TiepXucVoiNguoiTuVungDich, NgayKhaiBao) VALUE (?, ?, ?, ?, ?, ?)"; 
	private final String updateSQL = "UPDATE " + databaseName + " SET HoTen = ?, Id = ?, TiepXucVoiNguoiBenh = ?, DiVeTuVungDich = ?, TiepXucVoiNguoiTuVungDich = ?, NgayKhaiBao = ? WHERE MaKhaiBao = ?";
	private final String selectAllSQL = "SELECT * FROM " + databaseName;
	private final String deleteSQL = "DELETE FROM " + databaseName + " WHERE MaKhaiBao = ?";
	
	public KhaiBaoModel(KhaiBaoView khaiBaoView) {
		this.khaiBaoView = khaiBaoView;
	}
	
	public void insert(KhaiBaoInfo khaiBaoInfo) throws Exception{		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(insertSQL);
		//	MaKhaiBao	HoTen	Id	TiepXucVoiNguoiBenh	DiVeTuVungDich	TiepXucVoiNguoiTuVungDich NgayKhaiBao
		stmt.setString(1, khaiBaoInfo.getHoTen());
		stmt.setString(2, khaiBaoInfo.getId());
		stmt.setString(3, khaiBaoInfo.getTiepXucVoiNguoiBenh());
		stmt.setString(4, khaiBaoInfo.getDiVeTuVungDich());
		stmt.setString(5, khaiBaoInfo.getTiepXucVoiNguoiTuVungDich());
		stmt.setDate(6, khaiBaoInfo.getNgayKhaiBao());	
		stmt.execute();
		con.close();
		khaiBaoView.setDataForTable(getData(khaiBaoView.getTextToFind()));
	}
	
	public void update(KhaiBaoInfo khaiBaoMoi, KhaiBaoInfo khaiBaoCu) throws Exception{
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(updateSQL);
		//	MaKhaiBao	HoTen	Id	TiepXucVoiNguoiBenh	DiVeTuVungDich	TiepXucVoiNguoiTuVungDich NgayKhaiBao	
		
		stmt.setString(1, khaiBaoMoi.getHoTen());
		stmt.setString(2, khaiBaoMoi.getId());
		stmt.setString(3, khaiBaoMoi.getTiepXucVoiNguoiBenh());
		stmt.setString(4, khaiBaoMoi.getDiVeTuVungDich());
		stmt.setString(5, khaiBaoMoi.getTiepXucVoiNguoiTuVungDich());
		stmt.setDate(6, khaiBaoMoi.getNgayKhaiBao());	
		stmt.setInt(7, khaiBaoCu.getMaKhaiBao());
		stmt.execute();
		con.close();
		khaiBaoView.setDataForTable(getData(khaiBaoView.getTextToFind()));
	}
	
	public void delete(KhaiBaoInfo khaiBaoInfo) throws Exception {
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(deleteSQL);
		stmt.setInt(1, khaiBaoInfo.getMaKhaiBao());
		stmt.execute();
		con.close();
		khaiBaoView.setDataForTable(getData(khaiBaoView.getTextToFind()));
	}
	
	public ArrayList<KhaiBaoInfo> getData(String condition) throws Exception{
		String query = selectAllSQL;
		if (!condition.equals("")) query = selectAllSQL + " WHERE Id LIKE ? OR HoTen LIKE ? OR MaKhaiBao LIKE ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
		if (!condition.equals("")) {
			condition = "%" + condition + "%";
			stmt.setString(1, condition);
			stmt.setString(2, condition);
			stmt.setString(3, condition);
		}
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

}
