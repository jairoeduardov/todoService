package puntoxpress.com.todoservice.model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import puntoxpress.com.todoservice.model.dto.ResponseErrorDto;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = false)
public class GeneralResponseException extends Exception {
	
	@Serial
	private static final long serialVersionUID = -3630251846681068668L;

	private final transient ResponseErrorDto errorResponse;

	public GeneralResponseException(ResponseErrorDto ex) {
		super(ex.getErrors().get(0).getDetail());
		this.errorResponse = ex;
	}

}
