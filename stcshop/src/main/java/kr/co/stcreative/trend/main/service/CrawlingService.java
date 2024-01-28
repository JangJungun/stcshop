package kr.co.stcreative.trend.main.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CrawlingService {
	public List<NaverShopProduct> getProducts(String categoryId) {
        List<NaverShopProduct> products = new ArrayList<>();
        
        try {
            Document doc = Jsoup.connect("https://search.shopping.naver.com/search/category?catId=" + categoryId + "&sort=review_rel").get();
            Elements items = doc.select(".basicList_item__2XT81");

            for (Element item : items) {
                
            	String imageLink = "";
            	
            	String prductUrl = "";
            	
            	String productNm = "";
            	
            	String productPrice = "";
            	
            	String category1 = "";
            	
            	String category2 = "";
            	
            	String category3 = "";
            	
            	String productNum = "";
            	
            	String reviewCount = "";
            	
            	String productRegDt = "";
            	
                NaverShopProduct product = new NaverShopProduct(imageLink, prductUrl, productNm, productPrice, category1, category2, category3, productNum, reviewCount, productRegDt);
                products.add(product);

                if (products.size() >= 6) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}
