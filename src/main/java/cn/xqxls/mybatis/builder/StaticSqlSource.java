package cn.xqxls.mybatis.builder;

import cn.xqxls.mybatis.mapping.BoundSql;
import cn.xqxls.mybatis.mapping.ParameterMapping;
import cn.xqxls.mybatis.mapping.SqlSource;
import cn.xqxls.mybatis.session.Configuration;

import java.util.List;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/3/14 11:19
 */
public class StaticSqlSource implements SqlSource {

    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration, String sql) {
        this(configuration, sql, null);
    }

    public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration, sql, parameterMappings, parameterObject);
    }

}
