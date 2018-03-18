package org.skiphackaton.services.auth;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/auth")
@RequestScoped
public class AuthenticationService {
	
	private static final String SKIP_AUTH = "Skip-Auth";
	private static final Map<String, String> users = new HashMap<>();
	private static final Map<String, NewCookie> authenticatedUsers = new HashMap<>();
	
	public AuthenticationService() {
		users.put("teste1", "111");
		users.put("teste2", "222");
	}
	
	@GET
	public Response auth(@QueryParam("email") String email, @QueryParam("password") String password, @Context HttpServletResponse resp){
		
		validateCredentials(email, password, resp);
		
		ResponseBuilder okResponse = Response.ok();
		
		NewCookie authCookie = getAuthenticationCookie(email);
		
		okResponse.cookie(authCookie);
		
		return okResponse.build();
	}

	protected NewCookie getAuthenticationCookie(String email) {
		NewCookie authCookie = authenticatedUsers.get(email);
		
		if(authCookie == null){
			String hash = "123";
			authCookie = new NewCookie(SKIP_AUTH, hash);
			authenticatedUsers.put(hash, authCookie);
		}
		return authCookie;
	}

	protected void validateCredentials(String email, String password, HttpServletResponse resp) {
		String validPwd = users.get(email);
		if(validPwd == null || !validPwd.equals(password)){
			throw new NotAuthorizedException(resp);
		}
	}

	public void checkAuthentication(HttpServletRequest req, HttpServletResponse resp) {
		boolean authSuccess = false;
		Cookie[] cookies = req.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
				if(SKIP_AUTH.equals(cookie.getName())) {
					String hashCookie = cookie.getValue();
					NewCookie cookieSession = authenticatedUsers.get(hashCookie);
					if(cookieSession != null){
						authSuccess = true;
					}
				}
			}
		}
		
		if(! authSuccess) {
			throw new NotAuthorizedException(resp);
		}
	}
}
