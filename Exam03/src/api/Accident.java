package api;

public class Accident {

e
	
	
	
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
