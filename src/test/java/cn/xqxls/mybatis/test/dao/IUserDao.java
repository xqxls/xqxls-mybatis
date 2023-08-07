package cn.xqxls.mybatis.test.dao;


import cn.xqxls.mybatis.test.po.User;

/**
 * @author xqxls
 * @create 2023-08-03 17:11
 * @Description
 */
public interface IUserDao {

    User queryUserInfoById(Long uId);
}
