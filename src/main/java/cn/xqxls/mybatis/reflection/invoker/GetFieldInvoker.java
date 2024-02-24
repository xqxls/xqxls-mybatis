package cn.xqxls.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/2/5 15:45
 */
public class GetFieldInvoker implements Invoker{

    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
