package cn.xqxls.mybatis.mapping;

import cn.xqxls.mybatis.session.Configuration;
import cn.xqxls.mybatis.type.JdbcType;

/**
 * @author xqxls
 * @create 2023-08-07 16:40
 * @Description 参数映射 #{property,javaType=int,jdbcType=NUMERIC}
 */
public class ParameterMapping {

    private Configuration configuration;

    /** property **/
    private String property;
    /** javaType = int **/
    private Class<?> javaType = Object.class;
    /** jdbcType=NUMERIC **/
    private JdbcType jdbcType;

    private ParameterMapping() {
    }

    public static class Builder {

        private ParameterMapping parameterMapping = new ParameterMapping();

        public Builder(Configuration configuration, String property) {
            parameterMapping.configuration = configuration;
            parameterMapping.property = property;
        }

        public Builder javaType(Class<?> javaType) {
            parameterMapping.javaType = javaType;
            return this;
        }

        public Builder jdbcType(JdbcType jdbcType) {
            parameterMapping.jdbcType = jdbcType;
            return this;
        }

    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getProperty() {
        return property;
    }

    public Class<?> getJavaType() {
        return javaType;
    }

    public JdbcType getJdbcType() {
        return jdbcType;
    }

}
