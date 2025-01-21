package puntoxpress.com.todoservice.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskListMapper {
    TaskListMapper INSTANCE = Mappers.getMapper(TaskListMapper.class);
}
