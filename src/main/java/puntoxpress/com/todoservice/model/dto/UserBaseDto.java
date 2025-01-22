package puntoxpress.com.todoservice.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserBaseDto extends AbstractDto implements Identifiable {
    private String username;
    private String email;
    private String password;
    private String name;
    private String firstName;
}
