package puntoxpress.com.todoservice.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TagDto extends AbstractDto implements Identifable {
    private String name;
    private String color;
    private UserDto user;
}
