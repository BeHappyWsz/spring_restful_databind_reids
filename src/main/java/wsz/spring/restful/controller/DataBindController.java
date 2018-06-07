package wsz.spring.restful.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import wsz.spring.restful.domain.Book;
import wsz.spring.restful.domain.User;

/**
 * springmvc数据绑定
 * @author wsz
 * 2018年6月6日 上午11:00:04
 */
@Controller
public class DataBindController {
	
	/**
	 * http://localhost:8088/simpleObject?name=haha&age=12&price=45.00&money=55555.5546546
	 * @param name
	 * @param age
	 * @param price
	 * @param money
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/simpleObject")
	public String simpleObject(String name, int age, float price, Double money) {
		return name+" "+age+" "+price+" "+money;
	}
	
	/**
	 * http://localhost:8088/array?names=n1&names=n2&ages=66&ages=666
	 * @param names
	 * @param ages
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/array")
	public String array(String[] names, int[] ages) {
		System.out.println(names.length);
		System.out.println(ages.length);
		return 	names+" "+ages;
	}
	
	/**
	 * http://localhost:8088/entityObject?id=123&realName=12&userName=45.00&password=55555.5546546
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/entityObject")
	public User entityObject(User user) {
		return user;
	}
	
	/**
	 * 绑定多组实体对象,需要initObject(),否则无法进行绑定
	 * http://localhost:8088/multiObject?book.id=12&book.name=123&user.id=5555&user.userName=aa
	 * @param user
	 * @param book
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/multiObject")
	public String multiObject(User user, Book book) {
		System.out.println(user);
		System.out.println(book);
		return user+" "+book;
	}
	
	@InitBinder("user")
	public void initUser(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("user.");
	}
	
	@InitBinder("book")
	public void initBook(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("book.");
	}
	
	/**
	 * http://localhost:8088/map?names=n1&ages=666
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/map")
	public String map(@RequestParam Map<String,Object> map) {
		return map.toString();
	}
	
	/**
	 * http://localhost:8088/json Content-Type:application/json
	 * 接受json格式的数据
		{
			"id": "12",
			"realName": "赵钱孙李",
			"userName": "12.11",
			"password":"aaasdqe"
		}
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/json", consumes="application/json")
	public String json(@RequestBody User user) {
		return user.toString();
	}
	
	/**
	 * 实体目标需要添加注解@XmlRootElement(name="user")
	 * http://localhost:8088/xml Content-Type:application/xml
		<user>
		  	<id>123</id>
		  	<realName>HHAHA</realName>
		  	<userName>aaaaa</userName>
		  	<password>5656a</password>
		</user> 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/xml", consumes="application/xml")
	public String xml(@RequestBody User user) {
		return user.toString();
	}
	
//	@ResponseBody
//	@RequestMapping(value="/objectArray")
//	public String multiObject(User[] users) {
//		return users.toString();
//	}
}
