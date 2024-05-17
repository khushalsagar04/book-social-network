package com.khushal.booksocialnetwork;

import com.khushal.booksocialnetwork.role.Role;
import com.khushal.booksocialnetwork.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class BookSocialNetworkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookSocialNetworkApiApplication.class, args);
		System.out.println("Application is up and running");
	}
	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository){
		return args -> {
			if(roleRepository.findByRoleName("USER").isEmpty()){
				roleRepository.save(
						Role.builder().roleName("USER").build()
				);
			}
		};
	}

}
