package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import model.entity.TestCovidInfo;
import view.TestCovidView;

public class TestCovidModel {
	TestCovidView testCovidView = null; 
	private static final String databaseName = "ql_test_covid";
//	HoTen	Id MaCoe KetQua	LoaiTest	NgayTest
//	primary key (MaCode)
	private final String insertSQL = "INSERT INTO " + databaseName + " VALUE (?, ?, ?, ?, ?, ?)"; 
	private final String updateSQL = "UPDATE " + databaseName + " SET HoTen = ?, Id = ?, MaCode = ?, KetQua = ?, LoaiTest = ?, NgayTest = ? WHERE MaCode = ?";
	private final String selectAllSQL = "SELECT * FROM " + databaseName;
	private final String deleteSQL = "DELETE FROM " + databaseName + " WHERE MaCode = ?";
	
	public TestCovidModel(TestCovidView testCovidView) {
		this.testCovidView = testCovidView;
	}
	
	public void insert(TestCovidInfo testCovidInfo) throws Exception{
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(insertSQL);
		//HoTen	Id MaCoe KetQua	LoaiTest	NgayTest
		
		stmt.setString(1, testCovidInfo.getHoTen());
		stmt.setString(2, testCovidInfo.getId());
		stmt.setString(3, testCovidInfo.getMaCode());
		stmt.setString(4, testCovidInfo.getKetQua());
		stmt.setString(5, testCovidInfo.getLoaiTest());
		stmt.setDate(6, testCovidInfo.getNgayTest());	
		
		try {
			stmt.execute();
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			con.close();
			throw new SQLException("Mã code " + testCovidInfo.getMaCode() + " đã tồn tại" );
		}
		
		con.close();
		testCovidView.setDataForTable(getData(testCovidView.getTextToFind()));
	}
	
	public void update(TestCovidInfo testCovidInfo, TestCovidInfo testCovidInfoCu) throws Exception{
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(updateSQL);
//		HoTen Id MaCode KetQua	LoaiTest NgayTest	
		
		stmt.setString(1, testCovidInfo.getHoTen());
		stmt.setString(2, testCovidInfo.getId());
		stmt.setString(3, testCovidInfo.getMaCode());
		stmt.setString(4, testCovidInfo.getKetQua());
		stmt.setString(5, testCovidInfo.getLoaiTest());
		stmt.setDate(6, testCovidInfo.getNgayTest());	
		stmt.setString(7, testCovidInfoCu.getMaCode());
		try {
			stmt.execute();
		} catch (Exception e){
			con.close();
			throw new SQLException("Mã code " + testCovidInfo.getMaCode() + " đã tồn tại" );
		}
		con.close();
		testCovidView.setDataForTable(getData(testCovidView.getTextToFind()));
	}
	
	public void delete(TestCovidInfo testCovidInfo) throws Exception {
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(deleteSQL);
		stmt.setString(1, testCovidInfo.getMaCode());
		stmt.execute();
		con.close();
		testCovidView.setDataForTable(getData(testCovidView.getTextToFind()));
	}
	
	public ArrayList<TestCovidInfo> getData(String condition) throws Exception{
		String query = selectAllSQL;
		if (!condition.equals("")) query = selectAllSQL + " WHERE Id LIKE ? OR HoTen LIKE ? OR MaCode LIKE ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
//		HoTen	Id	KetQua	LoaiTest	NgayTest	
		if (!condition.equals("")) {
			condition = "%" + condition + "%";
			stmt.setString(1, condition);
			stmt.setString(2, condition);
			stmt.setString(3, condition);
		}
		ResultSet rs = stmt.executeQuery();
		ArrayList<TestCovidInfo> data = new ArrayList<>();
		while (rs.next()) {
//			HoTen	Id MaCode KetQua	LoaiTest	NgayTest	
			TestCovidInfo testCovid = new TestCovidInfo(
				NhanKhauModel.getNhanKhau(rs.getString("Id"), rs.getString("HoTen")),
				rs.getString("MaCode"),
				rs.getString("KetQua"),
				rs.getString("LoaiTest"),
				rs.getDate("NgayTest").toString()
			);
			data.add(testCovid);
		}
		con.close();
		return data;
	}
	
	public static ArrayList<TestCovidInfo> getTestCovidData(String id, Date startDate) throws Exception {
		String query = "SELECT * FROM " + databaseName + " WHERE Id = ? AND NgayTest >= ?";
		
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
//		HoTen	Id	KetQua	LoaiTest	NgayTest
		stmt.setString(1, id);
		stmt.setDate(2, startDate);
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
