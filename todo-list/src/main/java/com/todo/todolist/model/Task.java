package com.todo.todolist.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long taskId;
    @NonNull
    private String taskName;
    private String taskDescription;
    @NonNull
    @Enumerated(EnumType.STRING)
    private TaskState taskState;
    @JoinColumn(name = "todo_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Task tasks;
}
