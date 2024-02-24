package cn.xqxls.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/2/5 15:43
 */
public class SetFieldInvoker implements Invoker{

    private Field field;

    public SetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        field.set(target,args[0]);
        return null;
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
