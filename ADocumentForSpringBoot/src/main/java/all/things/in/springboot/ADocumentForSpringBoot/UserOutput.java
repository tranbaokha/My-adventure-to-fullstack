package all.things.in.springboot.ADocumentForSpringBoot;

import java.time.LocalDate;

public class UserOutput {
	private int ma_so;
	private String ten_day_du;
	public UserOutput() {
		
	}
	public UserOutput(int ma_so, String ten_day_du) {
		this.ma_so = ma_so;
		this.ten_day_du = ten_day_du;
	}
	public int getMa_so() {
		return ma_so;
	}
	public void setMa_so(int ma_so) {
		this.ma_so = ma_so;
	}
	public String getTen_day_du() {
		return ten_day_du;
	}
	public void setTen_day_du(String ten_day_du) {
		this.ten_day_du = ten_day_du;
	}
	
}
