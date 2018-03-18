package org.skiphackaton.services.auth;

import javax.enterprise.context.SessionScoped;
import javax.ws.rs.core.NewCookie;

@SessionScoped
public class AuthenticatedUser {
	private String email;
	private NewCookie cookie;
	
	public AuthenticatedUser(String email, NewCookie cookie) {
		this.email = email;
		this.cookie = cookie;
	}
	
	public String getEmail() {
		return email;
	}

	public NewCookie getCookie() {
		return cookie;
	}

}
