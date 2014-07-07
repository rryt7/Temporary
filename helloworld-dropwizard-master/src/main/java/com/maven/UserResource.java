package com.maven;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.jetty.server.Authentication.User;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
/*import com.yammer.dropwizard.auth.Auth;
import com.yammer.dropwizard.jersey.params.LongParam;

import fr.blemale.dropwizard.todo.api.external.ExternalTodo;
import fr.blemale.dropwizard.todo.core.Todo;*/

//import fr.blemale.dropwizard.todo.api.external.ExternalTodoList;

//import fr.blemale.dropwizard.todo.core.Todo;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final MyDAOInt todoDAO;

    public UserResource(MyDAOInt todoDAO) {
    	System.out.println("UserResource Constructor");
        this.todoDAO = todoDAO;
    }

    /*@Timed
    @GET
    public ExternalTodoList getTodos(@Context UriInfo uriInfo, @Auth User user) {
    	System.out.println("Inside gettodos");
        return new ExternalTodoList.Mapper().fromTodoList(uriInfo.getBaseUri(), this.todoDAO.getTodos());
    }*/
    
    @Timed
    @GET
    public ExternalTodoList getTodos(@Context UriInfo uriInfo){
    	System.out.println("findNameById");
	//	return "findNameById";
    	
    	return new ExternalTodoList.Mapper().fromTodoList(uriInfo.getBaseUri(), this.todoDAO.getTodos());
    }
    
    @Timed
    @Path("{id}")
    @GET
    public ExternalTodo getTodo(@Context UriInfo uriInfo, @PathParam("id") io.dropwizard.jersey.params.LongParam id) {
    	System.out.println("Oh God");
        Optional<Todo> todo = this.todoDAO.getTodo(id.get());
        System.out.println("Getting value"+ id.get());
        if (todo.isPresent()) {
        	System.out.println("todo is present");
            return new ExternalTodo.Mapper().fromTodo(uriInfo.getBaseUri(),todo.get());
        } else {
        	System.out.println("todo is absent");
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
}
