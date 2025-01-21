package puntoxpress.com.todoservice.model.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
//@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
//@JsonTypeName("generalResponse")
public class ResponseErrorDto {

    private Object data = new Object();
    private List<ErrorDto> errors;
}
