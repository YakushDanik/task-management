package com.yakush.task_management.services.impl;

import com.yakush.task_management.dto.comment.CommentDto;
import com.yakush.task_management.dto.comment.CommentDtoConverter;
import com.yakush.task_management.models.Comment;
import com.yakush.task_management.models.Task;
import com.yakush.task_management.models.User;
import com.yakush.task_management.repositories.CommentRepository;
import com.yakush.task_management.services.CommentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Primary
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentDtoConverter commentDtoConverter;

    @Override
    public CommentDto findCommentById(Long id) {
        return commentDtoConverter.convertEntityToDto(getCommentById(id));
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        validateText(commentDto.getText());

        Comment comment = commentDtoConverter.convertDtoToEntity(commentDto);
        comment.setDateTime(LocalDateTime.now());

        return commentDtoConverter.convertEntityToDto(commentRepository.save(comment));
    }

    @Override
    public void deleteCommentById(Long id, User commentatorOrTaskAuthor) {
        Comment comment = getCommentById(id);
        validateCommentatorOrTaskAuthor(comment, commentatorOrTaskAuthor);
        commentRepository.delete(comment);
    }

    @Override
    public Task deleteAllCommentsInTask(Task task) {
        commentRepository.deleteAllByTask(task);
        task.getComments().clear();
        return task;
    }

    @Override
    public CommentDto updateText(Long id, String text, User commentator) {
        Comment comment = getCommentById(id);
        validateText(text);
        validateCommentator(comment, commentator);

        comment.setText(text);
        comment.setDateTime(LocalDateTime.now());

        return commentDtoConverter.convertEntityToDto(commentRepository.save(comment));
    }

    private void validateText(String text){
        if (text == null)
            throw new IllegalArgumentException("Comment text is empty!");
    }

    private Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("comment with id=" + id + " not found!"));
    }

    private void validateCommentatorOrTaskAuthor(Comment comment, User commentatorOrTaskAuthor) {
        if (!comment.getTask().getAuthor().equals(commentatorOrTaskAuthor)
                && !comment.getCommentator().equals(commentatorOrTaskAuthor)) {
            throw new IllegalArgumentException("Only the commentator or task author can delete the comment!");
        }
    }

    private void validateCommentator(Comment comment, User commentator) {
        if (!comment.getCommentator().equals(commentator)) {
            throw new IllegalArgumentException("Only the commentator can change the comment!");
        }
    }
}
