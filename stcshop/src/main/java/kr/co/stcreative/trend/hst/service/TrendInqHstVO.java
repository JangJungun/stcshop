package kr.co.stcreative.trend.hst.service;

import java.util.Date;

public class TrendInqHstVO {
	
	private String hstId;
	
	private String usrId;
	
	private String srchKwrdCn;
	
	private String gdsClsfOneNm;
	
	private String gdsClsfTwoNm;
	
	private String gdsClsfThrNm;
	
	private Date srchDt;
	
	private String inqPrdUnitCd;
	
	private String inqPrdBgngYmd;
	
	private String inqPrdEndYmd;
	
	private String deviceTypeCd;
	
	private String sxdsCd;
	
	private String ageCd;

	public String getHstId() {
		return hstId;
	}

	public void setHstId(String hstId) {
		this.hstId = hstId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getSrchKwrdCn() {
		return srchKwrdCn;
	}

	public void setSrchKwrdCn(String srchKwrdCn) {
		this.srchKwrdCn = srchKwrdCn;
	}

	public String getGdsClsfOneNm() {
		return gdsClsfOneNm;
	}

	public void setGdsClsfOneNm(String gdsClsfOneNm) {
		this.gdsClsfOneNm = gdsClsfOneNm;
	}

	public String getGdsClsfTwoNm() {
		return gdsClsfTwoNm;
	}

	public void setGdsClsfTwoNm(String gdsClsfTwoNm) {
		this.gdsClsfTwoNm = gdsClsfTwoNm;
	}

	public String getGdsClsfThrNm() {
		return gdsClsfThrNm;
	}

	public void setGdsClsfThrNm(String gdsClsfThrNm) {
		this.gdsClsfThrNm = gdsClsfThrNm;
	}

	public Date getSrchDt() {
		return srchDt;
	}

	public void setSrchDt(Date srchDt) {
		this.srchDt = srchDt;
	}

	public String getInqPrdUnitCd() {
		return inqPrdUnitCd;
	}

	public void setInqPrdUnitCd(String inqPrdUnitCd) {
		this.inqPrdUnitCd = inqPrdUnitCd;
	}

	public String getInqPrdBgngYmd() {
		return inqPrdBgngYmd;
	}

	public void setInqPrdBgngYmd(String inqPrdBgngYmd) {
		this.inqPrdBgngYmd = inqPrdBgngYmd;
	}

	public String getInqPrdEndYmd() {
		return inqPrdEndYmd;
	}

	public void setInqPrdEndYmd(String inqPrdEndYmd) {
		this.inqPrdEndYmd = inqPrdEndYmd;
	}

	public String getDeviceTypeCd() {
		return deviceTypeCd;
	}

	public void setDeviceTypeCd(String deviceTypeCd) {
		this.deviceTypeCd = deviceTypeCd;
	}

	public String getSxdsCd() {
		return sxdsCd;
	}

	public void setSxdsCd(String sxdsCd) {
		this.sxdsCd = sxdsCd;
	}

	public String getAgeCd() {
		return ageCd;
	}

	public void setAgeCd(String ageCd) {
		this.ageCd = ageCd;
	}

	@Override
	public String toString() {
		return "TrendInqHstVO [hstId=" + hstId + ", usrId=" + usrId + ", srchKwrdCn=" + srchKwrdCn + ", gdsClsfOneNm="
				+ gdsClsfOneNm + ", gdsClsfTwoNm=" + gdsClsfTwoNm + ", gdsClsfThrNm=" + gdsClsfThrNm + ", srchDt="
				+ srchDt + ", inqPrdUnitCd=" + inqPrdUnitCd + ", inqPrdBgngYmd=" + inqPrdBgngYmd + ", inqPrdEndYmd="
				+ inqPrdEndYmd + ", deviceTypeCd=" + deviceTypeCd + ", sxdsCd=" + sxdsCd + ", ageCd=" + ageCd + "]";
	}
	
	
	
}
