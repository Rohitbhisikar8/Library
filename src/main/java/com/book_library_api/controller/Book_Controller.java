package com.book_library_api.controller;

import com.book_library_api.entity.Category;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.book_library_api.entity.BookEntity;
import com.book_library_api.request.BookRequest;
import com.book_library_api.service.BookService;

@RestController
@RequestMapping("/openbook")
public class Book_Controller {
	@Autowired
	BookService bookService;

	@PostMapping("/addBook")
	public BookEntity getBook(@RequestBody BookRequest request) {
		BookEntity getbook = bookService.getbook(request);
		return getbook;
	}

	@GetMapping("/getByID")
	public Optional<BookEntity> getById(@RequestParam Integer ids) {

		Optional<BookEntity> byID = bookService.getByID(ids);
		return byID;

	}

	@GetMapping("all")
	public List<BookEntity> getAllInfo() {
		List<BookEntity> allInfo = bookService.getAllInfo();

		return allInfo;

	}

	@GetMapping("/byCategory")
	public List<BookEntity> getByCategory(@RequestParam Category category) {
		List<BookEntity> byCategory = bookService.getByCategory(category);

		return byCategory;

	}

	@GetMapping("/byAuthor/{name}")
	public List<BookEntity> getByAuthor(@PathVariable("name") String author) {
		List<BookEntity> byAuthor = bookService.getByAuthor(author);
		return byAuthor;

	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Integer id) {
		String deleteBook = bookService.deleteBook(id);
		return deleteBook;

	}

	@PutMapping("/addBook/{id}")
	public BookEntity addBook(@PathVariable("id") Integer id, @RequestBody BookRequest request) {
		BookEntity book = bookService.updateBook(id, request);
		return book;

	}
}
