package cn.xqxls.mybatis.reflection.wrapper;

import cn.xqxls.mybatis.reflection.MetaObject;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/2/5 16:48
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory{

    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }

}
