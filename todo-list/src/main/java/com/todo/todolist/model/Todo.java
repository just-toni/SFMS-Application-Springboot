package com.todo.todolist.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Todo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long todoId;
    @NonNull
    private String todoName;
    private String todoDescription;
    @OneToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    @NotNull
    @Column(name = "todo_task")
    private Set<Task> tasks;
}
