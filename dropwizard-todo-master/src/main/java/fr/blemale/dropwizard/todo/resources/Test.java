package fr.blemale.dropwizard.todo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;


@Path("test")
public class Test {
	
	@Path("{name}")
	@GET
	public String sayHello(@PathParam("name") String name, @QueryParam("id") String id) {
		return "Hello " + name + ", " + id;
	}
	
	@Path("user")
	@GET
	public String sayHelloTo(@QueryParam("nam") String name) {
		return "Hello in PUT " + name;
	}

	@Path("bye")
	@GET
	public String sayBye() {
		return "Bye";
	}
}
