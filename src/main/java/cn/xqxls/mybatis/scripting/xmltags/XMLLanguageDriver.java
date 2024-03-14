package cn.xqxls.mybatis.scripting.xmltags;

import cn.xqxls.mybatis.mapping.SqlSource;
import cn.xqxls.mybatis.scripting.LanguageDriver;
import cn.xqxls.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @Description: XML语言驱动器
 * @Author: xqxls
 * @CreateTime: 2024/3/14 11:11
 */
public class XMLLanguageDriver implements LanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

}
