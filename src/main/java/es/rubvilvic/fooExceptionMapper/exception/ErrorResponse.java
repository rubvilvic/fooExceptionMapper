package es.rubvilvic.fooExceptionMapper.exception;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ErrorResponse {
	
	private String message;
	private String code;
	private List<FieldErrorResponse> fields;
	
	private final static ObjectMapper MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	
	public ErrorResponse(String message, String code) {
		this.message = message;
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	public String getCode() {
		return code;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void addField(String field, String message) {
		if(this.fields == null) {
			this.fields = new ArrayList<FieldErrorResponse>();
		}
		this.fields.add(new FieldErrorResponse(field, message));
		
	}

	public String toJson() {
		try {
			return MAPPER.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "{\"message\":\"An internal error occurred\"}";
		}
	}

	public List<FieldErrorResponse> getFields() {
		return fields;
	}

	public void setFields(List<FieldErrorResponse> fields) {
		this.fields = fields;
	}
	
	

}
