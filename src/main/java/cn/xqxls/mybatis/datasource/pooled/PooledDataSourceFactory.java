package cn.xqxls.mybatis.datasource.pooled;

import cn.xqxls.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import javax.sql.DataSource;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/2/1 16:33
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }
}
