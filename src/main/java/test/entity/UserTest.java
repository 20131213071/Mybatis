package test.entity; 

import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.Reader;
import java.util.List;

/** 
* User Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 1, 2017</pre> 
* @version 1.0 
*/ 
public class UserTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
public void findUserByIdTest() throws Exception{
    String resource = "SqlMapConf.xml";
    Reader reader = Resources.getResourceAsReader(resource);
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //5������sqlsessiond ��ɾ�Ĳ鷽��
    //��һ��������statement��Ψһ��ʾ��
    //1����ȷ��ѯ
    User user = sqlSession.selectOne("test.findUserById",1);
    System.out.println(user == null ? new User():user.toString());
    //2��ģ����ѯ
    List<User> user1 = sqlSession.selectList("test.findUserById1","%С��%");
    System.out.println(user1);
    List<User> user2 = sqlSession.selectList("test.findUserById2","С��");
    System.out.println(user2);
    //3������
    User adduser = new User();
    adduser.setAddress("cqcity1");
    adduser.setId(180);
    adduser.setUsername("shaomimg");
    sqlSession.insert("test.addUser",adduser);
    //�ֶ��ύ
    sqlSession.commit();
    //opensessionʱ����trueֵ
    SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
    sqlSession1.insert("test.addUser",adduser);
    //4������󷵻�����





    sqlSession.close();
}
/** 
* 
* Method: getId() 
* 
*/ 
@Test
public void testGetId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setId(int id) 
* 
*/ 
@Test
public void testSetId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getAge() 
* 
*/ 
@Test
public void testGetAge() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setAge(int age) 
* 
*/ 
@Test
public void testSetAge() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception { 
//TODO: Test goes here... 
} 


} 
