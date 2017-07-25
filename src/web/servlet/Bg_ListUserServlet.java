package web.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.entity.User;
import web.service.UserService;
import web.service.impl.UserServiceImpl;

public class Bg_ListUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		从xml中读取联系人数据
		UserService userService = new UserServiceImpl();
		List<User> list = userService.findAll();
		
//		把结果保存在域对象中
		req.setAttribute("users", list);
//		跳转到显示页面
		req.getRequestDispatcher("/cms.jsp").forward(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
