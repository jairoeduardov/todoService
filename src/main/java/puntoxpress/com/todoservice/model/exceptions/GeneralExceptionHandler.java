package puntoxpress.com.todoservice.model.exceptions;



import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import puntoxpress.com.todoservice.model.dto.ErrorDto;
import puntoxpress.com.todoservice.model.dto.ResponseErrorDto;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// Crear un ErrorDto con los detalles de la excepción
		ErrorDto error = ErrorDto.builder()
				.code("DATA_INTEGRITY_VIOLATION")
				.id(UUID.randomUUID().toString()) // ID único para rastrear el error
				.date(LocalDateTime.now())
				.detail(ex.getMostSpecificCause().getMessage()) // Mensaje detallado de la excepción
				.title("Data Integrity Violation")
				.build();

		// Construir la respuesta con el ErrorDto
		ResponseErrorDto response = ResponseErrorDto.builder()
				.errors(List.of(error)) // Agregar el error en la lista
				.build();

		return new ResponseEntity<>(response, headers, HttpStatus.CONFLICT);
	}
	
}
