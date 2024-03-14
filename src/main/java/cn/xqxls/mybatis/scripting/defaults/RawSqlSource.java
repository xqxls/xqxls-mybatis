package cn.xqxls.mybatis.scripting.defaults;

import cn.xqxls.mybatis.builder.SqlSourceBuilder;
import cn.xqxls.mybatis.mapping.BoundSql;
import cn.xqxls.mybatis.mapping.SqlSource;
import cn.xqxls.mybatis.scripting.xmltags.DynamicContext;
import cn.xqxls.mybatis.scripting.xmltags.SqlNode;
import cn.xqxls.mybatis.session.Configuration;

import java.util.HashMap;

/**
 * @Description: 原始SQL源码，比 DynamicSqlSource 动态SQL处理快
 * @Author: xqxls
 * @CreateTime: 2024/3/14 11:15
 */
public class RawSqlSource implements SqlSource {

    private final SqlSource sqlSource;

    public RawSqlSource(Configuration configuration, SqlNode rootSqlNode, Class<?> parameterType) {
        this(configuration, getSql(configuration, rootSqlNode), parameterType);
    }

    public RawSqlSource(Configuration configuration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    private static String getSql(Configuration configuration, SqlNode rootSqlNode) {
        DynamicContext context = new DynamicContext(configuration, null);
        rootSqlNode.apply(context);
        return context.getSql();
    }

}

