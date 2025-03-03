package com.yakush.task_management.dto.task;

import com.yakush.task_management.models.TaskPriority;
import com.yakush.task_management.models.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class TaskProperty {
    private String text;
    private int value;

    public TaskProperty(TaskStatus taskStatus) {
        this.text = taskStatus.getText();
        this.value = taskStatus.getValue();
    }

    public TaskProperty(TaskPriority taskPriority) {
        this.text = taskPriority.getText();
        this.value = taskPriority.getValue();
    }
}
