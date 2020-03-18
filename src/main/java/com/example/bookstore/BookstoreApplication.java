package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;



@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			crepository.save(new Category("Lifestyle"));
			crepository.save(new Category("Fiction"));
			

			Book b1 = new Book("Aapinen", "Otava",2018, "12-3-4", 19.9, crepository.findByName("Fiction").get(0));
			Book b2 = new Book("Jalkapallo", "Rive",2020, "18-3-9", 29.9, crepository.findByName("Lifestyle").get(0));
			Book b3 = new Book("Ruoka", "Makula",2015, "10-5-89", 15.89, crepository.findByName("Lifestyle").get(0));
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		User user3 = new User("Vilma", "$2a$10$gzIPIhIQZDJ44ubLk82lfuad64VrR1nsdsxYhxdh.kjRVfq.n27rK", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		urepository.save(user3);
		
		};
	}
	
}
