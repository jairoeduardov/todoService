package puntoxpress.com.todoservice.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseListDto <T extends Identifiable>{
    List<T> data;
    private List<Error> errors;
}
