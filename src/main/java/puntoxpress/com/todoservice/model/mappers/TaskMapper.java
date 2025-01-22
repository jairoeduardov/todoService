package puntoxpress.com.todoservice.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import puntoxpress.com.todoservice.model.dto.TaskDto;
import puntoxpress.com.todoservice.model.entities.Task;

import java.util.List;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDto taskToTaskDto(Task task);
    Task taskDtoToTask(TaskDto taskDto);
    void updateTaskFromDto(TaskDto dto, @MappingTarget Task entity);
    List<TaskDto> tasksToTaskDtos(List<Task> tasks);
}
