package kr.co.stcreative.trend.hst.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.stcreative.trend.hst.mapper.TrendHstGdsMapper;
import kr.co.stcreative.trend.hst.mapper.TrendHstMapper;
import kr.co.stcreative.trend.hst.service.TrendHstService;
import kr.co.stcreative.trend.hst.service.TrendInqGdsHstVO;
import kr.co.stcreative.trend.hst.service.TrendInqHstVO;

/**
 * <p>트렌드 조회이력 서비스 인터페이스의 구현체</p>
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
public class TrendHstServiceImpl implements TrendHstService {

	private TrendHstMapper trendHstMapper;
	private TrendHstGdsMapper trendHstGdsMapper; 
	private EgovIdGnrService objectIdGnrService;
	private EgovIdGnrService objectIdGnrService2;
	
	@Autowired
	public TrendHstServiceImpl(TrendHstMapper trendHstMapper
							  ,@Qualifier("egovTrndInqHstIdGnrService") EgovIdGnrService objectIdGnrService
							  ,@Qualifier("egovGdsInqHstIdGnrService") EgovIdGnrService objectIdGnrService2
							  ,TrendHstGdsMapper trendHstGdsMapper) {
		this.trendHstMapper=trendHstMapper;
		this.objectIdGnrService=objectIdGnrService;
		this.trendHstGdsMapper=trendHstGdsMapper;
		this.objectIdGnrService2=objectIdGnrService2;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void insertInqHst(TrendInqHstVO vo) {
		
		//EgovIdGnrService를 이용해서 Id값 생성
		try {
			String nextId = objectIdGnrService.getNextStringId();
			vo.setHstId(nextId);
		} catch (FdlException e) {
			e.printStackTrace();
		}
		
		trendHstMapper.insertInqHst(vo);
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void insertInqGdsHst(TrendInqGdsHstVO vo) {
		
		//EgovIdGnrService를 이용해서 Id값 생성
		try {
			String nextId = objectIdGnrService2.getNextStringId();
			vo.setGdsHstId(nextId);
		} catch (FdlException e) {
			e.printStackTrace();
		}
		
		trendHstGdsMapper.insertInqGdsHst(vo);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public List<TrendInqHstVO> selectHstById(String id) {
		
		List<TrendInqHstVO> hstList = trendHstMapper.selectHstById(id);
		
		return hstList;
	}

}
