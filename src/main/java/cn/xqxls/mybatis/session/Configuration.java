package cn.xqxls.mybatis.session;

import cn.xqxls.mybatis.binding.MapperRegistry;
import cn.xqxls.mybatis.datasource.druid.DruidDataSourceFactory;
import cn.xqxls.mybatis.datasource.pooled.PooledDataSourceFactory;
import cn.xqxls.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import cn.xqxls.mybatis.executor.Executor;
import cn.xqxls.mybatis.executor.SimpleExecutor;
import cn.xqxls.mybatis.executor.resultset.DefaultResultSetHandler;
import cn.xqxls.mybatis.executor.resultset.ResultSetHandler;
import cn.xqxls.mybatis.executor.statement.PreparedStatementHandler;
import cn.xqxls.mybatis.executor.statement.StatementHandler;
import cn.xqxls.mybatis.mapping.BoundSql;
import cn.xqxls.mybatis.mapping.Environment;
import cn.xqxls.mybatis.mapping.MappedStatement;
import cn.xqxls.mybatis.reflection.MetaObject;
import cn.xqxls.mybatis.reflection.factory.DefaultObjectFactory;
import cn.xqxls.mybatis.reflection.factory.ObjectFactory;
import cn.xqxls.mybatis.reflection.wrapper.DefaultObjectWrapperFactory;
import cn.xqxls.mybatis.reflection.wrapper.ObjectWrapperFactory;
import cn.xqxls.mybatis.scripting.LanguageDriverRegistry;
import cn.xqxls.mybatis.scripting.xmltags.XMLLanguageDriver;
import cn.xqxls.mybatis.transaction.Transaction;
import cn.xqxls.mybatis.transaction.jdbc.JdbcTransactionFactory;
import cn.xqxls.mybatis.type.TypeAliasRegistry;
import cn.xqxls.mybatis.type.TypeHandlerRegistry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xqxls
 * @create 2023-08-04 17:13
 * @Description
 */
public class Configuration {

    /**
     * 环境
     */
    protected Environment environment;

    /**
     * 类型别名注册机
     */
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);
    /**
     * 映射的语句，存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 类型处理器注册机
    protected final TypeHandlerRegistry typeHandlerRegistry = new TypeHandlerRegistry();
    protected final LanguageDriverRegistry languageRegistry = new LanguageDriverRegistry();
    // 对象工厂和对象包装器工厂
    protected ObjectFactory objectFactory = new DefaultObjectFactory();
    protected ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
    protected final Set<String> loadedResources = new HashSet<>();

    protected String databaseId;

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);
        languageRegistry.setDefaultDriverClass(XMLLanguageDriver.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    /**
     * 创建结果集处理器
     */
    public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, BoundSql boundSql) {
        return new DefaultResultSetHandler(executor, mappedStatement, boundSql);
    }

    /**
     * 生产执行器
     */
    public Executor newExecutor(Transaction transaction) {
        return new SimpleExecutor(this, transaction);
    }

    /**
     * 创建语句处理器
     */
    public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        return new PreparedStatementHandler(executor, mappedStatement, parameter, resultHandler, boundSql);
    }

    // 创建元对象
    public MetaObject newMetaObject(Object object) {
        return MetaObject.forObject(object, objectFactory, objectWrapperFactory);
    }

    // 类型处理器注册机
    public TypeHandlerRegistry getTypeHandlerRegistry() {
        return typeHandlerRegistry;
    }

    public boolean isResourceLoaded(String resource) {
        return loadedResources.contains(resource);
    }

    public void addLoadedResource(String resource) {
        loadedResources.add(resource);
    }

    public LanguageDriverRegistry getLanguageRegistry() {
        return languageRegistry;
    }

}

