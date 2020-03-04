package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Aapinen", "Otava",2018, "12-3-4", 19.9);
			Book b2 = new Book("Jalkapallo", "Rive",2020, "18-3-9", 29.9);
			Book b3 = new Book("Ruoka", "Makula",2015, "10-5-89", 15.89);
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}
}
