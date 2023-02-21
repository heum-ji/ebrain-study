package com.ebrain.freeBoard.dao;

import com.ebrain.freeBoard.vo.BoardVo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BoardDao {
    /**
     * 게시물 전체 리스트 조회
     *
     * @return 조회된 게시물 전체 리스트
     */
    public List<BoardVo> selectBoardList(SqlSession sqlSession, String reqPage) {
        return sqlSession.selectList("board.selectBoardList", reqPage);
    }

    public int selectBoardCnt(SqlSession sqlSession) {
        return sqlSession.selectOne("board.selectBoardCnt");
    }
}
