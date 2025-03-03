package com.yakush.task_management.repositories;

import com.yakush.task_management.models.Comment;
import com.yakush.task_management.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    void deleteAllByTask(Task task);
}
