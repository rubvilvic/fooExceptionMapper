package es.rubvilvic.fooExceptionMapper.controller;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.rubvilvic.fooExceptionMapper.model.Book;
import es.rubvilvic.fooExceptionMapper.service.BookService;

@Controller
@Path("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{oid}")
	public Book getBook(@PathParam("oid") Long oid) {
		return bookService.getBookById(oid);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBook(Book book) {
		book = bookService.saveBook(book);
		return Response.created(URI.create("/"+book.getId())).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{oid}")
	public Response updateBook(@PathParam("oid") Long oid, Book book) {
		book = bookService.saveBook(book);
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{oid}")
	public Response deleteBook(@PathParam("oid") Long oid) {
		bookService.deleteBookById(oid);
		return Response.ok().build();
	}
	
	
}
