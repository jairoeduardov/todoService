package puntoxpress.com.todoservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ResponseErrorDto {

    private Object data = new Object();
    private List<ErrorDto> errors;
}
