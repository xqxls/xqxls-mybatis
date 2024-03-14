package cn.xqxls.mybatis.session.defaults;

import cn.xqxls.mybatis.executor.Executor;
import cn.xqxls.mybatis.mapping.MappedStatement;
import cn.xqxls.mybatis.session.Configuration;
import cn.xqxls.mybatis.session.SqlSession;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-08-04 14:10
 * @Description
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注册机
     */
    private Configuration configuration;

    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement, null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {

        MappedStatement ms = configuration.getMappedStatement(statement);
        List<T> list = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getSqlSource().getBoundSql(parameter));
        return list.get(0);
    }


    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

}
