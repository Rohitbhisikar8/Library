package com.book_library_api.repository;

import com.book_library_api.entity.Category;
import java.awt.print.Book;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book_library_api.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	@Query("SELECT o FROM BookEntity o WHERE o.category = :category")
	List<BookEntity> findBookByCategoryCustom(@Param("category") Category category);

	@Query("SELECT o FROM BookEntity o WHERE o.author = :author")
	List<BookEntity> findBookByAuthor(@Param("author") String authorName);

}
