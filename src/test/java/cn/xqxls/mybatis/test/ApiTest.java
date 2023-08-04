package cn.xqxls.mybatis.test;

import cn.xqxls.mybatis.io.Resources;
import cn.xqxls.mybatis.session.SqlSession;
import cn.xqxls.mybatis.session.SqlSessionFactory;
import cn.xqxls.mybatis.session.SqlSessionFactoryBuilder;
import cn.xqxls.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;


/**
 * @author xqxls
 * @create 2023-08-03 17:10
 * @Description
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);
    }

}
