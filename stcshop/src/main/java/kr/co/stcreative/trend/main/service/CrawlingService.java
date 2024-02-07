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
		//ubuntu 환경
//		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

		
		//"headless" 옵션을 사용하여 실제 브라우저를 실행하지 않고 가상 브라우저로 처리
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("headless");
		
		//ubuntu 환경 추가설정
		// (optional) GPU 사용 안 함
		//chromeOptions.addArguments("disable-gpu");

		// (optional) 노-샌드박스 모드로 실행
		chromeOptions.addArguments("no-sandbox");

		// (optional) 소프트웨어 래스터라이저 사용 안 함
		//chromeOptions.addArguments("disable-software-rasterizer");

		// (optional) dev/shm 사용 안 함
		chromeOptions.addArguments("disable-dev-shm-usage");

		// (optional) 확장 프로그램 비활성화
		//chromeOptions.addArguments("disable-extensions");
		
		chromeOptions.addArguments("lang=ko");
		//chromeOptions.addArguments("--disable-gpu");
        //chromeOptions.setCapability("ignoreProtectedModeSettings", true);
		
		//user -agent 설정
//		chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36");
		//Chrome 웹드라이버 객체 생성
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		//크롤링을 할 url 주소
		driver.get("https://search.shopping.naver.com/best/category/keyword?categoryCategoryId=ALL&categoryDemo=A00&categoryRootCategoryId=ALL&chartRank=1&period=P1D");
//		driver.get("https://google.com");
		
				
		//데이터를 크롤링할 엘리멘트 설정
		List<WebElement> rows = driver.findElements(By.cssSelector("ul.list_keyword li.chartList_item_keyword__m_koH"));

		
		//크롤링한 데이터를 저장하기위한 CrawlingData타입의 ArrayList 선언
		List<CrawlingData> keywordInfoList = new ArrayList<>();
		
		
		
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
		    logger.info(i+1 + ": " + keyword);
		    CrawlingData crawlingData = new CrawlingData(keyword);
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
