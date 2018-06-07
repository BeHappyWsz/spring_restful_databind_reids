package wsz.spring.restful.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import wsz.spring.restful.dao.UserDao;
import wsz.spring.restful.domain.User;
import wsz.spring.restful.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getUserById(int id) {
		String key = "user_"+id;
		ValueOperations<String, User> opsForValue = redisTemplate.opsForValue();
		Boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey) {
			User user = opsForValue.get(key);
			System.out.println("从缓存中获取");
			return user;
		}
		User user = userDao.getUserById(id);
		opsForValue.set(key, user, 100, TimeUnit.SECONDS);
		System.out.println("从数据库中获取");
		return user;
	}

	@Override
	public User getUserByRealname(String realname) {
		return userDao.getUserByRealname(realname);
	}

	@Override
	public List<User> getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		return userDao.getUserByUsernameAndPassword(username, password);
	}

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}
	
	
}
