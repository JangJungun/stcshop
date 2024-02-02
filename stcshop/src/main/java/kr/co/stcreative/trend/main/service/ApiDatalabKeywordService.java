package kr.co.stcreative.trend.main.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>Naver 트렌드 검색어조회 Api Service</p>
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
public class ApiDatalabKeywordService {

	@Value("${naver.client.id}") 
    private String clientId;
	@Value("${naver.client.secret}") 
    private String clientSecret;

    private String apiUrl= "https://openapi.naver.com/v1/datalab/shopping/category/keywords";

    /**
     * <p>트렌드 검색어 조회를 위한 Naver API를 호출한다.</p>
     *
     *
     * @param inquiryData 트렌드 조회를 위한 요청 데이터를 담은 TrendInquiryVO 객체이다.
     * 조회 기간, 카테고리, 검색어 등의 정보가 포함된다
     * 
     * @return Naver API의 응답을 문자열 형태로 반환한다. 트렌드 정보가 JSON 형태로 포함된다.
     */
    public String getTrendData(TrendInquiryVO inquiryData) {
    	System.out.println("in ApiDatalabKeywordService");
        
    	
    	
    	Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        requestHeaders.put("Content-Type", "application/json");

        String requestBody = makeRequestBody(inquiryData);
        return post(apiUrl, requestHeaders, requestBody);
    }
	
    /**
     * <p>트렌드 검색어 조회를 위한 Naver API 요청 본문을 생성한다.</p>
     * 
     * 
	 * @param inquiryData 트렌드 조회를 위한 요청 데이터를 담은 TrendInquiryVO 객체이다.
	 * 조회 기간, 카테고리, 검색어 등의 정보가 포함된다
	 * 
	 * @return Naver API 요청 본문을 문자열 형태로 반환한다. 이 요청 본문은 형태의 문자열로, 
	 * API에 필요한 파라미터들을 포함한다.
     */
    private static String makeRequestBody(TrendInquiryVO inquiryData) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("{");
        sb.append("\"startDate\":\"").append(inquiryData.getStartDate()).append("\",");
        sb.append("\"endDate\":\"").append(inquiryData.getEndDate()).append("\",");
        sb.append("\"timeUnit\":\"").append(inquiryData.getTimeUnit()).append("\",");
        sb.append("\"category\":\"").append(inquiryData.getCategoryParam()).append("\",");

        sb.append("\"keyword\":[");
        for (int i = 0; i < inquiryData.getKeyword().length; i++) {
            sb.append("{\"name\":\"").append(inquiryData.getKeyword()[i]).append("\",");
            sb.append("\"param\":[\"").append(inquiryData.getKeyword()[i]).append("\"]}");
            if (i < inquiryData.getKeyword().length - 1) {
                sb.append(",");
            }
        }
        sb.append("],");

        if(inquiryData.getDevice() != null)
        	sb.append("\"device\":\"").append(inquiryData.getDevice()).append("\",");
        
        if(inquiryData.getGender() != null)
        	sb.append("\"gender\":\"").append(inquiryData.getGender()).append("\",");

        sb.append("\"ages\":").append(arrayToJson(inquiryData.getAges()));
        sb.append("}");
        
        System.out.println(sb);
        return sb.toString();
    }


    /**
     * <p>문자열 배열을 JSON 배열 형식의 문자열로 변환한다.</p>
	 *
	 *
	 * @param array JSON 배열 형식의 문자열로 변환할 문자열 배열
	 * 
	 * @return JSON 배열 형식의 문자열을 반환한다. 입력 배열이 null이거나 빈 배열일 경우, 빈 JSON 배열("[]")을 반환한다.
     */
    private static String arrayToJson(String[] array) {
        if (array == null || array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append("\"").append(array[i]).append("\"");
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * <p>Naver API에 POST 요청을 보낸다.</p>
     *
     *
     * @param apiUrl API 요청을 보낼 URL.
     * @param requestHeaders API 요청에 포함할 HTTP 헤더들을 담은 Map. 
     * 이 Map의 키는 헤더의 이름이고, 값은 헤더의 값이다.
     * @param requestBody API 요청 본문을 담은 문자열.
     * 
     * @return API의 응답 본문을 문자열 형태로 반환. API 요청이 성공하면 정상 응답 본문을, 실패하면 에러 응답 본문을 반환한다.
     */
    private static String post(String apiUrl, Map<String, String> requestHeaders, String requestBody) {
        HttpURLConnection con = connect(apiUrl);

        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(requestBody.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect(); // Connection을 재활용할 필요가 없는 프로세스일 경우
        }
    }

    /**
     * <p>주어진 URL에 HTTP연결을 초기화한다.</p>
     *
     *
     * @param apiUrl HTTP연결을 초기화할 URL.
     * 
     * @return 생성된 HttpURLConnection 객체를 반환.
     * @throws RuntimeException API URL이 잘못된 경우, 혹은 연결에 실패한 경우 RuntimeException을 발생시킨다.
     */
    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    /**
     * <p>주어진 InputStream에서 API 응답 본문을 읽고, 문자열로 반환한다.</p>
     *
     * @param body: API 응답 본문을 담은 InputStream.
     *
     * @return API 응답 본문을 문자열 형태로 반환한다. 
     * InputStream에서 응답 본문을 읽는 데 실패한 경우 RuntimeException을 발생시킨다.
     */
    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body, StandardCharsets.UTF_8);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
