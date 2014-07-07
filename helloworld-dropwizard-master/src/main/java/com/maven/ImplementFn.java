package com.maven;

import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

//import fr.blemale.dropwizard.todo.core.Todo;

//import fr.blemale.dropwizard.todo.core.Todo;

public class ImplementFn {

	private final Map<Long, Todo> todoStore = Maps.newConcurrentMap();
	
	public ImmutableList<Todo> findNameById() {
    	System.out.println("Coming to get todos");
        return ImmutableList.copyOf(todoStore.values());
    }
}
