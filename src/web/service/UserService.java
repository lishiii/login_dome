package web.service;

import java.util.List;

import web.entity.User;
import web.exception.NameRepeatException;

public interface UserService {
	public void addUser(User user) throws NameRepeatException;;// 注册

	public boolean login(User user);// 登录

	public boolean checkUser(String name);// 注册时根据姓名查询是否重复

	public List<User> findAll();// 查询用户信息

	public void updateUser(User user);// 修改用户

	public void deleteUser(String id);// 删除用户
	
	public User findById(String id);// 根据标号查询用户
}
