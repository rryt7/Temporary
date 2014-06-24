package fr.blemale.dropwizard.todo.jdbi;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import fr.blemale.dropwizard.todo.core.Todo;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.customizers.SingleValueResult;

import java.util.List;

@RegisterMapper(TodoMapper.class)
public interface JDBITodoDAO extends TodoDAO {
    @Override
    @GetGeneratedKeys
    //@SqlUpdate("INSERT INTO todo (title, content) VALUES (:title, :content)")
    @SqlUpdate("INSERT INTO emp (name, age) VALUES (:name, :age)")
    Long createTodo(@BindBean Todo todo);

    @Override
    //@SqlUpdate("UPDATE todo SET title = :title, content = :content WHERE id = :id")
    @SqlUpdate("UPDATE emp SET name = :name, age = :age WHERE age = :age")
    int updateTodo(@BindBean Todo todo);

    @Override
    @SqlQuery("SELECT name, age FROM emp")
    ImmutableList<Todo> getTodos();

    @Override
    @SingleValueResult(Todo.class)
    
    @SqlQuery("SELECT name, age FROM todo WHERE age = :age")//@SqlQuery("SELECT id, title, content FROM todo WHERE id = :id")
    Optional<Todo> getTodo(@Bind("age") long id);
}
