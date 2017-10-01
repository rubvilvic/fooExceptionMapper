package es.rubvilvic.fooExceptionMapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.rubvilvic.fooExceptionMapper.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
