package cn.xqxls.mybatis.test;

import cn.xqxls.mybatis.io.Resources;
import cn.xqxls.mybatis.session.SqlSession;
import cn.xqxls.mybatis.session.SqlSessionFactory;
import cn.xqxls.mybatis.session.SqlSessionFactoryBuilder;
import cn.xqxls.mybatis.test.dao.IUserDao;
import cn.xqxls.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


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
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }


}
