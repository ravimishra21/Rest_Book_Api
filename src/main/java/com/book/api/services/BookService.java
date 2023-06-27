package com.book.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.api.dao.BookRepository;
import com.book.api.entities.Book;

@Component
public class BookService {

//	this is used for rough data 
//	private static List<Book>list =new ArrayList<>();
//	static {
//		list.add(new Book(2,"js2","AAA"));
//		list.add(new Book(3,"js3","BBB"));
//		list.add(new Book(4,"js4","CCC"));
//		list.add(new Book(5,"js5","DDD"));
//	}
	
	@Autowired
	private BookRepository bookRepository;
	
//	to get all book
	public List<Book> getAllBooks(){
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
//	get single book by id
	public Book getBookById(int id) {
		Book book=null;
//		book=list.stream().filter(e-> e.getId()==id).findFirst().get();
		try {
			book=this.bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
//	adding the book
	public Book addBook(Book b) {
		Book result=bookRepository.save(b);
		return result;
	}
	
//	delete the book
	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
	}
	
//	update the book
	public void updateBook(Book book , int bookId) {
		book.setId(bookId);
		bookRepository.save(book);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 