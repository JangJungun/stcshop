package kr.co.stcreative.trend.main.mapper;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.stcreative.trend.main.service.TrendCatVO;

@Mapper("TrendCatMapper")
public interface TrendCatMapper {

	List<TrendCatVO> selectOptionsOne();
	
	List<TrendCatVO> selectOptionsTwo(TrendCatVO vo);
	
	List<TrendCatVO> selectOptionsThr(TrendCatVO vo);
	
}
