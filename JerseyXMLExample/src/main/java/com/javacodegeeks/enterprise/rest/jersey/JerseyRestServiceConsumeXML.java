package com.javacodegeeks.enterprise.rest.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/consumeXmlServices")
public class JerseyRestServiceConsumeXML {

	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_XML)
	public Response consumeXML( Student student ) {

		String output = student.toString();

		return Response.status(200).entity(output).build();
	}
}