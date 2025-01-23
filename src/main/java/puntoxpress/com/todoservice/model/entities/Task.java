package puntoxpress.com.todoservice.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import puntoxpress.com.todoservice.model.enums.TaskPriority;
import puntoxpress.com.todoservice.model.enums.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"title", "task_list_id"})
)
public class Task extends AbstractEntity {
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime dueDate;
    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private TaskList taskList;
}
