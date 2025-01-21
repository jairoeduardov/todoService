package puntoxpress.com.todoservice.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import puntoxpress.com.todoservice.model.enums.TaskPriority;
import puntoxpress.com.todoservice.model.enums.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Task extends AbstractEntity {
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDate updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
