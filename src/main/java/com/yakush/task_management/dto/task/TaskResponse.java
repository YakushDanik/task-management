package com.yakush.task_management.dto.task;

import com.yakush.task_management.dto.comment.CommentResponse;
import com.yakush.task_management.dto.user.UserResponse;
import com.yakush.task_management.models.TaskPriority;
import com.yakush.task_management.models.TaskStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.KebabCaseStrategy.class)
@Schema(name = "Task Response")
public class TaskResponse {

    @Schema(example = "1")
    private Long id;

    @Size(max = 255)
    @Schema(example = "Example task title")
    private String title;

    @Schema(example = "Example task description")
    private String description;

    private TaskProperty status;

    private TaskProperty priority;

    private UserResponse author;

    private List<UserResponse> assignees = new ArrayList<>();

    private List<CommentResponse> comments = new ArrayList<>();

}
