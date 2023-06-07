package model.entity;

import java.sql.Date;

public class SucKhoeInfo extends NhanKhauInfo{
	private int maKhaiBao = 0;
	private String ho = null;
	private String sot = null;
	private String khoTho = null;
	private String dauNguoi = null;
	private String matViGiac = null;
	private String buonNon = null;
	private String trieuChungKhac = null;
	private Date ngayXuatHien = null;
	
	public SucKhoeInfo(NhanKhauInfo nhanKhauInfo, int maKhaiBao, String ho, String sot, String khoTho, String dauNguoi, String matViGiac,
			String buonNon, String trieuChungKhac, String ngayXuatHien) throws Exception {
		super(nhanKhauInfo);
		this.maKhaiBao = maKhaiBao;
		this.ho = ho;
		this.sot = sot;
		this.khoTho = khoTho;
		this.dauNguoi = dauNguoi;
		this.matViGiac = matViGiac;
		this.buonNon = buonNon;
		this.trieuChungKhac = trieuChungKhac;
		setNgayXuatHien(ngayXuatHien);
	}
	public SucKhoeInfo(NhanKhauInfo nhanKhauInfo, String ho, String sot, String khoTho, String dauNguoi, String matViGiac, String buonNon,
			String trieuChungKhac, String ngayXuatHien) throws Exception {
		super(nhanKhauInfo);
		this.ho = ho;
		this.sot = sot;
		this.khoTho = khoTho;
		this.dauNguoi = dauNguoi;
		this.matViGiac = matViGiac;
		this.buonNon = buonNon;
		this.trieuChungKhac = trieuChungKhac;
		setNgayXuatHien(ngayXuatHien);
	}
	public int getMaKhaiBao() {
		return maKhaiBao;
	}
	public String getHo() {
		return ho;
	}
	public String getSot() {
		return sot;
	}
	public String getKhoTho() {
		return khoTho;
	}
	public String getDauNguoi() {
		return dauNguoi;
	}
	public String getMatViGiac() {
		return matViGiac;
	}
	public String getBuonNon() {
		return buonNon;
	}
	public String getTrieuChungKhac() {
		return trieuChungKhac;
	}
	public Date getNgayXuatHien() {
		return ngayXuatHien;
	}
	public void setMaKhaiBao(int maKhaiBao) {
		this.maKhaiBao = maKhaiBao;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public void setSot(String sot) {
		this.sot = sot;
	}
	public void setKhoTho(String khoTho) {
		this.khoTho = khoTho;
	}
	public void setDauNguoi(String dauNguoi) {
		this.dauNguoi = dauNguoi;
	}
	public void setMatViGiac(String matViGiac) {
		this.matViGiac = matViGiac;
	}
	public void setBuonNon(String buonNon) {
		this.buonNon = buonNon;
	}
	public void setTrieuChungKhac(String trieuChungKhac) {
		this.trieuChungKhac = trieuChungKhac;
	}
	public void setNgayXuatHien(String ngayXuatHien) throws Exception {
		Date date = null;
		String[] d = ngayXuatHien.split("[^0-9]");
		if (d.length != 3) throw new Exception("Sai định dạng (yyyy/MM/dd)");
		try {
			date = Date.valueOf(d[0] + "-" + d[1] + "-" + d[2]);
		} catch (Exception e) {
			throw new Exception("Ngày không hợp lệ (yyyy/MM/dd)");
		}
		this.ngayXuatHien = date;
	}
	
	
}
