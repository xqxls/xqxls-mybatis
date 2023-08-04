package cn.xqxls.mybatis.session.defaults;

import cn.xqxls.mybatis.session.Configuration;
import cn.xqxls.mybatis.session.SqlSession;
import cn.xqxls.mybatis.session.SqlSessionFactory;

/**
 * @author xqxls
 * @create 2023-08-04 14:09
 * @Description
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}