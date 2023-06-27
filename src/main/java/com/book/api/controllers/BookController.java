package com.book.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.book.api.entities.Book;
import com.book.api.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
//	@GetMapping("/books")
//	public Book getBookOne() {
//		Book book=new Book();
//		book.setId(11);
//		book.setTitle("java");
//		book.setAuthor("ABC");
//		return book;
//	}
	
	
	

//	
//	@GetMapping("/books/{id}")
//	public Book getBook(@PathVariable("id") int id) {
//		return bookService.getBookById(id);
//	}
	
//	@GetMapping("/booksAll")
//	public List<Book> getBooks(){
//		return this.bookService.getAllBooks();
//	}
	
	
	
//	Handling HttpStatus while creating REST Api
//	get all books handler
	
	@GetMapping("/booksAll")
	public ResponseEntity<List<Book>> getBooks(){
		
		List<Book> list=bookService.getAllBooks();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id){
		
		 Book book= bookService.getBookById(id);
		 if(book == null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(book));
	}
	
//	new book Adding handler
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		
		Book b=null;
		try {
			b=this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
//	Delete book handler
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
		
		try {
			this.bookService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
//	update book handler
	@PutMapping("/books/{bookId}") 
	public ResponseEntity<Book> updateBook(@RequestBody Book book , @PathVariable("bookId") int bookId){
		
		try {
			this.bookService.updateBook(book , bookId);
			return ResponseEntity.ok().body(book);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	In this rest book api project , we can add the book details like book_id , title , 
//	author name .we can delete the book details, update the book details and
//	see all the book at once time .This project is created by using spring boot framework .
	
	
	
}
