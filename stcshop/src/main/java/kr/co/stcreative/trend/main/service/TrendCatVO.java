package kr.co.stcreative.trend.main.service;
/**
 * 트렌드 카테고리VO
 * Naver Datalab Api 호출시 필요한 카테고리 이름, 분류명을 저장한다.
 *  
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 * 
 *
 * </pre>
 * @author SI&컨설팅 사업본부 장준근
 * @since 1.0.0
 * 
 */
public class TrendCatVO {

	private String catId;
	
	private String gdsClsfOneNm;
	
	private String gdsClsfTwoNm;
	
	private String gdsClsfThrNm;

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
