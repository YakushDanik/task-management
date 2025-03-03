package com.yakush.task_management.services;

import com.yakush.task_management.dto.comment.CommentDto;
import com.yakush.task_management.dto.task.TaskDto;
import com.yakush.task_management.models.Task;
import com.yakush.task_management.models.User;

import java.util.List;


public interface CommentService {
    CommentDto findCommentById(Long id);
    CommentDto createComment(CommentDto commentDto);
    void deleteCommentById(Long id, User commentatorOrTaskAuthor);
    Task deleteAllCommentsInTask(Task task);
    CommentDto updateText(Long id, String text, User commentator);
}
