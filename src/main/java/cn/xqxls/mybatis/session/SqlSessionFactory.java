package cn.xqxls.mybatis.session;

/**
 * @author xqxls
 * @create 2023-08-04 14:08
 * @Description
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}
