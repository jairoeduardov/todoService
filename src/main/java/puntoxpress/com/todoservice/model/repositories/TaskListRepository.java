package puntoxpress.com.todoservice.model.repositories;

import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.entities.TaskList;

import java.util.List;

public interface TaskListRepository extends BaseRepository<TaskList, Long>{
    public List<TaskList> findByUserUuid(String uuid);
}
