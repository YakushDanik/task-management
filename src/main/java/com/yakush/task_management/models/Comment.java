package com.yakush.task_management.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDateTime dateTime;


    @ManyToOne
    @JoinColumn(name = "commentator_id")
    private User commentator;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                ", commentator=" + commentator +
                ", taskId=" + task.getId() +
                '}';
    }
}
