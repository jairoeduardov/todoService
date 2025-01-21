package puntoxpress.com.todoservice.model.exceptions;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import puntoxpress.com.todoservice.model.dto.ResponseErrorDto;

import java.io.Serial;

@ControllerAdvice
public class GeneralExceptionHandler extends Exception {

	@Serial
	private static final long serialVersionUID = -3529314902895179493L;

	@ExceptionHandler(GeneralResponseException.class)
	public ResponseEntity<Object> genericError(GeneralResponseException ex){
		
		HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);


		return new ResponseEntity<>(ResponseErrorDto.builder()
				.errors(ex.getErrorResponse().getErrors()).build() ,
				headers,
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleException(MethodArgumentNotValidException ex){
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
		return null;
	}

	
}
