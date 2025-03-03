package com.yakush.task_management.repositories;

import com.yakush.task_management.models.Task;
import com.yakush.task_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByAuthor(User author);
    List<Task> findAllByAssigneesContains(User assignee);
}
