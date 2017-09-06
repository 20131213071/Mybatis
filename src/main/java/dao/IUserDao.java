package dao;

import entity.User;

import java.util.List;

/**
 * Created by smx on 2017/9/4.
 * Param
 */
public interface IUserDao {
    //public abstract
    User findById(int id) throws Exception;
    List<User> findUserByUserName(String name) throws Exception;
    int insertUser2(User user) throws Exception;

}
