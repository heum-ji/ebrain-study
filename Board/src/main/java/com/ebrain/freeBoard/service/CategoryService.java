package com.ebrain.freeBoard.service;

import com.ebrain.freeBoard.dao.CategoryDao;
import com.ebrain.freeBoard.vo.CategoryVo;
import common.SqlSessionTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 카테고리 서비스
 */
@Slf4j
public class CategoryService implements IService {

    /**
     * 카테고리 전체 리스트 조회
     *
     * @return 조회된 카테고리 전체 리스트
     */
    public List<CategoryVo> selectCategoryList() {
        // try-with-resources : try에 Resource 객체를 전달하면 try 블록이 끝날 때 자동으로 Resource를 종료 해줌
        try (SqlSession sqlSession = SqlSessionTemplate.getSqlSessionFactory().openSession()) {
            List<CategoryVo> list = new CategoryDao().selectCategoryList(sqlSession);

            for (CategoryVo cv : list) {
                log.debug("카테고리번호 : {}, 카테고리이름 : {}", cv.getCategoryNo(), cv.getName());
            }
            return list;
        }
    }
}
