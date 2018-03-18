package org.skiphackaton.services.test;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Cookie;

@Path("test")
public class TestService {
	
	@GET
	public String test(@CookieParam("Skip-Auth") Cookie cookie){
		return String.valueOf(cookie);
	}

}
