package com.free.company.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.free.company.bean.User;

/**
 * Servlet Filter implementation class CheckLoginFilter
 */
public class CheckLoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null){
			request.setAttribute("msg", "会員ログインが必要です");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
	}

}
