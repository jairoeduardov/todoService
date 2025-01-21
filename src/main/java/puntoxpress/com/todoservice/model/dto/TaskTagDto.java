package puntoxpress.com.todoservice.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaskTagDto extends AbstractDto implements Identifable {
    private TaskDto task;
    private TagDto tag;
}
