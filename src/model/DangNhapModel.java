package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.entity.DangNhapInfo;

public class DangNhapModel {	
	private static final String databaseName = "dang_nhap";
	public DangNhapModel() {
	}
	public DangNhapInfo getUser(String username, String password) throws Exception {
		String query = "SELECT * FROM "+ databaseName + " WHERE username = ?";
		Connection con = SQLConnector.getCon();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		DangNhapInfo user = new DangNhapInfo();
		
		if (rs.next()) {
			if (!password.equals(rs.getString("password"))) {
				con.close();
				return null;
			}
			user.setUsername(username);
			user.setQLCachLy(rs.getString("QLCachLy"));
			user.setQLKhaiBao(rs.getString("QLKhaiBao"));
			user.setQLNhanKhau(rs.getString("QLNhanKhau"));
			user.setQLSucKhoe(rs.getString("QLSucKhoe"));
			user.setQLTestCovid(rs.getString("QLTestCovid"));
			user.setQLTiemVaccine(rs.getString("QLTiemVaccine"));
			user.setThongKe(rs.getString("ThongKeCovid"));
			con.close();
			return user;
		}
		else {
			con.close();
			return null;
		}
	}

}
