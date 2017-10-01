package es.rubvilvic.fooExceptionMapper;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import es.rubvilvic.fooExceptionMapper.controller.BookController;
import es.rubvilvic.fooExceptionMapper.exception.GenericExceptionMapper;
import es.rubvilvic.fooExceptionMapper.exception.CustomValidationExceptionMapper;

@Configuration
@ApplicationPath("rest")
public class JerseyConfiguration extends ResourceConfig{

	public JerseyConfiguration() {
		
	}
	
	@PostConstruct
	public void setUp() {
		register(BookController.class);
		register(GenericExceptionMapper.class);
		register(CustomValidationExceptionMapper.class);
	}
}
