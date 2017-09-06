package dao;

import entity.User;

/**
 * Created by smx on 2017/9/4.
 * Param
 */
public interface UserMapper {
    User findById(int id) throws Exception;
    int insertUser2(User user) throws Exception;
}
