package wsz.spring.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import wsz.spring.restful.domain.User;
import wsz.spring.restful.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}
	
	@ResponseBody
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public User getUserById(@PathVariable("id")int id) {
		return userService.getUserById(id);
	}
	
	@ResponseBody
	@RequestMapping(value="/user/realname", method=RequestMethod.GET)
	public User getUserByRealname(@RequestParam(value="realname", defaultValue="error", required=true)String realname) {
		return userService.getUserByRealname(realname);
	}
	
	@ResponseBody
	@RequestMapping(value="/user/username", method=RequestMethod.GET)
	public List<User> getUserByUsername(@RequestParam(value="username", defaultValue="error")String username){
		return userService.getUserByUsername(username);
	}
	
	@ResponseBody
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public User login(String username, String password) {
		return userService.getUserByUsernameAndPassword(username, password);
	}
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public int insertUser(User user) {
		return userService.insertUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.PUT)
	public int updateUser(User user) {
		return userService.updateUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public int deleteUser(@PathVariable("id")int id) {
		return userService.deleteUser(id);
	}
	
}
