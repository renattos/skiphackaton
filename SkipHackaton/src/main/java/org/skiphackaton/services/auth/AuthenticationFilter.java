package org.skiphackaton.services.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/api/*")
public class AuthenticationFilter implements Filter {

	@Inject
	private AuthenticationService authService;
	
	public AuthenticationFilter() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String requestURI = req.getRequestURI();
		
		try {
			
			if(!"/skip/api/v1/auth".equals(requestURI)){
				//authService.checkAuthentication(req, resp);
			} 
			
			chain.doFilter(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter out = resp.getWriter();
			out.println("Error: " + e.getMessage());
			out.flush();
		}
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	
}
