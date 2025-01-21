package puntoxpress.com.todoservice.model.dto;

import java.util.List;

public class ResponseListDto <T extends  Identifable>{
    List<T> data;
    private List<Error> errors;
}
