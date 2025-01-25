package puntoxpress.com.todoservice.model.dto;


import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import puntoxpress.com.todoservice.model.entities.Task;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaskListDto extends AbstractDto implements Identifiable {
    private String name;
    private String description;
    private UserBaseDto user;
    private List<TaskDto> tasks;
}