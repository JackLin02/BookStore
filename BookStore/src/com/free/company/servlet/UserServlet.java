package com.free.company.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.free.company.bean.User;
import com.free.company.service.UserService;
import com.free.company.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = new UserServiceImpl();

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.getUser(new User(null, username, password, null));
		if (user == null) {
			request.setAttribute("msg", "ユーザー名やパスワードの入力が間違いました");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		}
	}

	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		Object code2 = session.getAttribute("KAPTCHA_SESSION_KEY");
		if(code2 != null && code2.toString().equals(code)){
			boolean yOn = userService.checkUserName(username);
			if (yOn) {
				request.setAttribute("msg", "ユーザー名がすでに存在している，別のユーザー名を入力してください！");
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			} else {
				System.out.println("saveUser()");
				userService.saveUser(new User(null, username, password, email));
				response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
			}
		}else{
			request.setAttribute("msg", "検証コードの入力が間違いました");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
