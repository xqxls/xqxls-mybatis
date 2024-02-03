package cn.xqxls.mybatis.session.defaults;

import cn.xqxls.mybatis.executor.Executor;
import cn.xqxls.mybatis.mapping.Environment;
import cn.xqxls.mybatis.session.Configuration;
import cn.xqxls.mybatis.session.SqlSession;
import cn.xqxls.mybatis.session.SqlSessionFactory;
import cn.xqxls.mybatis.session.TransactionIsolationLevel;
import cn.xqxls.mybatis.transaction.Transaction;
import cn.xqxls.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * @author xqxls
 * @create 2023-08-04 14:09
 * @Description
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {

        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }

}