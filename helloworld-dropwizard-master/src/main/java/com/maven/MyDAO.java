package com.maven;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.google.common.collect.ImmutableList;

//import fr.blemale.dropwizard.todo.core.Todo;

//import fr.blemale.dropwizard.todo.jdbi.TodoMapper;

@RegisterMapper(HelloMapper.class)
public interface MyDAO extends MyDAOInt{
	  /*@SqlUpdate("create table something (id int primary key, name varchar(100))")
	  void createSomethingTable();

	  @SqlUpdate("insert into something (id, name) values (:id, :name)")
	  void insert(@Bind("id") int id, @Bind("name") String name);*/

	@SqlQuery("select name, age from emp")
	ImmutableList<Todo> getTodos();
	  //String findNameById(@Bind("id") int id);
	  	
}

	
