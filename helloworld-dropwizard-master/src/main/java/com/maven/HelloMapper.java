package com.maven;

import java.sql.ResultSet;
import java.sql.SQLException;



//import fr.blemale.dropwizard.todo.core.Todo;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.google.common.base.Optional;

public class HelloMapper implements ResultSetMapper<Todo> {

	//@Override
    public Todo map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
    	System.out.println("Inside map");
        return Todo.Builder.aTodo(resultSet.getLong("age"), resultSet.getString("name")).withContent(Optional.fromNullable(resultSet.getString("name"))).build();
    	//return null;
    	//return Todo.Builder.aTodo(123,"Sachin").withContent(Optional.fromNullable(resultSet.getString("name"))).build();
    }
}
