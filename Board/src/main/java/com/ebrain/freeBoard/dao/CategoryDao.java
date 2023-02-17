package com.ebrain.freeBoard.dao;

import com.ebrain.freeBoard.vo.CategoryVo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryDao {

    /**
     * 카테고리 전체 리스트 조회
     *
     * @return 조회된 카테고리 전체 리스트
     */
    public List<CategoryVo> selectCategoryList(SqlSession sqlSession) {
        return sqlSession.selectList("category.selectCategoryList");
    }
}
