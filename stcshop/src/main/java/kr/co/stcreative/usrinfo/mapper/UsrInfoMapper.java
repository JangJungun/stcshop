package kr.co.stcreative.usrinfo.mapper;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.stcreative.usrinfo.service.UsrInfoVO;

@Mapper
public interface UsrInfoMapper {
	
	UsrInfoVO getUserByUsrId(String id);
	
	int modifyUsrInfo(UsrInfoVO usrInfoVO);
	
}
