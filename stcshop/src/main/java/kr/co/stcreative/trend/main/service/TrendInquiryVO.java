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

	@Override
	public String toString() {
		return "TerndInquiryVO [startDate=" + startDate + ", endDate=" + endDate + ", timeUnit=" + timeUnit
				+ ", categoryName=" + categoryName + ", categoryParam=" + categoryParam + ", device=" + device
				+ ", gender=" + gender + ", ages=" + Arrays.toString(ages) + "]";
	}

	
	
	
	
}
