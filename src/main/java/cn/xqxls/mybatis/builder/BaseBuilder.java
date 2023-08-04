package cn.xqxls.mybatis.builder;

import cn.xqxls.mybatis.session.Configuration;

/**
 * @author xqxls
 * @create 2023-08-04 17:18
 * @Description
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
