package web.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.entity.User;
import web.service.UserService;
import web.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
public class LoginUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// 接受参数
		String admin = req.getParameter("username");
		String adminPwd = req.getParameter("p");
		User user = new User();
		user.setAdmin(admin);
		user.setAdminpwd(adminPwd);
		// 调用dao注册用户
		UserService userService = new UserServiceImpl();
		boolean res = userService.login(user);
		if (res == true) {
			// Cookie cookies[] = req.getCookies(); //
			// 读出用户硬盘上的Cookie，并将所有的Cookie放到一个cookie对象数组里面
			// Cookie sCookie = null;
			// for (int i = 0; i < cookies.length - 1; i++) { //
			// 用一个循环语句遍历刚才建立的Cookie对象数组
			// sCookie = cookies[i]; // 取出数组中的一个Cookie对象
			// if (sCookie != null) {
			// if (("admin").equals(sCookie.getName())) {
			// sCookie.setMaxAge(0);
			// }
			// }
			// }
			
			Cookie cookie = new Cookie("admin", URLEncoder.encode(user.getAdmin(),"utf-8"));
			cookie.setMaxAge(-1);
			resp.addCookie(cookie);
			req.getRequestDispatcher("/index02.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "用户名或者密码输入错误！");
			req.setAttribute("username", user.getAdmin());
			req.setAttribute("p", user.getAdminPwd());
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
