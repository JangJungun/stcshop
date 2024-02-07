package kr.co.stcreative.trend.main;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




/*
 Chrome 드라이버 최신버전 다운로드 주소확인
 https://github.com/GoogleChromeLabs/chrome-for-testing/blob/main/data/latest-versions-per-milestone-with-downloads.json

 
 
 */

public class Test {
	
	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		long startTime = System.currentTimeMillis(); // 코드 시작 시간

//		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		//ubuntu 환경
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://search.shopping.naver.com/best/category/keyword?categoryCategoryId=ALL&categoryDemo=A00&categoryRootCategoryId=ALL&chartRank=1&period=P1D");
		
		/*WebElement button = driver.findElement(ById.id("graph-toolbox-table"));
		button.click();*/
		
		try {Thread.sleep(500);} catch (InterruptedException e) {} //클릭 후 load되는 시간 대기

//		WebElement Element = driver.findElement(By.cssSelector("ul.list_keyword"));
		
		


		List<CrawlingData1> keywordInfoList = new ArrayList<>();

		List<WebElement> rows = driver.findElements(By.cssSelector("ul.list_keyword li.chartList_item_keyword__m_koH"));


		//키워드 테이블에서 top20을 키워드로 추출해서 keywordInfoList에 담기
		for (int i = 0; i < 20; i++) {
		    // a 태그 내의 모든 텍스트 추출
		    String fullText = rows.get(i).findElement(By.tagName("a")).getText();

		    // a 태그 내의 각 span과 em 태그의 텍스트 추출
		    List<WebElement> childElements = rows.get(i).findElement(By.tagName("a")).findElements(By.xpath("./*"));
		    for (WebElement childElement : childElements) {
		        String childText = childElement.getText();
		        // a 태그의 텍스트에서 span과 em 태그의 텍스트 제거
		        fullText = fullText.replace(childText, "");
		    }

		    // 키워드 추출 및 저장
		    String keyword = fullText.trim();
		    System.out.println(i+1 + ": " + keyword);
		    CrawlingData1 crawlingData = new CrawlingData1(keyword);
		    keywordInfoList.add(crawlingData);
		}
		
		try {
			//드라이버가 null이 아니라면
			if(driver != null) {
				//드라이버 연결 종료
				driver.close(); //드라이버 연결 해제
				
				//프로세스 종료
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		long endTime = System.currentTimeMillis(); // 코드 끝난 시간
		
		long durationTimeSec = endTime - startTime;
	    
		System.out.println(durationTimeSec + "m/s"); // 밀리세컨드 출력
		System.out.println((durationTimeSec / 1000) + "sec"); // 초 단위 변환 출력
	}
}
class CrawlingData1 {
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
    
	public CrawlingData1(String keyword) {
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
		return "CrawlingData1 [year=" + year + ", week=" + week + ", rank=" + rank + ", keyword=" + keyword + "]";
	}
    
    
}