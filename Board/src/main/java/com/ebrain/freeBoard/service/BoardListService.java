package com.ebrain.freeBoard.service;

import com.ebrain.freeBoard.dao.BoardDao;
import com.ebrain.freeBoard.vo.BoardVo;
import com.ebrain.freeBoard.vo.ReturnVo;
import common.SqlSessionTemplate;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 게시판 목록 조회 서비스
 */
public class BoardListService implements IService {

    /**
     * 비즈니스 로직 처리
     * - 검색 하지 않은 경우
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     *
     * @return 화면에 필요한 정보
     */
    @Override
    public ReturnVo<BoardVo> process(HttpServletRequest request, HttpServletResponse response) {
        // 비즈니스 처리 후 리턴 Vo
        ReturnVo<BoardVo> returnVo = new ReturnVo<>();

        // 파라미터 추출
        String reqPage = request.getParameter("reqPage");

        // 게시판 전체 목록 조회
        returnVo.setList(this.selectBoardList(reqPage));
        returnVo.setTotalCnt(this.selectBoardCnt());
        returnVo.setPageName(request.getRequestURI());
        returnVo.setRedirectYn("N");

        return returnVo;
    }

    /**
     * 게시판 목록 조회
     * - 검색 하지 않은 경우
     *
     * @param reqPage
     *
     * @return 조회된 게시판 목록
     */
    private List<BoardVo> selectBoardList(String reqPage) {
        // try-with-resources : try에 Resource 객체를 전달하면 try 블록이 끝날 때 자동으로 Resource를 종료 해줌
        try (SqlSession sqlSession = SqlSessionTemplate.getSqlSessionFactory().openSession()) {
            return new BoardDao().selectBoardList(sqlSession, reqPage);
        }
    }

    private int selectBoardCnt() {
        // try-with-resources : try에 Resource 객체를 전달하면 try 블록이 끝날 때 자동으로 Resource를 종료 해줌
        try (SqlSession sqlSession = SqlSessionTemplate.getSqlSessionFactory().openSession()) {
            return new BoardDao().selectBoardCnt(sqlSession);
        }
    }
}
