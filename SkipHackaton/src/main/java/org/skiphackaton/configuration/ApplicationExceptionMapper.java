package org.skiphackaton.configuration;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException>{

	@Override
	public Response toResponse(ApplicationException exception) {
		String html = exception.getMessage();
		return Response.status(Status.BAD_REQUEST).entity(html.getBytes()).type(MediaType.TEXT_HTML_TYPE).build();
//		return Response.ok(html.getBytes(), MediaType.TEXT_HTML).build();
	}

}
