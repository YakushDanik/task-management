package com.yakush.task_management.dto.user;

import com.yakush.task_management.models.User;
import org.springframework.stereotype.Component;


@Component
public class UserResponseConverter {
    public UserResponse convertUserToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail()).build();
    }
}
