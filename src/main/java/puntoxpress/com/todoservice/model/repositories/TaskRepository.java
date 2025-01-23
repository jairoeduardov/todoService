package puntoxpress.com.todoservice.model.repositories;

import puntoxpress.com.todoservice.model.entities.Task;

import java.util.List;

public interface TaskRepository extends BaseRepository<Task, Long>{
    List<Task> findByTaskListUuid(String uuid);
}
