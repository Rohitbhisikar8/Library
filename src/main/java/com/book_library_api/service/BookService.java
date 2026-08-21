package com.book_library_api.service;

import com.book_library_api.controller.Book_Controller;
import java.util.List;
import com.book_library_api.entity.Category;
import com.book_library_api.exceptions.IdNotFoundException;

import java.util.Optional;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book_library_api.entity.BookEntity;
import com.book_library_api.repository.BookRepository;
import com.book_library_api.request.BookRequest;

import jakarta.transaction.Transactional;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	

	public BookEntity getbook(BookRequest bookRequest) {
		BookEntity entity = new BookEntity();

		entity.setTitle(bookRequest.getTitle());
		entity.setAuthor(bookRequest.getAuthor());
		entity.setIsbn(bookRequest.getIsbn());
		entity.setPrice(bookRequest.getPrice());
		entity.setPublishedDate(bookRequest.getPublishedDate());
		entity.setAvailable(bookRequest.isAvailable());
		entity.setCategory(bookRequest.getCategory());

		return bookRepository.save(entity);
	}

	public Optional<BookEntity> getByID(Integer bookid) {
		Optional<BookEntity> allById = bookRepository.findById(bookid);
		return allById;

	}

	public List<BookEntity> getAllInfo() {
		List<BookEntity> all = bookRepository.findAll();
		return all;

	}

	public List<BookEntity> getByCategory(Category category) {
		return bookRepository.findBookByCategoryCustom(category);

	}

	public List<BookEntity> getByAuthor(String author) {
		return bookRepository.findBookByAuthor(author);

	}

	public String deleteBook(Integer id) {

		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return "Book deleted successfully with ID: " + id;
		} else {
			return "Book not found with ID: " + id;
		}
	}

	@Transactional
	public BookEntity updateBook(Integer id, BookRequest bookRequest) {
		Optional<BookEntity> optionalBook = bookRepository.findById(id);

		if (optionalBook.isPresent()) {
			BookEntity existingBook = optionalBook.get();

			existingBook.setTitle(bookRequest.getTitle());
			existingBook.setAuthor(bookRequest.getAuthor());
			existingBook.setIsbn(bookRequest.getIsbn());
			existingBook.setPrice(bookRequest.getPrice());
			existingBook.setPublishedDate(bookRequest.getPublishedDate());
			existingBook.setAvailable(bookRequest.isAvailable());
			existingBook.setCategory(bookRequest.getCategory());

			return bookRepository.save(existingBook);
		}
		throw new IdNotFoundException("Book not found with ID:" + id);
	}

}
