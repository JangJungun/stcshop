package kr.co.stcreative.trend.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.stcreative.trend.main.mapper.TrendCatMapper;
import kr.co.stcreative.trend.main.service.TrendCatVO;
import kr.co.stcreative.trend.main.service.TrendCatService;

@Service
public class TrendCatServiceImpl implements TrendCatService{

	private TrendCatMapper trendCatMapper;
	
	@Autowired
	public TrendCatServiceImpl(TrendCatMapper trendCatMapper) {
		this.trendCatMapper=trendCatMapper;
	}
	
	@Override
	public List<TrendCatVO> selectOptionsOne() {
		return trendCatMapper.selectOptionsOne();
	}

	@Override
	public List<TrendCatVO> selectOptionsTwo(TrendCatVO vo) {
		return trendCatMapper.selectOptionsTwo(vo);
	}

	@Override
	public List<TrendCatVO> selectOptionsThr(TrendCatVO vo) {
		return trendCatMapper.selectOptionsThr(vo);
	}

	
	
}
