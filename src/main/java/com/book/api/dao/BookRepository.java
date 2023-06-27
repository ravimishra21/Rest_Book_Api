package com.book.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.book.api.entities.Book;

public interface BookRepository extends CrudRepository<Book , Integer>{

	public Book findById(int id);
}
