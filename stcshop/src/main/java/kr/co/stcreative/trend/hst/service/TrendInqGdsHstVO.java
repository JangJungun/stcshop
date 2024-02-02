package kr.co.stcreative.trend.hst.service;

import java.util.Date;

/**
 * <p>트렌드 검색어조회 이력VO</p>
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
public class TrendInqGdsHstVO {
	
	/**
	 * 상품조회이력ID
	 */
	private String gdsHstId;
	
	/**
	 * 사용자ID
	 */
	private String usrId;
	
	/**
	 * 조회상품명
	 */
	private String inqGdsNm;
	
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
	 * 상품조회일시
	 */
	private Date gdsInqDt;
	
	/**
	 * 조회상품링크
	 */
	private String inqGdsLnk;
	
	/**
	 * 트렌드 분류 조회 이력 ID
	 */
	private String hstId;
	
	public String getGdsHstId() {
		return gdsHstId;
	}
	public void setGdsHstId(String gdsHstId) {
		this.gdsHstId = gdsHstId;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getInqGdsNm() {
		return inqGdsNm;
	}
	public void setInqGdsNm(String inqGdsNm) {
		this.inqGdsNm = inqGdsNm;
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
	public Date getGdsInqDt() {
		return gdsInqDt;
	}
	public void setGdsInqDt(Date gdsInqDt) {
		this.gdsInqDt = gdsInqDt;
	}
	public String getInqGdsLnk() {
		return inqGdsLnk;
	}
	public void setInqGdsLnk(String inqGdsLnk) {
		this.inqGdsLnk = inqGdsLnk;
	}
	public String getHstId() {
		return hstId;
	}
	public void setHstId(String hstId) {
		this.hstId = hstId;
	}
	@Override
	public String toString() {
		return "TrendInqGdsHstVO [gdsHstId=" + gdsHstId + ", usrId=" + usrId + ", inqGdsNm=" + inqGdsNm
				+ ", gdsClsfOneNm=" + gdsClsfOneNm + ", gdsClsfTwoNm=" + gdsClsfTwoNm + ", gdsClsfThrNm=" + gdsClsfThrNm
				+ ", gdsInqDt=" + gdsInqDt + ", inqGdsLnk=" + inqGdsLnk + ", hstId=" + hstId + "]";
	}
	
	
	
}
