package com.popcorn;

import com.datastax.oss.driver.api.core.CqlSession;
import com.google.gson.Gson;
import com.popcorn.document.UserDocument;
import com.popcorn.repository.UserRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.config.EnableCassandraAuditing;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableCassandraAuditing
@EnableCassandraRepositories
public class CassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassandraApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			//ProductRepository productRepository,
			UserRepository userRepository,
			Gson jsonHelper,
			CqlSession cqlSession
	) {
		return args -> {
			/*Faker faker = new Faker();
			for(int i=1;i<=1000;i++) {
				//helper(userRepository, jsonHelper, faker);
				System.out.println(i*1000 + " Inserts completed.");
			}*/
		};
	}

	private void helper(UserRepository userRepository, Gson jsonHelper, Faker faker) {
		List<UserDocument> users = new ArrayList<>();
		int max = 1000;
		for(int i=1; i<max; i++) {
			String country = faker.country().name().replaceAll("[^a-zA-Z0-9]", " ");
			String firstName = faker.name().firstName().replaceAll("[^a-zA-Z0-9]", " ");
			String lastName = faker.name().lastName().replaceAll("[^a-zA-Z0-9]", " ");
			String fullName = firstName + " " + lastName;
			String email = String.valueOf(fullName.replaceAll("[^a-zA-Z0-9]", ".") + "@email.com").toLowerCase();
			UserDocument user = UserDocument.builder()
					.country(country)
					.lastName(lastName)
					.firstName(firstName)
					.email(email)
					.uid(UUID.randomUUID())
					.build();
			// System.out.println(jsonHelper.toJson(user));
			users.add(user);
		}
		userRepository.saveAll(users);
	}
}
