package cloud.simple.service.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.simple.service.domain.UserService;
import cloud.simple.service.model.User;

@RefreshScope
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user")
	public List<User> readUserInfo(){
		List<User> ls=userService.searchAll();		
		return ls;
	}
	
	@RequestMapping(value="/adduser")
	public String addUser(HttpServletRequest request,HttpServletResponse response){
		String username = (String) request.getParameter("username");
		userService.addUser(username);
		return "新增用户成功："+username;
	}
	
	@Value("${from}")
	private String from;

	@RequestMapping("/from")
	public String from() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFrom() {
		return from;
	}
}
