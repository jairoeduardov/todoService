package puntoxpress.com.todoservice.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseDto<T extends Identifable> {
    private T data;
    private List<Error> errors;
}
