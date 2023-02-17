package com.ebrain.freeBoard.service;

import com.ebrain.freeBoard.dao.CategoryDao;
import com.ebrain.freeBoard.vo.CategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class CategoryService {

    /**
     * SqlSession 생성
     * - SqlSession의 인스턴스는 공유되지 않기 때문에 사용할 때마다 새로 생성해서 사용해야 함
     * - static 필드 혹은 클래스의 인스턴스 필드로 지정해서는 안된다.
     *
     * @return 생성된 SqlSession
     */
    private SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        String resource = "./mybatis/mybatis-config.xml";

        try {
            InputStream is = Resources.getResourceAsStream(resource); // mybatis-config.xml 읽기
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is); // sqlSession 생성

            sqlSession = factory.openSession(false); // auto commit 해제를 위한 false 값 전달
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

    /**
     * 카테고리 전체 리스트 조회
     *
     * @return 조회된 카테고리 전체 리스트
     */
    public List<CategoryVo> selectCategoryList() {
        SqlSession sqlSession = this.getSqlSession();
        List<CategoryVo> list = new CategoryDao().selectCategoryList(sqlSession);

        sqlSession.close();

        for (CategoryVo cv : list) {
            log.debug("카테고리번호 : {}, 카테고리이름 : {}", cv.getCategoryNo(), cv.getName());
        }

        return list;
    }
}
