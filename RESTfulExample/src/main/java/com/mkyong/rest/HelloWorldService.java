package com.mkyong.rest;
 
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	
	@GET
	@Path("/vip")
	public Response getUserVIP() {

		return Response.status(200).entity("getUserVIP is called").build();

	}
	
	@GET
	public Response getUser() {

		return Response.status(200).entity("getUser is called").build();

	}

	
	@GET
	@Path("{id : \\d+}") //support digit only
	public Response getUserById(@PathParam("id") String id) {

	   return Response.status(200).entity("getUserById is called, id : " + id).build();

	}

	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
	public Response getUserByUserName(@PathParam("username") String username) {

	   return Response.status(200)
		.entity("getUserByUserName is called, username : " + username).build();

	}
	
	@GET
	@Path("/books/{isbn : \\d+}")
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {

	   return Response.status(200)
		.entity("getUserBookByISBN is called, isbn : " + isbn).build();

	}
	
	@GET
	@Path("{year}/{month}/{day}")
	public Response getUserHistory(
			@PathParam("year") int year,
			@PathParam("month") int month, 
			@PathParam("day") int day) {

	   String date = year + "/" + month + "/" + day;

	   return Response.status(200)
		.entity("getUserHistory is called, year/month/day : " + date)
		.build();
	}
	
	@GET
	@Path("/query")
	public Response getUsers(
		@QueryParam("from") int from,
		@QueryParam("to") int to,
		@QueryParam("orderBy") List<String> orderBy) {

		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();

	}
	
/*	@GET
	@Path("{year}")
	public Response getBooks(@PathParam("year") String year,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {

		return Response
			.status(200)
			.entity("getBooks is called, year : " + year
				+ ", author : " + author + ", country : " + country)
			.build();

	}*/

	
	@GET
	@Path("/get")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {

		return Response.status(200)
			.entity("addUser is called, userAgent : " + userAgent)
			.build();

	}
	
	@GET
	@Path("/get1")
	public Response addUser(@Context HttpHeaders headers) {

		String userAgent = headers.getRequestHeader("user-agent").get(0);
		
		for(String header : headers.getRequestHeaders().keySet()){
			System.out.println(header);
		}
		
		return Response.status(200)
			.entity("addUser is called, userAgent : " + userAgent)
			.build();

	}

}