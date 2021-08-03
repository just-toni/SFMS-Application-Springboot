package com.todo.todolist.repository;

import com.todo.todolist.model.Task;
import com.todo.todolist.model.TaskState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    @Test
    void createTasks(){
        Task task = new Task("Buy shoes", TaskState.TODO);
        task.setTaskDescription("Nike Slides size 11 colour blue and white");
        Task task1 = new Task("Buy school bag", TaskState.TODO);
        Task task2 = new Task("Read Children Of Blood and Bone Book", TaskState.DONE);
        Task task3 = new Task("Sell smoothies and juices today", TaskState.ONGOING);
        task3.setTaskDescription("Sold 5 bottles of juices today, 2 juices left; " +
                "No smoothies sold out today");
        taskRepository.save(task);
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        assertEquals(4, taskRepository.count());
    }

    @Test
    void testThatTodoCanBeUpdatedById(){
        Optional<Task> optionalTask = taskRepository.findById(2L);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setTaskName("Buy laptop");
            taskRepository.save(task);
            assertEquals("Buy laptop", task.getTaskName());
        }
    }

    @Test
    void testThatTodoCanBeDeletedById(){
        Optional<Task> optionalTask = taskRepository.findById(1L);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            taskRepository.delete(task);
            assertEquals(3, taskRepository.count());
        }
    }

}