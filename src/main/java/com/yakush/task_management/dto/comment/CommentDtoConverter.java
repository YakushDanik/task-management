package com.yakush.task_management.dto.comment;

import com.yakush.task_management.dto.DtoConverter;
import com.yakush.task_management.dto.user.UserResponseConverter;
import com.yakush.task_management.models.Comment;
import com.yakush.task_management.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CommentDtoConverter implements DtoConverter<Comment, CommentDto, String, CommentResponse> {

    @Autowired
    private UserResponseConverter userResponseConverter;

    @Override
    public CommentDto convertEntityToDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .task(comment.getTask())
                .dateTime(comment.getDateTime())
                .commentator(comment.getCommentator())
                .build();
    }

    @Override
    public Comment convertDtoToEntity(CommentDto commentDto) {
        return Comment.builder()
                .id(commentDto.getId())
                .text(commentDto.getText())
                .commentator(commentDto.getCommentator())
                .dateTime(commentDto.getDateTime())
                .task(commentDto.getTask())
                .build();
    }

    @Override
    public CommentDto convertRequestToDto(String commentText) {
        return CommentDto.builder()
                .text(getNonBlankString(commentText))
                .build();
    }

    @Override
    public CommentResponse convertDtoToResponse(CommentDto commentDto) {
        return CommentResponse.builder()
                .id(commentDto.getId())
                .commentator(userResponseConverter.convertUserToResponse(commentDto.getCommentator()))
                .text(commentDto.getText())
                .dateTime(commentDto.getDateTime())
                .build();
    }

    private String getNonBlankString(String value) {
        return (value != null && !value.isBlank()) ? value : null;
    }

}
