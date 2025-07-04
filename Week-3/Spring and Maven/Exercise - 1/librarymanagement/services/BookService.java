package com.cognizant.librarymanagement.services;

import com.cognizant.librarymanagement.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        System.out.println("Adding book: " + bookName);
        if (bookRepository != null) {
            bookRepository.saveBook(bookName);
        } else {
            System.out.println("BookRepository is not set!");
        }
    }
}