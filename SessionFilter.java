package com.metacube.get2019;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/SessionFilter")
public class SessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(false);
		if(session != null) {
			chain.doFilter(req, res);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
	       	out.println("Session Expired!");
	       	rd.include(req, res);
		}
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

	
}
