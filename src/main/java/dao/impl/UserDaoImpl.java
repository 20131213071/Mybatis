package dao.impl;

import dao.IUserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;


/**
 * Created by smx on 2017/9/4.
 * selSessionFactory，它的生命周期，应该是整个应用的范围内。
 * 全局范围内只需要有一个工厂就可以，使用单例模式来实现这个功能
 * 此例使用构造器注入方式获取sqlSessionFactory使之为全局
 */
public class UserDaoImpl implements IUserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    //依赖注入
    private SqlSessionFactory sqlSessionFactory;
    //通过构造器将sqlSessionFactory注入到UserDaoImpl中
    public UserDaoImpl (SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        User user = sqlSession.selectOne("test.findUserById",1);
        logger.info(user.toString());
        System.out.println(user == null ? new User() : user.toString());
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByUserName(String name) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findUserById2","小明");
        logger.info(users.toString());
        sqlSession.close();
        return users;
    }

    @Override
    public int insertUser2(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User adduser = new User();
        adduser.setAddress("cqc11ity1");
        adduser.setId(170);
        adduser.setUsername("shaomimgxxx");
        sqlSession.insert("test.addUser",adduser);
        sqlSession.commit();
        sqlSession.close();
        return adduser.getId();
    }
}
