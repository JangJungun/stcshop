#아래순서로 테이블생성 및 기초데이터 입력 

# ID Generation
insert into IDS(TABLE_NAME,NEXT_ID) values ('BBS_ID',1);
insert into IDS(TABLE_NAME,NEXT_ID) values ('FILE_ID',1);
insert into IDS(TABLE_NAME,NEXT_ID) values ('SAMPLE',1);
insert into IDS(TABLE_NAME,NEXT_ID) values ('SCHDUL_ID',1);
insert into IDS(TABLE_NAME,NEXT_ID) values ('TMPLAT_ID',1);
    

#분류코드
INSERT INTO STCTCCMMNCLCODE(CL_CODE,CL_CODE_NM,CL_CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) VALUES ('STC','STC모의프로젝트','STC모의프로젝트 분류코드','Y',NOW(),'SYSTEM',NOW(),'SYSTEM'); ​

# 공통코드
INSERT INTO STCTCCMMNCODE(CODE_ID,CODE_ID_NM,CODE_ID_DC,USE_AT,CL_CODE,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('SXDS_CD','성별코드','성별구분코드','Y','STC',NOW(),'SYSTEM',NOW(),'SYSTEM');

INSERT INTO STCTCCMMNCODE(CODE_ID,CODE_ID_NM,CODE_ID_DC,USE_AT,CL_CODE,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('AGE_CODE','연령코드','연령구분코드','Y','STC',NOW(),'SYSTEM',NOW(),'SYSTEM');

INSERT INTO STCTCCMMNCODE(CODE_ID,CODE_ID_NM,CODE_ID_DC,USE_AT,CL_CODE,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('RPTP_SPRTN_CD','보고서구분코드','보고서구분코드','Y','STC',NOW(),'SYSTEM',NOW(),'SYSTEM');


# 공통상세코드
INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('SXDS_CD','M','남성','남성','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');

INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('SXDS_CD','F','여성','여성','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');

INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('AGE_CODE','100','10대','10대','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');

INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('AGE_CODE','200','20대','20대','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');

INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('AGE_CODE','300','30대','30대','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');

INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('AGE_CODE','400','40대','40대','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');

INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('AGE_CODE','500','50대','50대','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');

INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('AGE_CODE','600','60대 이상','60대 이상','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');

INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('AGE_CODE','999','전체','연령전체','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');

INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('RPTP_SPRTN_CD','R01','기간 트렌드분석 보고서','기간 트렌드분석 보고서','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');

INSERT INTO STCTCCMMNDETAILCODE(CODE_ID,CODE,CODE_NM,CODE_DC,USE_AT,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) 
VALUES ('RPTP_SPRTN_CD','R02','기간 사용자분석 보고서','기간 사용자분석 보고서','Y', NOW(),'SYSTEM', NOW(),'SYSTEM');



# 조직정보
insert into STCTNORGNZTINFO(ORGNZT_ID,ORGNZT_NM,ORGNZT_DC) values ('ORGNZT_0000000000000','기본조직','기본조직');


# 그룹정보
insert into STCTNAUTHORGROUPINFO(GROUP_ID,GROUP_NM,GROUP_CREAT_DE,GROUP_DC) values ('GROUP_00000000000000','기본 그룹입니다','2011-08-02 21:01:59','기본 그룹');

# 사용자정보
insert into STCTNEMPLYRINFO(EMPLYR_ID,ORGNZT_ID,USER_NM,PASSWORD,EMPL_NO,IHIDNUM,SEXDSTN_CODE,BRTHDY,FXNUM,HOUSE_ADRES,PASSWORD_HINT,PASSWORD_CNSR,HOUSE_END_TELNO,AREA_NO,DETAIL_ADRES,ZIP,OFFM_TELNO,MBTLNUM,EMAIL_ADRES,OFCPS_NM,HOUSE_MIDDLE_TELNO,GROUP_ID,PSTINST_CODE,EMPLYR_STTUS_CODE,ESNTL_ID,CRTFC_DN_VALUE,SBSCRB_DE) values ('admin','ORGNZT_0000000000000','관리자','JfQ7FIatlaE5jj7rPYO8QBABX8yb7bNbQy4AKY1QIfc=','','','F','','','관리자 주소','','','','','','','','','','','','GROUP_00000000000000','00000000','P','USRCNFRM_00000000000','','2011-08-02 21:01:59');

# 게시판템플릿
insert into STCTNTMPLATINFO(TMPLAT_ID,TMPLAT_NM,TMPLAT_COURS,USE_AT,TMPLAT_SE_CODE,FRST_REGISTER_ID,FRST_REGIST_PNTTM,LAST_UPDUSR_ID,LAST_UPDT_PNTTM) values ('TMPLAT_BOARD_DEFAULT','게시판 기본템플릿','/css/egovframework/cop/bbs/egovbbsTemplate.css','Y','TMPT01','USRCNFRM_00000000000','2011-08-02 21:01:59','USRCNFRM_00000000000','2011-08-08 16:12:57');


# 게시판마스터
insert into STCTNBBSMASTER(BBS_ID,BBS_NM,BBS_INTRCN,BBS_TY_CODE,BBS_ATTRB_CODE,REPLY_POSBL_AT,FILE_ATCH_POSBL_AT,ATCH_POSBL_FILE_NUMBER,ATCH_POSBL_FILE_SIZE,USE_AT,TMPLAT_ID,FRST_REGISTER_ID,FRST_REGIST_PNTTM,LAST_UPDUSR_ID,LAST_UPDT_PNTTM) values ('BBSMSTR_AAAAAAAAAAAA','공지사항','공지사항게시판','BBST03','BBSA03','Y','Y',2,5242880,'Y','TMPLAT_BOARD_DEFAULT','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00');
insert into STCTNBBSMASTER(BBS_ID,BBS_NM,BBS_INTRCN,BBS_TY_CODE,BBS_ATTRB_CODE,REPLY_POSBL_AT,FILE_ATCH_POSBL_AT,ATCH_POSBL_FILE_NUMBER,ATCH_POSBL_FILE_SIZE,USE_AT,TMPLAT_ID,FRST_REGISTER_ID,FRST_REGIST_PNTTM,LAST_UPDUSR_ID,LAST_UPDT_PNTTM) values ('BBSMSTR_BBBBBBBBBBBB','갤러리','갤러리게시판','BBST01','BBSA02','Y','Y',2,5242880,'Y','TMPLAT_BOARD_DEFAULT','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00');
insert into STCTNBBSMASTER(BBS_ID,BBS_NM,BBS_INTRCN,BBS_TY_CODE,BBS_ATTRB_CODE,REPLY_POSBL_AT,FILE_ATCH_POSBL_AT,ATCH_POSBL_FILE_NUMBER,ATCH_POSBL_FILE_SIZE,USE_AT,TMPLAT_ID,FRST_REGISTER_ID,FRST_REGIST_PNTTM,LAST_UPDUSR_ID,LAST_UPDT_PNTTM) values ('BBSMSTR_CCCCCCCCCCCC','자료실','자료실게시판','BBST01','BBSA03','Y','Y',2,5242880,'Y','TMPLAT_BOARD_DEFAULT','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00');


# 게시판사용
insert into STCTNBBSUSE(BBS_ID,TRGET_ID,USE_AT,REGIST_SE_CODE,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values ('BBSMSTR_AAAAAAAAAAAA','SYSTEM_DEFAULT_BOARD','Y','REGC01','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-09-05 18:15:31','');
insert into STCTNBBSUSE(BBS_ID,TRGET_ID,USE_AT,REGIST_SE_CODE,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values ('BBSMSTR_BBBBBBBBBBBB','SYSTEM_DEFAULT_BOARD','Y','REGC01','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000');
insert into STCTNBBSUSE(BBS_ID,TRGET_ID,USE_AT,REGIST_SE_CODE,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values ('BBSMSTR_CCCCCCCCCCCC','SYSTEM_DEFAULT_BOARD','Y','REGC01','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000');

# 게시물
insert into STCTNBBS(NTT_ID,BBS_ID,NTT_NO,NTT_SJ,NTT_CN,ANSWER_AT,PARNTSCTT_NO,ANSWER_LC,SORT_ORDR,RDCNT,USE_AT,NTCE_BGNDE,NTCE_ENDDE,NTCR_ID,NTCR_NM,PASSWORD,ATCH_FILE_ID,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values (1,'BBSMSTR_AAAAAAAAAAAA',1,'홈페이지 샘플공지1','홈페이지 샘플공지1','N',0,0,2,0,'Y','10000101','99991231','','','',null,NOW(),'USRCNFRM_00000000000',null,null);
insert into STCTNBBS(NTT_ID,BBS_ID,NTT_NO,NTT_SJ,NTT_CN,ANSWER_AT,PARNTSCTT_NO,ANSWER_LC,SORT_ORDR,RDCNT,USE_AT,NTCE_BGNDE,NTCE_ENDDE,NTCR_ID,NTCR_NM,PASSWORD,ATCH_FILE_ID,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values (2,'BBSMSTR_AAAAAAAAAAAA',1,'홈페이지 샘플공지2','홈페이지 샘플공지2','N',0,0,2,0,'Y','10000101','99991231','','','',null,NOW(),'USRCNFRM_00000000000',null,null);
insert into STCTNBBS(NTT_ID,BBS_ID,NTT_NO,NTT_SJ,NTT_CN,ANSWER_AT,PARNTSCTT_NO,ANSWER_LC,SORT_ORDR,RDCNT,USE_AT,NTCE_BGNDE,NTCE_ENDDE,NTCR_ID,NTCR_NM,PASSWORD,ATCH_FILE_ID,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values (3,'BBSMSTR_AAAAAAAAAAAA',1,'홈페이지 샘플공지3','홈페이지 샘플공지3','N',0,0,2,0,'Y','10000101','99991231','','','',null,NOW(),'USRCNFRM_00000000000',null,null);
insert into STCTNBBS(NTT_ID,BBS_ID,NTT_NO,NTT_SJ,NTT_CN,ANSWER_AT,PARNTSCTT_NO,ANSWER_LC,SORT_ORDR,RDCNT,USE_AT,NTCE_BGNDE,NTCE_ENDDE,NTCR_ID,NTCR_NM,PASSWORD,ATCH_FILE_ID,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values (4,'BBSMSTR_AAAAAAAAAAAA',1,'홈페이지 샘플공지4','홈페이지 샘플공지4','N',0,0,2,0,'Y','10000101','99991231','','','',null,NOW(),'USRCNFRM_00000000000',null,null);
insert into STCTNBBS(NTT_ID,BBS_ID,NTT_NO,NTT_SJ,NTT_CN,ANSWER_AT,PARNTSCTT_NO,ANSWER_LC,SORT_ORDR,RDCNT,USE_AT,NTCE_BGNDE,NTCE_ENDDE,NTCR_ID,NTCR_NM,PASSWORD,ATCH_FILE_ID,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values (5,'BBSMSTR_AAAAAAAAAAAA',1,'홈페이지 샘플공지5','홈페이지 샘플공지5','N',0,0,2,0,'Y','10000101','99991231','','','',null,NOW(),'USRCNFRM_00000000000',null,null);

insert into STCTNBBS(NTT_ID,BBS_ID,NTT_NO,NTT_SJ,NTT_CN,ANSWER_AT,PARNTSCTT_NO,ANSWER_LC,SORT_ORDR,RDCNT,USE_AT,NTCE_BGNDE,NTCE_ENDDE,NTCR_ID,NTCR_NM,PASSWORD,ATCH_FILE_ID,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values (6,'BBSMSTR_BBBBBBBBBBBB',1,'홈페이지 샘플게시1','홈페이지 샘플게시1','N',0,0,2,0,'Y','10000101','99991231','','','',null,NOW(),'USRCNFRM_00000000000',null,null);
insert into STCTNBBS(NTT_ID,BBS_ID,NTT_NO,NTT_SJ,NTT_CN,ANSWER_AT,PARNTSCTT_NO,ANSWER_LC,SORT_ORDR,RDCNT,USE_AT,NTCE_BGNDE,NTCE_ENDDE,NTCR_ID,NTCR_NM,PASSWORD,ATCH_FILE_ID,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values (7,'BBSMSTR_BBBBBBBBBBBB',1,'홈페이지 샘플게시2','홈페이지 샘플게시2','N',0,0,2,0,'Y','10000101','99991231','','','',null,NOW(),'USRCNFRM_00000000000',null,null);
insert into STCTNBBS(NTT_ID,BBS_ID,NTT_NO,NTT_SJ,NTT_CN,ANSWER_AT,PARNTSCTT_NO,ANSWER_LC,SORT_ORDR,RDCNT,USE_AT,NTCE_BGNDE,NTCE_ENDDE,NTCR_ID,NTCR_NM,PASSWORD,ATCH_FILE_ID,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values (8,'BBSMSTR_BBBBBBBBBBBB',1,'홈페이지 샘플게시3','홈페이지 샘플게시3','N',0,0,2,0,'Y','10000101','99991231','','','',null,NOW(),'USRCNFRM_00000000000',null,null);
insert into STCTNBBS(NTT_ID,BBS_ID,NTT_NO,NTT_SJ,NTT_CN,ANSWER_AT,PARNTSCTT_NO,ANSWER_LC,SORT_ORDR,RDCNT,USE_AT,NTCE_BGNDE,NTCE_ENDDE,NTCR_ID,NTCR_NM,PASSWORD,ATCH_FILE_ID,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values (9,'BBSMSTR_BBBBBBBBBBBB',1,'홈페이지 샘플게시4','홈페이지 샘플게시4','N',0,0,2,0,'Y','10000101','99991231','','','',null,NOW(),'USRCNFRM_00000000000',null,null);
insert into STCTNBBS(NTT_ID,BBS_ID,NTT_NO,NTT_SJ,NTT_CN,ANSWER_AT,PARNTSCTT_NO,ANSWER_LC,SORT_ORDR,RDCNT,USE_AT,NTCE_BGNDE,NTCE_ENDDE,NTCR_ID,NTCR_NM,PASSWORD,ATCH_FILE_ID,FRST_REGIST_PNTTM,FRST_REGISTER_ID,LAST_UPDT_PNTTM,LAST_UPDUSR_ID) values (10,'BBSMSTR_BBBBBBBBBBBB',1,'홈페이지 샘플게시5','홈페이지 샘플게시5','N',0,0,2,0,'Y','10000101','99991231','','','',null,NOW(),'USRCNFRM_00000000000',null,null);
