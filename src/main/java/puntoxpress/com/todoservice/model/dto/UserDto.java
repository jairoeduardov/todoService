package puntoxpress.com.todoservice.model.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends AbstractDto implements Identifiable {
    private String username;
    private String email;
    private String password;
    private String name;
    private String firstName;
}