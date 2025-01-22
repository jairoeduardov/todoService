package puntoxpress.com.todoservice.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import puntoxpress.com.todoservice.model.dto.TaskTagDto;
import puntoxpress.com.todoservice.model.entities.TaskTag;

import java.util.List;


@Mapper
public interface TaskTagMapper {
    TaskTagMapper INSTANCE = Mappers.getMapper(TaskTagMapper.class);

   
    TaskTagDto taskTagToTaskTagDto(TaskTag taskTag);
    TaskTag taskTagDtoToTaskTag(TaskTagDto taskTagDto);
    void updateTaskTagFromDto(TaskTagDto dto, @MappingTarget TaskTag entity);
    List<TaskTagDto> taskTagsToTaskTagDtos(List<TaskTag> taskTags);
}
