package api;

public class Accident {

	String occrrncDt;  // 발생월일시 (2019011622)
	String occrrncDayCd;  // 발생요일코드 (4)
	int dthDnvCnt;  // 사망자수 (0)
	int injpsnCnt;  // 부상자수 (1)
	
	
	
	public Accident(String occrrncDt, String occrrncDayCd, int dthDnvCnt, int injpsnCnt) {
		super();
		this.occrrncDt = occrrncDt;
		this.occrrncDayCd = occrrncDayCd;
		this.dthDnvCnt = dthDnvCnt;
		this.injpsnCnt = injpsnCnt;
	
	}



	public String getOccrrncDt() {
		return occrrncDt;
	}



	public void setOccrrncDt(String occrrncDt) {
		this.occrrncDt = occrrncDt;
	}



	public String getOccrrncDayCd() {
		return occrrncDayCd;
	}



	public void setOccrrncDayCd(String occrrncDayCd) {
		this.occrrncDayCd = occrrncDayCd;
	}



	public int getDthDnvCnt() {
		return dthDnvCnt;
	}



	public void setDthDnvCnt(int dthDnvCnt) {
		this.dthDnvCnt = dthDnvCnt;
	}



	public int getInjpsnCnt() {
		return injpsnCnt;
	}



	public void setInjpsnCnt(int injpsnCnt) {
		this.injpsnCnt = injpsnCnt;
	}
	
	
	
}
