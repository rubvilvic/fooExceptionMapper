package es.rubvilvic.fooExceptionMapper.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rubvilvic.fooExceptionMapper.model.Book;
import es.rubvilvic.fooExceptionMapper.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository repo;
	
	@Override
	public Collection<Book> getAllBooks() {
		return repo.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public void deleteBookById(Long id) {
		repo.delete(id);
	}

	@Override
	public Book saveBook(Book book) {
		return repo.save(book);
	}
	

}
