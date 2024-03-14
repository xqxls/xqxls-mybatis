package cn.xqxls.mybatis.scripting.xmltags;

/**
 * @Description: SQL节点
 * @Author: xqxls
 * @CreateTime: 2024/3/14 11:06
 */
public interface SqlNode {

    boolean apply(DynamicContext context);

}
