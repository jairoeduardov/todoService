package puntoxpress.com.todoservice.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String uuid;

    @PrePersist
    public void generarUUID() {
        if (uuid == null || uuid.isEmpty() || uuid.equalsIgnoreCase("string")) {
            uuid = UUID.randomUUID().toString();
        }
    }
}
