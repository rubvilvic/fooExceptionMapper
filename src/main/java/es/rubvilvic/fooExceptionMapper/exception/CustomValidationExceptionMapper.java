package es.rubvilvic.fooExceptionMapper.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.aspectj.bridge.Message;

public class CustomValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException>{

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), "VALIDATION");
		for(ConstraintViolation<?> violation: exception.getConstraintViolations()) {
			errorResponse.addField(violation.getPropertyPath().toString(), violation.getMessage());
		}
		return Response.status(Status.BAD_REQUEST).entity(errorResponse.toJson()).build();
	}
	
	

}
