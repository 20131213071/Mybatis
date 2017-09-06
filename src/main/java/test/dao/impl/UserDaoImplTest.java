package test.dao.impl; 

import dao.IUserDao;
import dao.UserMapper;
import dao.impl.UserDaoImpl;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;

/** 
* UserDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 4, 2017</pre> 
* @version 1.0 
*/ 
public class UserDaoImplTest {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImplTest.class);
    public SqlSessionFactory sqlSessionFactory;
@Before
public void initSqlSessionFactory() throws Exception {
    String resource = "SqlMapConf.xml";
    Reader reader = Resources.getResourceAsReader(resource);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findById(int id) 
* dao实现测试方法
*/ 
@Test
public void testFindById1() throws Exception {
    IUserDao iUserDao = new UserDaoImpl(sqlSessionFactory);
    User user = iUserDao.findById(1);
    logger.info(user.toString());
}
/*
* mapper代理测试方法
* */
@Test
public void testFindById() throws Exception{
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //a mapper bound to this SqlSession
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User user = userMapper.findById(180);
    logger.info(user.toString());
}


/** 
* 
* Method: findUserByUserName(String name) 
* 
*/ 
@Test
public void testFindUserByUserName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insertUser2(User user) 
* 
*/ 
@Test
public void testInsertUser2() throws Exception { 
//TODO: Test goes here... 
} 


} 
