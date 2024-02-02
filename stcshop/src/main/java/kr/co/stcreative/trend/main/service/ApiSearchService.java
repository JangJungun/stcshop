package kr.co.stcreative.trend.main.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import kr.co.stcreative.trend.main.mapper.TrendCatMapper;

/**
 * <p>Naver 상품 검색 Api Service</p>
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
 * 
 * @author SI&컨설팅 사업본부 장준근
 * @since 1.0.0
 * 
 */
@Service
public class ApiSearchService {
	
	private TrendCatMapper trendCatMapper;
	
	@Autowired
	public ApiSearchService(TrendCatMapper trendCatMapper) {
		this.trendCatMapper=trendCatMapper;
	}
	
	@Value("${naver.client.id}") 
    private String clientId;
	@Value("${naver.client.secret}") 
    private String clientSecret;
	
	/**
	 * <p>추천상품 검색을 위한 Naver API를 호출한다</p>
	 * 
	 * 
	 * @param trendInquiryVO 상품검색을 위한 요청 데이터를 담은 TrendInquiryVO 객체이다.
	 * 
	 * @return Naver API의 응답을 문자열의 배열형태로 반환한다.
	 */
	public String[] getSearchData(TrendInquiryVO trendInquiryVO) {
		
		List<String> categories = getCategoryList(trendInquiryVO);
	    
	    String[] keywords = trendInquiryVO.getKeyword();

	    List<String> results = new ArrayList<>();

	    if (keywords == null || keywords.length == 0) {
	        for (String category : categories) {
	            if (category != null) {
	                results.add(callSearchAPI(category));
	            }
	        }
	    } else {
	        for (String keyword : keywords) {
	            if (keyword != null) {
	                results.add(callSearchAPI(keyword));
	            }
	        }
	    }

	    return results.toArray(new String[results.size()]);
	}

	/**
	 * <p>검색 API에 요청할 검색어를 분류에서 추출한다.</p>
	 * 
	 * 
	 * @param trendInquiryVO 상품검색을 위한 요청 데이터를 담은 TrendInquiryVO 객체이다.
	 * 
	 * @return 분류정보에서 추출한 검색어 문자열을 반환한다.
	 */
	private List<String> getCategoryList(TrendInquiryVO trendInquiryVO) {
		List<String> categories = new ArrayList<>();

	    if (trendInquiryVO.getCategoryName() != null && !trendInquiryVO.getCategoryName().isEmpty()) {
	        categories.add(trendInquiryVO.getCategory1()+trendInquiryVO.getCategory2()+trendInquiryVO.getCategory3());
	    }
	    if (trendInquiryVO.getCategoryName2() != null && !trendInquiryVO.getCategoryName2().isEmpty()) {
	        categories.add(trendInquiryVO.getCategory1_2()+trendInquiryVO.getCategory2_2()+trendInquiryVO.getCategory3_2());
	    }
	    if (trendInquiryVO.getCategoryName3() != null && !trendInquiryVO.getCategoryName3().isEmpty()) {
	        categories.add(trendInquiryVO.getCategory1_3()+trendInquiryVO.getCategory2_3()+trendInquiryVO.getCategory3_3());
	    }
		return categories;
	}

	/**
	 * <p>Naver 쇼핑 검색 API를 호출하여 주어진 쿼리에 대한 검색 결과를 JSON형식의 문자열로 반환한다.</p>
	 *
	 *
	 * @param query 검색어를 담은 문자열.
	 *
	 * @return API의 응답 본문을 문자열 형태로 반환한다. 
	 */
	private String callSearchAPI(String query) {
		System.out.println("*****Query:"+query);
	    URI uri = UriComponentsBuilder
	            .fromUriString("https://openapi.naver.com")
	            .path("/v1/search/shop.json")
	            .queryParam("query", query)
	            .queryParam("display", 3)
	            .queryParam("start", 1)
	            .queryParam("sort", "sim")
	            .encode()
	            .build()
	            .toUri();

	    RequestEntity<Void> req = RequestEntity
	            .get(uri)
	            .header("X-Naver-Client-Id", clientId)
	            .header("X-Naver-Client-Secret", clientSecret)
	            .build();

	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> responseEntity = restTemplate.exchange(req, String.class);

	    String result = responseEntity.getBody();
	    
	    return result;
	}
	
	/**
	 * 분류명으로 분류코드를 DB에서 조회한다.
	 * 
	 * @param category 분류코드를 조회할 분류명
	 * @return 요청한 분류명에 해당하는 분류코드
	 */
	public String getCategoryparam(String category) {
		String categoryParam = trendCatMapper.getCategoryParam(category);
		return categoryParam;
	}
	

}
