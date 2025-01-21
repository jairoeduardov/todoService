package puntoxpress.com.todoservice.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MethodType{
    CREATE,
    UPDATE,
    DELETE,
    RETRIEVE,
    ALL
}