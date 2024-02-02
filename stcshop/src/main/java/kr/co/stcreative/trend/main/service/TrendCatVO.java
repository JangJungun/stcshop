package kr.co.stcreative.trend.main.service;
/**
 * <p>트렌드 카테고리VO</p>
 * <p>Naver Datalab Api 호출시 필요한 카테고리 이름, 분류명을 저장한다.</p>
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
public class TrendCatVO {
	/**
	 * 분류(카테고리) ID
	 */
	private String catId;
	
	/**
	 * 대분류명
	 */
	private String gdsClsfOneNm;
	
	/**
	 * 중분류명
	 */
	private String gdsClsfTwoNm;
	
	/**
	 * 소분류명
	 */
	private String gdsClsfThrNm;

	
	
	//Getter 및 Setter
	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
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

	@Override
	public String toString() {
		return "TrendCatVO [catId=" + catId + ", gdsClsfOneNm=" + gdsClsfOneNm + ", gdsClsfTwoNm=" + gdsClsfTwoNm
				+ ", gdsClsfThrNm=" + gdsClsfThrNm + "]";
	}
	
	
	
}
