package kr.co.stcreative.trend.main.service;

import java.util.Arrays;
import java.util.Map;

public class TrendInquiryVO {
	
	//조회기간 시작날짜 yyyy-mm-dd
	private String startDate;
	//
	private String endDate;
	
	private String timeUnit;
	
	private String categoryName;
	
	private String categoryParam;
	
	private String device;
	
	private String gender;
	
	private String[] ages;
	
	private String[] keyword;
	
	//비교 분류정보 담기
	private String categoryName2;
	private String categoryName3;
	private String categoryParam2;
	private String categoryParam3;
	
	//상품추천을 위한 검색 API 상세 카테고리 정보 담기
	private String category1="";
	private String category2="";
	private String category3="";
	
	private String category1_2="";
	private String category2_2="";
	private String category3_2="";
	
	private String category1_3="";
	private String category2_3="";
	private String category3_3="";
	
	
	//getter 및 setter
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryParam() {
		return categoryParam;
	}

	public void setCategoryParam(String categoryParam) {
		this.categoryParam = categoryParam;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getAges() {
		return ages;
	}

	public void setAges(String ages) {
		if (ages != null && !ages.isEmpty()) {
            this.ages = ages.split(",");
        }
	}

	public String getCategoryName2() {
		return categoryName2;
	}

	public void setCategoryName2(String categoryName2) {
		this.categoryName2 = categoryName2;
	}

	public String getCategoryName3() {
		return categoryName3;
	}

	public void setCategoryName3(String categoryName3) {
		this.categoryName3 = categoryName3;
	}

	public String getCategoryParam2() {
		return categoryParam2;
	}

	public void setCategoryParam2(String categoryParam2) {
		this.categoryParam2 = categoryParam2;
	}

	public String getCategoryParam3() {
		return categoryParam3;
	}

	public void setCategoryParam3(String categoryParam3) {
		this.categoryParam3 = categoryParam3;
	}

	public String[] getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		if (keyword != null && !keyword.isEmpty()) {
            this.keyword = keyword.split(",");
        }
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

	public String getCategory1_2() {
		return category1_2;
	}

	public void setCategory1_2(String category1_2) {
		this.category1_2 = category1_2;
	}

	public String getCategory2_2() {
		return category2_2;
	}

	public void setCategory2_2(String category2_2) {
		this.category2_2 = category2_2;
	}

	public String getCategory3_2() {
		return category3_2;
	}

	public void setCategory3_2(String category3_2) {
		this.category3_2 = category3_2;
	}

	public String getCategory1_3() {
		return category1_3;
	}

	public void setCategory1_3(String category1_3) {
		this.category1_3 = category1_3;
	}

	public String getCategory2_3() {
		return category2_3;
	}

	public void setCategory2_3(String category2_3) {
		this.category2_3 = category2_3;
	}

	public String getCategory3_3() {
		return category3_3;
	}

	public void setCategory3_3(String category3_3) {
		this.category3_3 = category3_3;
	}

	@Override
	public String toString() {
		return "TrendInquiryVO [startDate=" + startDate + ", endDate=" + endDate + ", timeUnit=" + timeUnit
				+ ", categoryName=" + categoryName + ", categoryParam=" + categoryParam + ", device=" + device
				+ ", gender=" + gender + ", ages=" + Arrays.toString(ages) + ", keyword=" + Arrays.toString(keyword)
				+ ", categoryName2=" + categoryName2 + ", categoryName3=" + categoryName3 + ", categoryParam2="
				+ categoryParam2 + ", categoryParam3=" + categoryParam3 + ", category1=" + category1 + ", category2="
				+ category2 + ", category3=" + category3 + ", category1_2=" + category1_2 + ", category2_2="
				+ category2_2 + ", category3_2=" + category3_2 + ", category1_3=" + category1_3 + ", category2_3="
				+ category2_3 + ", category3_3=" + category3_3 + "]";
	}

	
	
	

	
	
	
	
}
