package kr.co.stcreative.trend.main.service;

import java.util.Arrays;

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
	
	
	
	//비교 분류정보 담기
	private String categoryName2;
	private String categoryName3;
	private String categoryParam2;
	private String categoryParam3;
	
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

	@Override
	public String toString() {
		return "TrendInquiryVO [startDate=" + startDate + ", endDate=" + endDate + ", timeUnit=" + timeUnit
				+ ", categoryName=" + categoryName + ", categoryParam=" + categoryParam + ", device=" + device
				+ ", gender=" + gender + ", ages=" + Arrays.toString(ages) + ", categoryName2=" + categoryName2
				+ ", categoryName3=" + categoryName3 + ", categoryParam2=" + categoryParam2 + ", categoryParam3="
				+ categoryParam3 + "]";
	}

	

	
	
	
	
}
