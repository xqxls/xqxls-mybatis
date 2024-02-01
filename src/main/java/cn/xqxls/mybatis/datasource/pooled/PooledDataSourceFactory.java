package cn.xqxls.mybatis.datasource.pooled;

import cn.xqxls.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import javax.sql.DataSource;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/2/1 16:33
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    @Override
    public DataSource getDataSource() {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver(props.getProperty("driver"));
        pooledDataSource.setUrl(props.getProperty("url"));
        pooledDataSource.setUsername(props.getProperty("username"));
        pooledDataSource.setPassword(props.getProperty("password"));
        return pooledDataSource;
    }
}
