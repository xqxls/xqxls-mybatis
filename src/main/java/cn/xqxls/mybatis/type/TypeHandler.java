package cn.xqxls.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/3/14 10:57
 */
public interface TypeHandler<T> {

    /**
     * 设置参数
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

}

