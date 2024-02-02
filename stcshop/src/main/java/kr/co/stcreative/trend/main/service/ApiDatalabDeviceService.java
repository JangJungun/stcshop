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

@Service
@Deprecated
public class ApiDatalabDeviceService {
	
	//분야별 device 조회
	//검색어별 device 조회
	//category, 검색어는 1개씩만 입력가능.
	//검색어도 category입력 필수
	@Value("${naver.client.id}") 
    private String clientId;
	@Value("${naver.client.secret}") 
    private String clientSecret;
	
	//분류 기기 조회
	private String apiUrl = "https://openapi.naver.com/v1/datalab/shopping/category/device";
	
	//검색어 기기 조회
	private String apiKeywordUrl = "https://openapi.naver.com/v1/datalab/shopping/category/keyword/device";
	
	
	public String getTrendData(TrendInquiryVO inquiryData) {
    	System.out.println("in ApiDatalabTrendService");
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        requestHeaders.put("Content-Type", "application/json");

        String requestBody = makeRequestBody(inquiryData);
        
        String Url="";
        if(inquiryData.getKeyword()==null) Url=apiUrl;
        else Url=apiKeywordUrl;
        
        return post(Url, requestHeaders, requestBody);
    }
	
	private static String makeRequestBody(TrendInquiryVO inquiryData) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"startDate\":\"").append(inquiryData.getStartDate()).append("\",");
        sb.append("\"endDate\":\"").append(inquiryData.getEndDate()).append("\",");
        sb.append("\"timeUnit\":\"").append(inquiryData.getTimeUnit()).append("\",");
        
        sb.append("\"category\":\"").append(inquiryData.getCategoryParam()).append("\",");
        

        sb.append("\"device\":\"").append(inquiryData.getDevice()).append("\",");
        sb.append("\"ages\":").append(arrayToJson(inquiryData.getAges())).append(",");
        sb.append("\"gender\":\"").append(inquiryData.getGender()).append("\"");
        sb.append("}");

        return sb.toString();
    }
	
	// String 배열을 JSON 배열 형식의 문자열로 변환합니다.
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
