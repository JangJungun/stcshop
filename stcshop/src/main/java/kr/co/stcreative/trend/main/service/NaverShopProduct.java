package kr.co.stcreative.trend.main.service;

public class NaverShopProduct {
	
	/*
		1. image link
		2. 구매 url
		3. 상품명
		4. 최저가
		5. categories
		6. 리뷰별점
		7. 리뷰수
		8. 등록일
	 * */
	private String imageLink;
	
	private String prductUrl;
	
	private String productNm;
	
	private String productPrice;
	
	private String category1;
	
	private String category2;
	
	private String category3;
	
	private String productNum;
	
	private String reviewCount;
	
	private String productRegDt;

	
	
	
	public NaverShopProduct(String imageLink, String prductUrl, String productNm, String productPrice, String category1,
			String category2, String category3, String productNum, String reviewCount, String productRegDt) {
		this.imageLink = imageLink;
		this.prductUrl = prductUrl;
		this.productNm = productNm;
		this.productPrice = productPrice;
		this.category1 = category1;
		this.category2 = category2;
		this.category3 = category3;
		this.productNum = productNum;
		this.reviewCount = reviewCount;
		this.productRegDt = productRegDt;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getPrductUrl() {
		return prductUrl;
	}

	public void setPrductUrl(String prductUrl) {
		this.prductUrl = prductUrl;
	}

	public String getProductNm() {
		return productNm;
	}

	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
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

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(String reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getProductRegDt() {
		return productRegDt;
	}

	public void setProductRegDt(String productRegDt) {
		this.productRegDt = productRegDt;
	}

	@Override
	public String toString() {
		return "NaverShopProduct [imageLink=" + imageLink + ", prductUrl=" + prductUrl + ", productNm=" + productNm
				+ ", productPrice=" + productPrice + ", category1=" + category1 + ", category2=" + category2
				+ ", category3=" + category3 + ", productNum=" + productNum + ", reviewCount=" + reviewCount
				+ ", productRegDt=" + productRegDt + "]";
	}
	
	
	
	
	
}
