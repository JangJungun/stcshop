package kr.co.stcreative.trend.main.service;

import java.util.List;

@Deprecated
public class SearchResult {
	private List<SearchProductVO> items;

    // getter and setter
    public List<SearchProductVO> getItems() {
        return items;
    }

    public void setItems(List<SearchProductVO> items) {
        this.items = items;
    }
}
