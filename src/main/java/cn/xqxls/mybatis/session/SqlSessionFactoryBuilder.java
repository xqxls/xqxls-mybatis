package cn.xqxls.mybatis.session;

import cn.xqxls.mybatis.builder.xml.XMLConfigBuilder;
import cn.xqxls.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author xqxls
 * @create 2023-08-04 17:12
 * @Description
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
