package cn.xqxls.mybatis.transaction.jdbc;

import cn.xqxls.mybatis.session.TransactionIsolationLevel;
import cn.xqxls.mybatis.transaction.Transaction;
import cn.xqxls.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author xqxls
 * @create 2023-08-07 15:46
 * @Description
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}