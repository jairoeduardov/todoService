package puntoxpress.com.todoservice.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import puntoxpress.com.todoservice.model.enums.TaskPriority;
import puntoxpress.com.todoservice.model.enums.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaskDto extends AbstractDto implements Identifiable {
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDate updatedAt;
    private UserDto user;
}
