package com.yakush.task_management.dto.comment;

import com.yakush.task_management.models.Task;
import com.yakush.task_management.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private Long id;
    private String text;
    private LocalDateTime dateTime;
    private User commentator;
    private Task task;
}
