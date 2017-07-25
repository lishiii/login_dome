package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.entity.User;
import web.service.UserService;
import web.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
public class Bg_LoginUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 接受参数
		String admin = req.getParameter("username");
		String adminPwd = req.getParameter("p");
		User user = new User();
		user.setAdmin(admin);
		user.setAdminpwd(adminPwd);
		// 调用dao注册用户
		UserService userService = new UserServiceImpl();
		boolean res = userService.login(user);
		if(res==true){
			Cookie cookie = new Cookie("admin", user.getAdmin());
			cookie.setMaxAge(30*24*60*60);
			resp.addCookie(cookie);
			req.getRequestDispatcher("/Bg_ListUserServlet").forward(req, resp);
		}else{
			req.setAttribute("msg", "用户名或者密码输入错误！");
			req.setAttribute("username", user.getAdmin());
			req.setAttribute("p", user.getAdminPwd());
			req.getRequestDispatcher("/bg_login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
