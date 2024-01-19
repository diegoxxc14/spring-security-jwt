package com.demo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.models.ERole;
import com.demo.models.RoleEntity;
import com.demo.models.UserEntity;
import com.demo.repositories.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Bean
	CommandLineRunner init(){
		return args -> {
			UserEntity userEntity1 = UserEntity.builder()
				.email("diego@gmail.com")
				.username("diego")
				.password(passwordEncoder.encode("1234"))
				.roles(Set.of(RoleEntity.builder()
					.name(ERole.valueOf(ERole.ADMIN.name()))
					.build()))
				.build();

			UserEntity userEntity2 = UserEntity.builder()
				.email("juan@gmail.com")
				.username("juan")
				.password(passwordEncoder.encode("1234"))
				.roles(Set.of(RoleEntity.builder()
					.name(ERole.valueOf(ERole.USER.name()))
					.build()))
				.build();
			
			UserEntity userEntity3 = UserEntity.builder()
				.email("silvis@gmail.com")
				.username("silvis")
				.password(passwordEncoder.encode("1234"))
				.roles(Set.of(RoleEntity.builder()
					.name(ERole.valueOf(ERole.INVITED.name()))
					.build()))
				.build();

			userRepository.save(userEntity1);
			userRepository.save(userEntity2);
			userRepository.save(userEntity3);
		};
	}
}
