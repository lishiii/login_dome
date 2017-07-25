package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.entity.User;
import web.exception.NameRepeatException;
import web.service.UserService;
import web.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
public class AddUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 接受参数
		String admin = req.getParameter("user");
		String adminPwd = req.getParameter("passwd");
		String qq = req.getParameter("qqnum");
		User user = new User();
		user.setAdmin(admin);
		user.setAdminpwd(adminPwd);
		user.setQq(qq);
		// 调用dao注册用户
		UserService userService = new UserServiceImpl();
		try {
			userService.addUser(user);
		} catch (NameRepeatException e) {
			req.setAttribute("mag", e.getMessage());
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		req.setAttribute("mag", "注册成功");
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
