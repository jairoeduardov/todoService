package puntoxpress.com.todoservice.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Tag extends AbstractEntity{
    private String name;
    private String color;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
