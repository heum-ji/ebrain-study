package common;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis SqlSessionFactory 관리용 공통 클래스
 */
@Slf4j
public class SqlSessionTemplate {
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 생성자 외부 접근 방지
     */
    private SqlSessionTemplate() {

    }

    /**
     * SqlSessionFactory Instance 생성 (Singleton)
     *
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        // 처음 생성하는 경우
        if (sqlSessionFactory == null) {
            String resource = "./mybatis/mybatis-config.xml";

            try {
                InputStream is = Resources.getResourceAsStream(resource); // mybatis-config.xml 읽기
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is); // SqlSessionFactory 생성
            } catch (IOException e) {
                log.error("error : ", e);
            }
        }
        // 처음이 아닌경우 기존에 생성된 sqlSessionFactory 리턴
        return sqlSessionFactory;
    }

}
