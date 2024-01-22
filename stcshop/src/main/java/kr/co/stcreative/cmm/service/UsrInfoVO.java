package kr.co.stcreative.cmm.service;

import java.util.Date;
/**
 * 사용자정보VO
 *  
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 * 2024.01.22  장준근           최초작성
 *
 * </pre>
 * @author SI&컨설팅 사업본부 장준근
 * @since 1.0.0
 * 
 */
public class UsrInfoVO {
	/**
	 * 회원 고유 ID
	 */
	private String usrId;
	
	/**
	 * 로그인 계정 ID
	 */
	private String lgnAcntId;
	
	/**
	 * 로그인 계정 비밀번호
	 */
	private String lgnAcntPswd;
	
	/**
	 * 소셜로그인 ID
	 */
	private String snsId;
	
	/**
	 * 소셜로그인 타입코드
	 */
	private String snsTypeCd;
	
	/**
	 * 소셜로그인 연동일시
	 */
	private Date snsCnctDt;
	
	/**
	 * 사용자 닉네임
	 */
	private String nickNm;
	
	/**
	 * 사용자 이메일주소
	 */
	private String usrEml;
	
	/**
	 * 사용자 생년월일
	 */
	private String usrBrdt;
	
	/**
	 * 사용자 성별코드
	 */
	private String sxdsCd;
	
	/**
	 * 사용자 휴대전화번호
	 */
	private String mblTelno;
	
	/**
	 * 권한 그룹ID
	 */
	private String grpId;
	
	/**
	 * 회원가입 일시
	 */
	private Date joinDt;
	
	/**
	 * 회원정보 수정 일시
	 */
	private Date mdfcnDt;
	
	/**
	 * 회원탈퇴 일시
	 */
	private Date whdwlDt;
	
	//Getter 및 Setter
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getLgnAcntId() {
		return lgnAcntId;
	}
	public void setLgnAcntId(String lgnAcntId) {
		this.lgnAcntId = lgnAcntId;
	}
	public String getLgnAcntPswd() {
		return lgnAcntPswd;
	}
	public void setLgnAcntPswd(String lgnAcntPswd) {
		this.lgnAcntPswd = lgnAcntPswd;
	}
	public String getSnsId() {
		return snsId;
	}
	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}
	public String getSnsTypeCd() {
		return snsTypeCd;
	}
	public void setSnsTypeCd(String snsTypeCd) {
		this.snsTypeCd = snsTypeCd;
	}
	public Date getSnsCnctDt() {
		return snsCnctDt;
	}
	public void setSnsCnctDt(Date snsCnctDt) {
		this.snsCnctDt = snsCnctDt;
	}
	public String getNickNm() {
		return nickNm;
	}
	public void setNickNm(String nickNm) {
		this.nickNm = nickNm;
	}
	public String getUsrEml() {
		return usrEml;
	}
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	public String getUsrBrdt() {
		return usrBrdt;
	}
	public void setUsrBrdt(String usrBrdt) {
		this.usrBrdt = usrBrdt;
	}
	public String getSxdsCd() {
		return sxdsCd;
	}
	public void setSxdsCd(String sxdsCd) {
		this.sxdsCd = sxdsCd;
	}
	public String getMblTelno() {
		return mblTelno;
	}
	public void setMblTelno(String mblTelno) {
		this.mblTelno = mblTelno;
	}
	public String getGrpId() {
		return grpId;
	}
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	public Date getJoinDt() {
		return joinDt;
	}
	public void setJoinDt(Date joinDt) {
		this.joinDt = joinDt;
	}
	public Date getMdfcnDt() {
		return mdfcnDt;
	}
	public void setMdfcnDt(Date mdfcnDt) {
		this.mdfcnDt = mdfcnDt;
	}
	public Date getWhdwlDt() {
		return whdwlDt;
	}
	public void setWhdwlDt(Date whdwlDt) {
		this.whdwlDt = whdwlDt;
	}
	
}
