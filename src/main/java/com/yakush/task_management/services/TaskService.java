package com.yakush.task_management.services;

import com.yakush.task_management.dto.comment.CommentDto;
import com.yakush.task_management.dto.task.TaskDto;
import com.yakush.task_management.models.TaskPriority;
import com.yakush.task_management.models.TaskStatus;
import com.yakush.task_management.models.User;

import java.util.List;


public interface TaskService {
    List<TaskDto> findAllTasks();
    TaskDto findTaskById(Long id);
    TaskDto createTask(TaskDto taskDto);
    void deleteTaskById(Long id, User author);

    TaskDto updateTaskTitleById(Long id, String title, User author);
    TaskDto updateTaskDescriptionById(Long id, String description, User author);
    TaskDto updateTaskStatusById(Long id, Integer taskStatusValue, User authorOrAssignee);
    TaskDto updateTaskPriorityById(Long id, Integer taskPriorityValue, User author);
    TaskDto removeAssigneeByIdInTask( Long taskId, Long assigneeId, User author);
    TaskDto removeAssigneeByEmailInTask(Long taskId, String assigneeEmail, User author);
    TaskDto appendAssigneeByIdInTask(Long taskId, Long assigneeId, User author);
    TaskDto appendAssigneeByEmailInTask(Long taskId, String assigneeEmail, User author);
    TaskDto appendCommentInTask(Long taskId, CommentDto commentDto, User commentator);
    TaskDto removeCommentByIdInTask(Long taskId, Long commentId, User commentatorOrTaskAuthor);

    List<TaskDto> findAllTasksByAuthor(User author);
    List<TaskDto> findAllTasksByAssignee(User assignee);
}
