package com.yakush.task_management;

import com.yakush.task_management.models.Role;
import com.yakush.task_management.models.User;
import com.yakush.task_management.security.JwtProvider;
import com.yakush.task_management.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class TaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			UserService userService,
			JwtProvider jwtProvider
	) {
		return args -> {
			User user = User.builder()
					.email("default_user@mail.test")
					.password("defoult-user-password")
					.name("Default User")
					.role(Role.USER)
					.build();

			try {
				userService.saveUser(user);
			} catch (Exception ignored){}
			System.out.println("Demo user:");
			System.out.println("Demo user token: " + jwtProvider.generateToken(user.getEmail()));
		};
	}

}
