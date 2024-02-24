package cn.xqxls.mybatis.reflection.invoker;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/2/5 15:39
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();

}
