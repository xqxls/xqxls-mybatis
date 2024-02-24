package cn.xqxls.mybatis.reflection.wrapper;

import cn.xqxls.mybatis.reflection.MetaObject;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/2/5 16:42
 */
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);

}
