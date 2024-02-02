package kr.co.stcreative.trend.hst.service;

import java.util.Date;

/**
 * <p>트렌드 분류 조회 이력VO</p>
 *  
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 * 2024-01-22   장준근          신규개발
 *
 * </pre>
 * 
 * @author SI&컨설팅 사업본부 장준근
 * @since 1.0.0
 * 
 */
public class TrendInqHstVO {
	
	/**
	 * 이력ID
	 */
	private String hstId;
	
	/**
	 * 사용자ID
	 */
	private String usrId;

	/**
	 * 검색키워드내용
	 */
	private String srchKwrdCn;
	
	/**
	 * 상품첫번째분류명
	 */
	private String gdsClsfOneNm;
	
	/**
	 * 상품두번째분류명
	 */
	private String gdsClsfTwoNm;
	
	/**
	 * 상품세번째분류명
	 */
	private String gdsClsfThrNm;
	
	/**
	 * 검색일시
	 */
	private Date srchDt;
	
	/**
	 * 조회기간단위코드
	 */
	private String inqPrdUnitCd;
	
	/**
	 * 조회기간시작일
	 */
	private String inqPrdBgngYmd;
	
	/**
	 * 조회기간시작일
	 */
	private String inqPrdEndYmd;
	
	/**
	 * 기기종류코드
	 */
	private String deviceTypeCd;
	
	/**
	 * 성별코드
	 */
	private String sxdsCd;
	
	/**
	 * 연령코드
	 */
	private String ageCd;

	
	
	//검색 이력조회시 필요한 상품명 변수
	private String inqGdsNm;
	public String getInqGdsNm() {return inqGdsNm;}
	public void setInqGdsNm(String inqGdsNm) {this.inqGdsNm = inqGdsNm;}

	//getter 및 setter
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
