package web.service.impl;

import java.util.List;

import web.dao.UserDao;
import web.dao.impl.UserDaoImpl;
import web.entity.User;
import web.exception.NameRepeatException;
import web.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();

	public void addUser(User user) throws NameRepeatException {
		if (dao.checkUser(user.getAdmin())) {
			throw new NameRepeatException("名字重复，不可使用");
		}
		dao.addUser(user);
	}

	public boolean login(User user) {
		return dao.login(user);
	}

	public boolean checkUser(String name) {
		return dao.checkUser(name);
	}

	public List<User> findAll() {
		return dao.findAll();
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}

	public void deleteUser(String id) {
		dao.deleteUser(id);
	}

	public User findById(String id) {
		return dao.findById(id);
	}

}
