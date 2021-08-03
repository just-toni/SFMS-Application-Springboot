package com.todo.todolist.repository;

import com.todo.todolist.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoRepositoryTest {

    @Autowired
    TodoRepository todoRepository;

    @Test
    void createTodo(){
        Todo todo = new Todo("Shopping List");
        todo.setTodoDescription("Shopping on Asos for summer clothes");
        Todo todo1 = new Todo("Homework Due");
        Todo todo2 = new Todo("Chores list");
        Todo todo3 = new Todo("Reading list");
        todoRepository.save(todo);
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);
        assertEquals(4, todoRepository.count());
    }

    @Test
    void testThatTodoCanBeUpdatedById(){
        Optional<Todo> todoOptional = todoRepository.findById(3L);
        if(todoOptional.isPresent()){
            Todo todo = todoOptional.get();
            todo.setTodoId(1L);
            todoRepository.save(todo);
            assertEquals(1L, todo.getTodoId());
        }
    }

    @Test
    void testThatTodoCanBeDeletedById(){
        Optional<Todo> todoOptional = todoRepository.findById(3L);
        if(todoOptional.isPresent()){
            Todo todo = todoOptional.get();
            todoRepository.delete(todo);
            assertEquals(3, todoRepository.count());
        }
    }

}