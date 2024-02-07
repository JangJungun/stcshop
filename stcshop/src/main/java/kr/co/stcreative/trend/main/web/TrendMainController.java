package kr.co.stcreative.trend.main.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.stcreative.trend.hst.service.TrendHstService;
import kr.co.stcreative.trend.hst.service.TrendInqGdsHstVO;
import kr.co.stcreative.trend.hst.service.TrendInqHstVO;
import kr.co.stcreative.trend.main.service.ApiDatalabKeywordService;
import kr.co.stcreative.trend.main.service.ApiDatalabTrendService;
import kr.co.stcreative.trend.main.service.ApiSearchService;
import kr.co.stcreative.trend.main.service.CrawlingData;
import kr.co.stcreative.trend.main.service.TrendInquiryVO;
import kr.co.stcreative.usrinfo.service.UsrInfoVO;
import kr.co.stcreative.usrinfo.web.LoginController;

/**
 * <p>트렌드 조회 메인 컨트롤러.</p>
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
@Controller
@RequestMapping("/main")
public class TrendMainController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	//네이버 Api Service
	private ApiDatalabTrendService apiDatalabTrendService;
	private ApiDatalabKeywordService apiDatalabKeywordService;
	private ApiSearchService apiSearchService;
	
	//사용자 통계조회 이력 입력을 위한 service
	private TrendHstService trendHstService;
	
	@Autowired
	public TrendMainController(ApiDatalabTrendService apiDatalabTrendService
							  ,ApiDatalabKeywordService apiDatalabKeywordService
							  ,ApiSearchService apiSearchService
							  ,TrendHstService trendHstService) {
		
		this.apiDatalabTrendService=apiDatalabTrendService;
		this.apiDatalabKeywordService=apiDatalabKeywordService;
		this.apiSearchService=apiSearchService;
		this.trendHstService=trendHstService;
	}
	
	
	
	
	/**
	 * <p>"서비스 이용안내" 페이지로 이동한다.</p>
	 * 
	 * @param model : Model 객체. "서비스 이용안내" 페이지로 이동할 때 헤더 메뉴바의 active 효과를 위한 정보 저장
	 * @return "서비스 이용안내" 페이지의 view 이름을 문자열로 반환.
	 */
	@GetMapping("/info.do")
	public String goInfoPage(Model model) {
		
		model.addAttribute("currentMenu","info");
		
		return "main/TrendInfo";
	}
	
	/**
	 * <p>"트렌드 통계 조회" 페이지로 이동한다.</p>
	 * <p></p>
	 * 
	 * @param model : Model 객체. "트렌드 통계 조회" 페이지로 이동할 때 헤더 메뉴바의 active 효과를 위한 정보 저장
	 */
	@GetMapping("/inquirytrend.do")
	public String goInquiryTrend(Model model, HttpSession session) {
		
		// 세션에서 "future"속성을 가져와서 CompletableFuture<List<CrawlingData>> 타입으로 변환.
		CompletableFuture<List<CrawlingData>> future = (CompletableFuture<List<CrawlingData>>) session.getAttribute("future");
        
		// future의 비동기 작업(인기검색어 TOP100 크롤링)이 완료되면 그 결과를 model에 저장
		future.thenAccept(keywordInfoList -> model.addAttribute("keywordInfoList", keywordInfoList));
        
		
		model.addAttribute("currentMenu","inquirytrend");
		
		
		return "main/InquiryByTrend";
	}
	
	/**
	 * <p>주간 인기검색어 TOP100 데이터를 비동기식으로 페이징처리하는 메서드이다.</p>
	 * 
	 * @param page : view에서 인기검색어 출력 시 페이징처리를 위한 변수
	 * @param session : goMainPage메서드에서 세선에 저장한 인기검색어 TOP 100 크롤링 정보를 세션에서 가져오기 위한 객체.
	 * @return 페이지에 해당하는 인기 검색어 데이터 리스트를 반환
	 * @see LoginController#goMainPage(HttpSession)
	 */
	@GetMapping("/inquirytrendData.do")
    @ResponseBody
    public List<CrawlingData> getInquiryTrendData(@RequestParam("page") int page, HttpSession session) {
        CompletableFuture<List<CrawlingData>> future = (CompletableFuture<List<CrawlingData>>) session.getAttribute("future");
        
        // CompletableFuture가 완료될 때까지 대기
        List<CrawlingData> keywordInfoList = future.join();

        // 페이지에 알맞은 데이터를 반환
        int start = (page - 1) * 10;
        int end = Math.min(start + 10, keywordInfoList.size());
        return keywordInfoList.subList(start, end);
    }
	
	
	/**
	 * <p>트렌드 분석 요청 후 결과페이지로 이동한다</p>
	 * <p>결과조회에 필요한 데이터 가공</p>
	 * 
	 * 
	 * @param trendInquiryVO
	 * @param model : Model 객체. 통계조회 결과데이터, 추천상품 데이터, 이력저장을 위한 이력ID정보를 저장
	 * @param session : 세션에 저장된 회원정보와 
	 * 		해당 메서드에 인기검색어 top100 list에서 클릭으로 진입했을 경우에({@link #searchTopKeyword(Model, String, HttpSession)}) 세선에 저장된 trendInquiryVO객체를 가져옴
	 * @return "트렌드 통계 조회 결과" 페이지의 view 이름을 문자열로 반환.
	 */
	//@PostMapping("/inquiry.do")
	@RequestMapping(value = "/inquiry.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String inq(TrendInquiryVO trendInquiryVO, Model model, HttpSession session) {
		
		//조회수 top100 list에서 클릭으로 진입했을 경우, 세션에있는 trendInquiryVO값을 가져옴.
		if(trendInquiryVO.getCategoryName() == null && trendInquiryVO.getKeyword() ==null) {
			trendInquiryVO = (TrendInquiryVO) session.getAttribute("trendInquiryVO");
			session.removeAttribute("trendInquiryVO"); //사용 후 세션에서 제거
		}

		logger.info(trendInquiryVO.toString());
		//String result = apiDatalabTrendService.getTrendData(trendInquiryVO);
		
		//통계데이터 조회 API의 결과값을 담기위한 변수 result 선언
		String result;
		
		//검색어(keyword)값이 없을땐 일반 통계조회 API, 검색이가 있을땐 검색어 통계조회 API 이용
		if (trendInquiryVO.getKeyword() == null || trendInquiryVO.getKeyword().length == 0) {
			result = apiDatalabTrendService.getTrendData(trendInquiryVO);
		} else {
			// keyword 값이 있을 경우에는 검색어 통계조회 api 실행
			result = apiDatalabKeywordService.getTrendData(trendInquiryVO);
		}
		
		logger.info("*result: "+result);
		
		
		/* 상품추천을 위한 상품검색 api 실행 */
		//상품검색 api의 결과값을 담기위한 배열 searchData 선언
		String searchData[] = apiSearchService.getSearchData(trendInquiryVO);
		
		for(String data:searchData) {
			logger.info("*SearchData: "+data);
		}

		//JSON 형식의 문자열인 data를 Java의 Map<String, Object> 형태로 변환
		ObjectMapper mapper = new ObjectMapper();//Jackson 라이브러리에서 제공하는 클래스
		List<Map<String, Object>> list = new ArrayList<>();
		for (String data : searchData) {
		    try {
		        Map<String, Object> map = mapper.readValue(data, new TypeReference<Map<String, Object>>(){});
		        list.add(map);
		    } catch (JsonProcessingException e) {
		        e.printStackTrace();
		    }
		}
		
		//통계조회 결과데이터 model에 저장
		model.addAttribute("trendData", result);
		//추천상품 데이터 model에 저장
		model.addAttribute("searchData", list);
		
		/* 조회 이력 저장 */
		//이력정보 저장을 위한 TrendInqHstVO객체 선언
		TrendInqHstVO trendInqHstVO = new TrendInqHstVO();
		// trendInquiryVO의 데이터 일부를 trendInqHstVO에 저장
	    trendInqHstVO.setInqPrdBgngYmd(trendInquiryVO.getStartDate());
	    trendInqHstVO.setInqPrdEndYmd(trendInquiryVO.getEndDate());
	    trendInqHstVO.setInqPrdUnitCd(trendInquiryVO.getTimeUnit());
	    trendInqHstVO.setDeviceTypeCd(trendInquiryVO.getDevice());
	    trendInqHstVO.setSxdsCd(trendInquiryVO.getGender());
	    
	    //이력정보를 저장할 때 상품분류를 세부분류까지 합쳐서 저장하기위해 분류들의 빈값을 제외한 문자열을 생성
	    String gdsClsfOneNm = Stream.of(trendInquiryVO.getCategory1(), trendInquiryVO.getCategory2(), trendInquiryVO.getCategory3())
	    	    .filter(s -> !s.isEmpty())
	    	    .collect(Collectors.joining(">"));
	    String gdsClsfTwoNm = Stream.of(trendInquiryVO.getCategory1_2(), trendInquiryVO.getCategory2_2(), trendInquiryVO.getCategory3_2())
	    	    .filter(s -> !s.isEmpty())
	    	    .collect(Collectors.joining(">"));
    	String gdsClsfThrNm = Stream.of(trendInquiryVO.getCategory1_3(), trendInquiryVO.getCategory2_3(), trendInquiryVO.getCategory3_3())
	    	    .filter(s -> !s.isEmpty())
	    	    .collect(Collectors.joining(">"));

    	//상품분류정보 trendInqHstVO에 저장
    	trendInqHstVO.setGdsClsfOneNm(gdsClsfOneNm);
    	trendInqHstVO.setGdsClsfTwoNm(gdsClsfTwoNm);
    	trendInqHstVO.setGdsClsfThrNm(gdsClsfThrNm);
	    	
    	//session의 회원ID정보를 trendInqHstVO에 저장
	    UsrInfoVO userSession = (UsrInfoVO) session.getAttribute("user");
		trendInqHstVO.setUsrId(userSession.getUsrId());
		
		//keyword[]는 null일 수도 있는 값이므로, null이 아닐때만 이력VO에 저장
		if (trendInquiryVO.getKeyword() != null) {
			//String.join으로 배열형태 String keyword[]를 쉼표로 구분해서 저장
		    trendInqHstVO.setSrchKwrdCn(String.join(",", trendInquiryVO.getKeyword())); 
		}
		//age[]도 keyword[]와 동일하게 진행
		if (trendInquiryVO.getAges() != null) {
			trendInqHstVO.setAgeCd(String.join(",",trendInquiryVO.getAges()));
		}
		
		//검색일정보를 현재 날짜로 trendInqHstVO에 저장
		trendInqHstVO.setSrchDt(new Date());  
		
		//trendInqHstVO의 값들을 DB에 저장
		trendHstService.insertInqHst(trendInqHstVO);
		
		//결과페이지에서 사용자가 어떤 추천상품을 조회했는지를 저장하기위해 trendInqHstVO의 식별값을 model에 저장
		model.addAttribute("hstId",trendInqHstVO.getHstId());
		
		return "main/TrendResult";
	}
	
	/**
	 * <p>사용자가 조회한 추천상품정보를 저장한다.</p>
	 * 
	 * @param trendInqGdsHstVO
	 * @return 저장 성공 응답을 반환
	 */
	@PostMapping("/saveProductData.do")
	public ResponseEntity<Void> saveProductData(@RequestBody TrendInqGdsHstVO trendInqGdsHstVO) {
		
		//상품을 조회한 날짜를 현재날짜로 저장
		trendInqGdsHstVO.setGdsInqDt(new Date());
	    
		//상품조회정보를 이력테이블에 저장
		trendHstService.insertInqGdsHst(trendInqGdsHstVO);
	    
		//성공 응답을 반환
		return ResponseEntity.ok().build();  
	}
	
	/**
	 * <p>인기검색어 TOP100에서 상품명 클릭 시 데이터 가공 후 결과조회메서드로 리다이렉트하는 메서드이다</p>
	 * <p>해당 메서드로 상품조회 시, 조회할 기간정보는 최근 1개월로 지정</p>
	 * 
	 * @param keyword : 인기검색어 TOP100에서 상품명
	 * @param session : 가공한 데이터를 세션에 저장해두기 위한 객체
	 * @return 리다이렉트할 URL을 문자열로 반환
	 * @see #inq(TrendInquiryVO, Model, HttpSession)
	 */
	@GetMapping("/searchTopKeyword.do")
	public String searchTopKeyword(@RequestParam("keyword") String keyword, HttpSession session) {
		//날짜형식을 변환하기위한 DateTimeFormatter 객체선언과 패턴설정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		//오늘날짜와 한달 전 날짜를 변수로 지정
	    LocalDate today = LocalDate.now();
	    LocalDate oneMonthAgo = today.minusMonths(1);
	    
	    //날짜를 지정한 패턴으로 변환
	    String endDate = today.format(formatter);
	    String startDate = oneMonthAgo.format(formatter);
	    
	    //결과 조회 메서드로 리다이렉트를 위한 trendInquiryVO 객체 선언
		TrendInquiryVO trendInquiryVO = new TrendInquiryVO();
		
		//trendInquiryVO에 keyword, 날짜정보 저장
		trendInquiryVO.setKeyword(keyword);
		trendInquiryVO.setStartDate(startDate);
		trendInquiryVO.setEndDate(endDate);
		trendInquiryVO.setTimeUnit("date");
		
		
		/* 검색어 통계조회 API에 보낼 category정보 가져오기 */
		//category정보 추출을 위해 trendInquiryVO의 keyword값으로 검색API실행 후 결과데이터 저장
		String[] searchData = apiSearchService.getSearchData(trendInquiryVO);
		
		//JSON 형식의 문자열인 data를 Java의 Map<String, Object> 형태로 변환
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> list = new ArrayList<>();
		String category1 = "";
		for (String data : searchData) {
		    try {
		        Map<String, Object> map = mapper.readValue(data, new TypeReference<Map<String, Object>>(){});
		        list.add(map);
		        
		        //category값 추출: 결과데이터에 있는 items 배열의 첫번째 요소의 category1 값을 가져옴
		        if(list.size() == 1) {
		            List<Map<String, Object>> items = (List<Map<String, Object>>) map.get("items");
		            if(items != null && !items.isEmpty()) {
		                Map<String, Object> firstItem = items.get(0);
		                category1 = (String) firstItem.get("category1");
		            }
		        }
		    } catch (JsonProcessingException e) {
		        e.printStackTrace();
		    }
		}
		// list에서 categoryname, category1값 넣고 db에서 category1값으로 param값 조회해서 가져오기
		// 귀찮으면 그냥 redirect. 아니면 검색어 api실행하고 history 실행하고 결과페이지로 return
		
		//categoryParam값을 가져옴
		String categoryparam = apiSearchService.getCategoryparam(category1);
		
		//trendInquiryVO에 category정보 저장
		trendInquiryVO.setCategoryName(category1);
		trendInquiryVO.setCategory1(category1);
		trendInquiryVO.setCategoryParam(categoryparam);
		
		//세션에 trendInquiryVO 저장
		session.setAttribute("trendInquiryVO", trendInquiryVO);
		
		//결과조회 메서드로 리다이렉트
	    return "redirect:/main/inquiry.do";
	}
	
}
