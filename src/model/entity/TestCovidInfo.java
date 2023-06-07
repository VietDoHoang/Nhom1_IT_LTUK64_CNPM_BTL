package model.entity;

import java.sql.Date;

public class TestCovidInfo extends NhanKhauInfo{
	private String maCode = null;
	private String ketQua = null;
	private String loaiTest = null;
	private Date ngayTest = null;
	
	public TestCovidInfo(NhanKhauInfo nhanKhauInfo, String maCode, String ketQua, String loaiTest, String ngayTest)
			throws Exception {
		super(nhanKhauInfo);
		setMaCode(maCode);
		setKetQua(ketQua);
		setLoaiTest(loaiTest);
		setNgayTest(ngayTest);
	}
	
	public String getMaCode() {
		return maCode;
	}
	public String getKetQua() {
		return ketQua;
	}
	public String getLoaiTest() {
		return loaiTest;
	}
	public Date getNgayTest() {
		return ngayTest;
	}
	public void setMaCode(String maCode) {
		this.maCode = maCode;
	}
	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}
	public void setLoaiTest(String loaiTest) {
		this.loaiTest = loaiTest;
	}
	public void setNgayTest(String ngayTest) throws Exception {
		Date date = null;
		String[] d = ngayTest.split("[^0-9]");
		if (d.length != 3) throw new Exception("Sai định dạng (yyyy/MM/dd)");
		try {
			date = Date.valueOf(d[0] + "-" + d[1] + "-" + d[2]);
		} catch (Exception e) {
			throw new Exception("Ngày không hợp lệ (yyyy/MM/dd)");
		}
		this.ngayTest = date;
	}
}
