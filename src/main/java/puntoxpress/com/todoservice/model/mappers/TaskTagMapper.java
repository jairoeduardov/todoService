package puntoxpress.com.todoservice.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TaskTagMapper {
    TaskTagMapper INSTANCE = Mappers.getMapper(TaskTagMapper.class);
}
