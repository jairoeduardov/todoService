package puntoxpress.com.todoservice.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDto <T extends Identifiable>{
    private T data;
}
