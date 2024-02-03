package cn.xqxls.mybatis.executor;

import cn.xqxls.mybatis.executor.statement.StatementHandler;
import cn.xqxls.mybatis.mapping.BoundSql;
import cn.xqxls.mybatis.mapping.MappedStatement;
import cn.xqxls.mybatis.session.Configuration;
import cn.xqxls.mybatis.session.ResultHandler;
import cn.xqxls.mybatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/2/3 21:55
 */
public class SimpleExecutor extends BaseExecutor{

    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        try {
            Configuration configuration = ms.getConfiguration();
            StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, resultHandler, boundSql);
            Connection connection = transaction.getConnection();
            Statement stmt = handler.prepare(connection);
            handler.parameterize(stmt);
            return handler.query(stmt, resultHandler);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
