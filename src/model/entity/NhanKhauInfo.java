package model.entity;

import java.sql.Date;

public class NhanKhauInfo {
	private String hoTen = null;
	private String id = null;
	private String gioiTinh = null;
	private Date ngaySinh = null;
	private String soDienThoai = null;
	private String soTheBHYT = null;
	private String email = null;
	private String quocTich = null;
	private String thuongTruTamTru = null;
	
	public NhanKhauInfo(String hoTen, String id, String gioiTinh, String ngaySinh, String soDienThoai, String soTheBHYT, 
			String email, String quocTich, String thuongTruTamTru) throws Exception {
		setHoTen(hoTen);
		setId(id);;
		setGioiTinh(gioiTinh);
		setNgaySinh(ngaySinh);
		setSoDienThoai(soDienThoai);
		setSoTheBHYT(soTheBHYT);
		setEmail(email);
		setQuocTich(quocTich);
		setThuongTruTamTru(thuongTruTamTru);
	}
	
	public NhanKhauInfo(NhanKhauInfo nhanKhauInfo) {
		this.hoTen = nhanKhauInfo.hoTen;
		this.id = nhanKhauInfo.id;
		this.gioiTinh = nhanKhauInfo.gioiTinh;
		this.ngaySinh = nhanKhauInfo.ngaySinh;
		this.soDienThoai = nhanKhauInfo.soDienThoai;
		this.soTheBHYT = nhanKhauInfo.soTheBHYT;
		this.email = nhanKhauInfo.email;
		this.quocTich = nhanKhauInfo.quocTich;
		this.thuongTruTamTru = nhanKhauInfo.thuongTruTamTru;
	}

	public String getHoTen() {
		return hoTen;
	}
	public String getId() {
		return id;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public String getSoTheBHYT() {
		return soTheBHYT;
	}
	public String getEmail() {
		return email;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public String getThuongTruTamTru() {
		return thuongTruTamTru;
	}
	public void setHoTen(String hoTen) throws Exception {
		for (int i=0; i<hoTen.length(); i++) {
			char s = hoTen.charAt(i);
			if (s>='0' && s<='9') throw new Exception("Họ tên không chứa số");
		}
		this.hoTen = hoTen;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public void setNgaySinh(String ngaySinh) throws Exception {
		Date date = null;
		String[] d = ngaySinh.split("[^0-9]");
		if (d.length != 3) throw new Exception("Sai định dạng (yyyy/MM/dd)");
		try {
			date = Date.valueOf(d[0] + "-" + d[1] + "-" + d[2]);
		} catch (Exception e) {
			throw new Exception("Ngày không hợp lệ (yyyy/MM/dd)");
		}
		this.ngaySinh = date;
	}
	public void setSoDienThoai(String soDienThoai) throws Exception {
		for (int i=0; i<soDienThoai.length(); i++) {
			char s = soDienThoai.charAt(i);
			if (s<'0' || s>'9') throw new Exception("Số điện thoại chỉ chứa số");
		}
		this.soDienThoai = soDienThoai;
	}
	public void setSoTheBHYT(String soTheBHYT) {
		this.soTheBHYT = soTheBHYT;
	}
	public void setEmail(String email) throws Exception {
		if (email.length() == 0) {
			this.email = email;
			return;
		}
		String[] word = email.split("@");
		if (word.length != 2) throw new Exception("Sai định dạng Email");
		this.email = email;
		
	}
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}
	public void setThuongTruTamTru(String thuongTruTamTru) {
		this.thuongTruTamTru = thuongTruTamTru;
	}

}
