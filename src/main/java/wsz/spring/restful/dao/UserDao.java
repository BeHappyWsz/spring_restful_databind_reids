package wsz.spring.restful.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import wsz.spring.restful.domain.User;
/**
 * userDao
 * @author wsz
 */
@Repository
@Mapper
public interface UserDao {
	
	public List<User> getAllUser();
	
	public User getUserById(@Param("id")int id);
	
	public User getUserByRealname(@Param("realname")String realname);
	
	public List<User> getUserByUsername(@Param("username")String username);
	
	public User getUserByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
	
	public int insertUser(User user);

	public int updateUser(User user);
	
	public int deleteUser(@Param("id") int id);
}
