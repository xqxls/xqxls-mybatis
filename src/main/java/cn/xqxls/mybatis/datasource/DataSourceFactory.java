package cn.xqxls.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author xqxls
 * @create 2023-08-07 16:01
 * @Description 数据源工厂
 */
public interface DataSourceFactory {

    /**
     * 设置属性
     * @param props 属性
     */
    void setProperties(Properties props);

    /**
     * 获取数据源
     * @return 数据源
     */
    DataSource getDataSource();

}
