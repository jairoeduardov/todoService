package puntoxpress.com.todoservice.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.entities.TaskList;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskListMapper {
    TaskListMapper INSTANCE = Mappers.getMapper(TaskListMapper.class);
    
    TaskListDto taskListToTaskListDto(TaskList taskList);
    TaskList taskListDtoToTaskList(TaskListDto taskListDto);
    void updateTaskListFromDto(TaskListDto dto, @MappingTarget TaskList entity);
    List<TaskListDto> taskListsToTaskListDtos(List<TaskList> taskLists);
}
