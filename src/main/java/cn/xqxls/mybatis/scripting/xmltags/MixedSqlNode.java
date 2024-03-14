package cn.xqxls.mybatis.scripting.xmltags;

import java.util.List;

/**
 * @Description: 混合SQL节点
 * @Author: xqxls
 * @CreateTime: 2024/3/14 11:14
 */
public class MixedSqlNode implements SqlNode {

    //组合模式，拥有一个SqlNode的List
    private List<SqlNode> contents;

    public MixedSqlNode(List<SqlNode> contents) {
        this.contents = contents;
    }

    @Override
    public boolean apply(DynamicContext context) {
        // 依次调用list里每个元素的apply
        contents.forEach(node -> node.apply(context));
        return true;
    }

}

