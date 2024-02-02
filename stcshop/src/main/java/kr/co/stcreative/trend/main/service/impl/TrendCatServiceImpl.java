package kr.co.stcreative.trend.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.stcreative.trend.main.mapper.TrendCatMapper;
import kr.co.stcreative.trend.main.service.TrendCatVO;
import kr.co.stcreative.trend.main.service.TrendCatService;

/**
 * <p>트렌드 카테고리 서비스 인터페이스의 구현체</p>
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
public class TrendCatServiceImpl implements TrendCatService{

	private TrendCatMapper trendCatMapper;
	
	@Autowired
	public TrendCatServiceImpl(TrendCatMapper trendCatMapper) {
		this.trendCatMapper=trendCatMapper;
	}
	
	/**
	 * {@inheritDoc}
	 * <p>대분류값을 데이터베이스에서 조회하여 반환</p>
	 */
	@Override
	public List<TrendCatVO> selectOptionsOne() {
		return trendCatMapper.selectOptionsOne();
	}

	/**
	 * {@inheritDoc}
	 * <p>중분류값을 데이터베이스에서 조회하여 반환</p>
	 */
	@Override
	public List<TrendCatVO> selectOptionsTwo(TrendCatVO vo) {
		return trendCatMapper.selectOptionsTwo(vo);
	}

	/**
	 * {@inheritDoc}
	 * <p>소분류값을 데이터베이스에서 조회하여 반환</p>
	 */
	@Override
	public List<TrendCatVO> selectOptionsThr(TrendCatVO vo) {
		return trendCatMapper.selectOptionsThr(vo);
	}

	
	
}
