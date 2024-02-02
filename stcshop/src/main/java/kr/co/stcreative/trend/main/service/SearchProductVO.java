package kr.co.stcreative.trend.main.service;

@Deprecated
public class SearchProductVO {
	
	private String title;
	
	private String link;
	
	private String image;
	
	private String lprice;
	
	private String category1;
	private String category2;
	private String category3;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLprice() {
		return lprice;
	}
	public void setLprice(String lprice) {
		this.lprice = lprice;
	}
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	public String getCategory3() {
		return category3;
	}
	public void setCategory3(String category3) {
		this.category3 = category3;
	}
	@Override
	public String toString() {
		return "SearchProductVO [title=" + title + ", link=" + link + ", image=" + image + ", lprice=" + lprice
				+ ", category1=" + category1 + ", category2=" + category2 + ", category3=" + category3 + "]";
	}
	
	
	
}
