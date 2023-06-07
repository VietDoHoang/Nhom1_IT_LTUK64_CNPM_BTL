package model.entity;

import java.sql.Date;

public class KhaiBaoInfo extends NhanKhauInfo{
	private int maKhaiBao = 0;
	private String tiepXucVoiNguoiBenh = null;
	private String diVeTuVungDich = null;
	private String tiepXucVoiNguoiTuVungDich = null;
	private Date ngayKhaiBao = null;
	public KhaiBaoInfo(NhanKhauInfo nhanKhauInfo, int maKhaiBao, String tiepXucVoiNguoiBenh, String diVeTuVungDich,
			String tiepXucVoiNguoiTuVungDich, String ngayKhaiBao) throws Exception {
		super(nhanKhauInfo);
		this.maKhaiBao = maKhaiBao;
		this.tiepXucVoiNguoiBenh = tiepXucVoiNguoiBenh;
		this.diVeTuVungDich = diVeTuVungDich;
		this.tiepXucVoiNguoiTuVungDich = tiepXucVoiNguoiTuVungDich;
		setNgayKhaiBao(ngayKhaiBao);
	}
	
	public KhaiBaoInfo(NhanKhauInfo nhanKhauInfo, String tiepXucVoiNguoiBenh, String diVeTuVungDich,
			String tiepXucVoiNguoiTuVungDich, String ngayKhaiBao) throws Exception {
		super(nhanKhauInfo);
		this.tiepXucVoiNguoiBenh = tiepXucVoiNguoiBenh;
		this.diVeTuVungDich = diVeTuVungDich;
		this.tiepXucVoiNguoiTuVungDich = tiepXucVoiNguoiTuVungDich;
		setNgayKhaiBao(ngayKhaiBao);
	}
	
	public int getMaKhaiBao() {
		return maKhaiBao;
	}
	public String getTiepXucVoiNguoiBenh() {
		return tiepXucVoiNguoiBenh;
	}
	public String getDiVeTuVungDich() {
		return diVeTuVungDich;
	}
	public String getTiepXucVoiNguoiTuVungDich() {
		return tiepXucVoiNguoiTuVungDich;
	}
	public Date getNgayKhaiBao() {
		return ngayKhaiBao;
	}
	public void setMaKhaiBao(int maKhaiBao) {
		this.maKhaiBao = maKhaiBao;
	}
	public void setTiepXucVoiNguoiBenh(String tiepXucVoiNguoiBenh) {
		this.tiepXucVoiNguoiBenh = tiepXucVoiNguoiBenh;
	}
	public void setDiVeTuVungDich(String diVeTuVungDich) {
		this.diVeTuVungDich = diVeTuVungDich;
	}
	public void setTiepXucVoiNguoiTuVungDich(String tiepXucVoiNguoiTuVungDich) {
		this.tiepXucVoiNguoiTuVungDich = tiepXucVoiNguoiTuVungDich;
	}
	public void setNgayKhaiBao(String ngayKhaiBao) throws Exception {
		Date date = null;
		String[] d = ngayKhaiBao.split("[^0-9]");
		if (d.length != 3) throw new Exception("Sai định dạng (yyyy/MM/dd)");
		try {
			date = Date.valueOf(d[0] + "-" + d[1] + "-" + d[2]);
		} catch (Exception e) {
			throw new Exception("Ngày không hợp lệ (yyyy/MM/dd)");
		}
		this.ngayKhaiBao = date;
	}
	
}
