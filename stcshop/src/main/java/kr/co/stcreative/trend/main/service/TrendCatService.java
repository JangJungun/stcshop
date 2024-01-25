package kr.co.stcreative.trend.main.service;

import java.util.List;

public interface TrendCatService {

	List<TrendCatVO> selectOptionsOne();
    
	List<TrendCatVO> selectOptionsTwo(TrendCatVO vo);
    
	List<TrendCatVO> selectOptionsThr(TrendCatVO vo);
	
}
