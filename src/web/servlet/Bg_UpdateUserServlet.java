package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.entity.User;
import web.service.UserService;
import web.service.impl.UserServiceImpl;

public class Bg_UpdateUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//接受参数
		String id = req.getParameter("id");
		String admin = req.getParameter("admin");
		String adminpwd = req.getParameter("adminpwd");
		String qq = req.getParameter("qq");
		//封装到Contact对象
		User user = new User();
		user.setId(id);
		user.setAdmin(admin);
		user.setAdminpwd(adminpwd);
		user.setQq(qq);
		
		//调用dao添加联系人
		UserService userService = new UserServiceImpl();
		//调用dao类的添加联系人的方法
		userService.updateUser(user);
		resp.sendRedirect(req.getContextPath()+"/Bg_ListUserServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
