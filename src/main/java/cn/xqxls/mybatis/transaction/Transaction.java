package cn.xqxls.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author xqxls
 * @create 2023-08-07 15:40
 * @Description 事务接口
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
