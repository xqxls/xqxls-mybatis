package cn.xqxls.mybatis.builder;

import cn.xqxls.mybatis.session.Configuration;
import cn.xqxls.mybatis.type.TypeAliasRegistry;
import cn.xqxls.mybatis.type.TypeHandlerRegistry;

/**
 * @author xqxls
 * @create 2023-08-04 17:18
 * @Description
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    protected final TypeHandlerRegistry typeHandlerRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
        this.typeHandlerRegistry = this.configuration.getTypeHandlerRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    protected Class<?> resolveAlias(String alias) {
        return typeAliasRegistry.resolveAlias(alias);
    }

}
