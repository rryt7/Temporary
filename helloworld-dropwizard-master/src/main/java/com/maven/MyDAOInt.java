package com.maven;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

//import fr.blemale.dropwizard.todo.core.Todo;

//import fr.blemale.dropwizard.todo.core.Todo;

public interface MyDAOInt {

	ImmutableList<Todo>  getTodos();

	Optional<Todo> getTodo(Long long1);

}
