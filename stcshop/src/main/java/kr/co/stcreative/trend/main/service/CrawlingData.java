package kr.co.stcreative.trend.main.service;

/**
 * <p>크롤링데이터VO</p>
 *  
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 * 2024-01-22   장준근          신규개발
 * 2024-02-06   장준근          크롤링 대상 사이트 변경으로 인한 일부항목 @deprecated
 * 
 * </pre>
 * 
 * @author SI&컨설팅 사업본부 장준근
 * @since 1.0.0
 * 
 */
public class CrawlingData {
	/**
	 * 연도
	 */
	@Deprecated
	private String year;
	
	/**
	 * 주
	 */
	@Deprecated
    private String week;
    
    /**
     * 순위
     */
	@Deprecated
    private String rank;
    
    /**
     * 키워드
     */
    private String keyword;
    
	public CrawlingData(String keyword) {
		this.keyword = keyword;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "CrawlingData [year=" + year + ", week=" + week + ", rank=" + rank + ", keyword=" + keyword + "]";
	}
    
    
}
