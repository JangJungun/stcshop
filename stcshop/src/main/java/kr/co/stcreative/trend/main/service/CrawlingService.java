package kr.co.stcreative.trend.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 * <p>주간 인기검색어 크롤링 서비스</p>
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
 * @author SI&컨설팅 사업본부 장준근
 * @since 1.0.0
 * 
 */
@Service
public class CrawlingService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * <p>주간 인기 검색어를 웹 크롤링하여 비동기적으로 가져온다.</p>
	 * 
	 * Chrome 웹 드라이버를 사용하여 인기 검색어 페이지를 크롤링하고,
	 * 웹 페이지에서 검색어 데이터를 추출하여 {@link CrawlingData} 객체의 리스트로 만든다.
	 * 이 작업은 {@link CompletableFuture}를 사용하여 비동기적으로 수행된다.
	 * 
	 * @return 인기 검색어 데이터를 담은 {@link CrawlingData} 객체의 리스트를 포함하는 {@link CompletableFuture} 객체를 반환한다.
	 */
	@Async
	public CompletableFuture<List<CrawlingData>> getPopularKeywords() {
		
		//Chrome 웹 드라이버를 이용하기 위해 chromedriver의 경로정보 저장
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		
		//"headless" 옵션을 사용하여 실제 브라우저를 실행하지 않고 가상 브라우저로 처리
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		
		//Chrome 웹드라이버 객체 생성
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		//크롤링을 할 url 주소
		driver.get("https://insfiler.com/detail/rt_shop_daily_kr-0001");
		
		//동적인 크롤링 진행을 위해 Id가 'graph-toolbox-table'인 버튼을 클릭.
		WebElement button = driver.findElement(ById.id("graph-toolbox-table"));
		button.click();
		
		//클릭 후 load되는 시간 대기
		try {Thread.sleep(500);} catch (InterruptedException e) {} 
		
		//데이터를 크롤링할 엘리멘트 설정
		List<WebElement> rows = driver.findElements(By.cssSelector("div.chart-wrap table tr.row"));
//		List<WebElement> elements = driver.findElements(By.className("chart-wrap"));
		
		//크롤링한 데이터를 저장하기위한 CrawlingData타입의 ArrayList 선언
		List<CrawlingData> keywordInfoList = new ArrayList<>();
		
		//주간 인기검색어 테이블에서 top100을 날짜, 순위, 키워드로 추출해서 keywordInfoList에 담기
		for (int i = 0; i < 100; i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            String year = cols.get(0).getText();
            String week = cols.get(1).getText();
            String rank = cols.get(2).getText();
            String keyword = cols.get(3).getText();

            logger.info(i+1 + ": " + year + ", " + week + ", " + rank + ", " + keyword);
            CrawlingData crawlingData = new CrawlingData(year, week, rank, keyword);
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
		
		//크롤링한 데이터인 keywordInfoList를 비동기 작업의 결과로 리턴
		return CompletableFuture.completedFuture(keywordInfoList);
	}
	
}
