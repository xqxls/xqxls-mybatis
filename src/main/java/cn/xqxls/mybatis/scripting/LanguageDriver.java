package cn.xqxls.mybatis.scripting;

import cn.xqxls.mybatis.mapping.SqlSource;
import cn.xqxls.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @Description:
 * @Author: xqxls
 * @CreateTime: 2024/3/14 11:04
 */
public interface LanguageDriver {

    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

}
