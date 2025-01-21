package puntoxpress.com.todoservice.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import puntoxpress.com.todoservice.model.entities.AbstractEntity;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends AbstractEntity, ID extends Serializable> extends JpaRepository<T, ID> {

    Optional<T> findByUuid(String uuid);

    void deleteByUuid(String uuid);

}
