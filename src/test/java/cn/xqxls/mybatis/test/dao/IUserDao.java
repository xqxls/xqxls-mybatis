package cn.xqxls.mybatis.test.dao;

/**
 * @author xqxls
 * @create 2023-08-03 17:11
 * @Description
 */
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
