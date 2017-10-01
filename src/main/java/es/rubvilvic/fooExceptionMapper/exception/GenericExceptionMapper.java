package es.rubvilvic.fooExceptionMapper.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.catalina.mapper.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), "UNKNOWN");
		return Response.serverError().entity(errorResponse.toJson()).build();
	}

	
}
