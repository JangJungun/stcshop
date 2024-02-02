package kr.co.stcreative.trend.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;


/*
 Chrome 드라이버 최신버전 다운로드 주소확인
 https://github.com/GoogleChromeLabs/chrome-for-testing/blob/main/data/latest-versions-per-milestone-with-downloads.json
 
 
 
 */

public class Test {

	
	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		long startTime = System.currentTimeMillis(); // 코드 시작 시간
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://insfiler.com/detail/rt_shop_daily_kr-0001");
		
		WebElement button = driver.findElement(ById.id("graph-toolbox-table"));
		button.click();
		
		try {Thread.sleep(500);} catch (InterruptedException e) {} //클릭 후 load되는 시간 대기
		
//		List<WebElement> elements = driver.findElements(By.className("chart-wrap"));
		List<WebElement> rows = driver.findElements(By.cssSelector("div.chart-wrap table tr.row"));

		for (int i = 0; i < 100; i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            String year = cols.get(0).getText();
            String week = cols.get(1).getText();
            String rank = cols.get(2).getText();
            String keyword = cols.get(3).getText();

            System.out.println(i+1 + ": " + year + ", " + week + ", " + rank + ", " + keyword);

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
