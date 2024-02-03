package cn.xqxls.mybatis.executor;

import cn.xqxls.mybatis.mapping.BoundSql;
import cn.xqxls.mybatis.mapping.MappedStatement;
import cn.xqxls.mybatis.session.ResultHandler;
import cn.xqxls.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/2/3 21:50
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);
}
