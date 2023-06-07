package model.entity;

import java.sql.Date;

public class TiemVaccineInfo extends NhanKhauInfo {
	private int lanTiem;
	private Date ngayTiem;
	private String loaiVaccine;
	private String loVaccine;
	private String donViTiemChung;
	
	
	
	public TiemVaccineInfo(NhanKhauInfo nhanKhauInfo, int lanTiem, String loaiVaccine, String loVaccine, String ngayTiem,
			String donViTiemChung) throws Exception {
		super(nhanKhauInfo);
		this.lanTiem = lanTiem;
		setNgayTiem(ngayTiem);
		this.loaiVaccine = loaiVaccine;
		this.loVaccine = loVaccine;
		this.donViTiemChung = donViTiemChung;
	}
	public int getLanTiem() {
		return lanTiem;
	}
	public Date getNgayTiem() {
		return ngayTiem;
	}
	public String getLoaiVaccine() {
		return loaiVaccine;
	}
	public String getLoVaccine() {
		return loVaccine;
	}
	public String getDonViTiemChung() {
		return donViTiemChung;
	}
	public void setLanTiem(int lanTiem) {
		this.lanTiem = lanTiem;
	}
	public void setNgayTiem(String ngayTiem) throws Exception {
		Date date = null;
		String[] d = ngayTiem.split("[^0-9]");
		if (d.length != 3) throw new Exception("Sai định dạng (yyyy/MM/dd)");
		try {
			date = Date.valueOf(d[0] + "-" + d[1] + "-" + d[2]);
		} catch (Exception e) {
			throw new Exception("Ngày không hợp lệ (yyyy/MM/dd)");
		}
		this.ngayTiem = date;
	}
	public void setLoaiVaccine(String loaiVaccine) {
		this.loaiVaccine = loaiVaccine;
	}
	public void setLoVaccine(String loVaccine) {
		this.loVaccine = loVaccine;
	}
	public void setDonViTiemChung(String donViTiemChung) {
		this.donViTiemChung = donViTiemChung;
	}
	
	
}
