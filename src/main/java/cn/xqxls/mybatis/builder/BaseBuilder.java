package cn.xqxls.mybatis.builder;

import cn.xqxls.mybatis.session.Configuration;
import cn.xqxls.mybatis.type.TypeAliasRegistry;

/**
 * @author xqxls
 * @create 2023-08-04 17:18
 * @Description
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
