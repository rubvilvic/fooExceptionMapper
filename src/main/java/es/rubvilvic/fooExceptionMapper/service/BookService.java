package es.rubvilvic.fooExceptionMapper.service;

import java.util.Collection;

import es.rubvilvic.fooExceptionMapper.model.Book;

public interface BookService {

	public Collection<Book> getAllBooks();
	
	public Book getBookById(Long id);
	
	public void deleteBookById(Long id);
	
	public Book saveBook(Book book);
	
}
