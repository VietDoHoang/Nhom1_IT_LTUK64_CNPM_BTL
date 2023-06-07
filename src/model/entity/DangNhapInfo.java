package model.entity;

public class DangNhapInfo {
	private String username=null;
	private String QLNhanKhau= null;
	private String QLKhaiBao= null;
	private String QLSucKhoe= null;
	private String QLTestCovid= null;
	private String QLTiemVaccine= null;
	private String QLCachLy= null;
	private String ThongKe = null;
	public DangNhapInfo(String username, String QLNhanKhau, String QLKhaiBao, String QLSucKhoe,
			String QLTestCovid, String QLTiemVaccine, String QLCachLy, String ThongKe) {
		this.username = username;
		this.QLNhanKhau = QLNhanKhau;
		this.QLKhaiBao = QLKhaiBao;
		this.QLSucKhoe = QLSucKhoe;
		this.QLTestCovid = QLTestCovid;
		this.QLTiemVaccine = QLTiemVaccine;
		this.QLCachLy = QLCachLy;
		this.ThongKe = ThongKe;
	}
	public DangNhapInfo() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQLNhanKhau() {
		return QLNhanKhau;
	}
	public void setQLNhanKhau(String QLNhanKhau) {
		this.QLNhanKhau = QLNhanKhau;
	}
	public String getQLKhaiBao() {
		return QLKhaiBao;
	}
	public void setQLKhaiBao(String QLKhaiBao) {
		this.QLKhaiBao = QLKhaiBao;
	}
	public String getQLSucKhoe() {
		return QLSucKhoe;
	}
	public void setQLSucKhoe(String QLSucKhoe) {
		this.QLSucKhoe = QLSucKhoe;
	}
	public String getQLTestCovid() {
		return QLTestCovid;
	}
	public void setQLTestCovid(String QLTestCovid) {
		this.QLTestCovid = QLTestCovid;
	}
	public String getQLTiemVaccine() {
		return QLTiemVaccine;
	}
	public void setQLTiemVaccine(String QLTiemVaccine) {
		this.QLTiemVaccine = QLTiemVaccine;
	}
	public String getQLCachLy() {
		return QLCachLy;
	}
	public void setQLCachLy(String QLCachLy) {
		this.QLCachLy = QLCachLy;
	}
	public String getThongKe() {
		return ThongKe;
	}
	public void setThongKe(String ThongKe) {
		this.ThongKe = ThongKe;
	}

}
