package cn.xqxls.mybatis.mapping;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/3/14 11:04
 */
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);

}
