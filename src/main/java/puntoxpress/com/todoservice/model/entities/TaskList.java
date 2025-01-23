package puntoxpress.com.todoservice.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "user_id"})
)
public class TaskList extends AbstractEntity {
    private String name;
    private String description;
    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
