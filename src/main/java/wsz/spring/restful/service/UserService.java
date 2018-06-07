package wsz.spring.restful.service;

import java.util.List;

import wsz.spring.restful.domain.User;

public interface UserService {
	
	public List<User> getAllUser();
	
	public User getUserById(int id);
	
	public User getUserByRealname(String realname);
	
	public List<User> getUserByUsername(String username);
	
	public User getUserByUsernameAndPassword(String username, String password);
	
	public int insertUser(User user);

	public int updateUser(User user);
	
	public int deleteUser(int id);
}
