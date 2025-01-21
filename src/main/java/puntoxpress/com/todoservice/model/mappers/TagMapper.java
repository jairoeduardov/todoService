package puntoxpress.com.todoservice.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import puntoxpress.com.todoservice.model.dto.TagDto;
import puntoxpress.com.todoservice.model.entities.Tag;

import java.util.List;

@Mapper
public interface TagMapper {
    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);
    TagDto tagToTagDto(Tag tag);
    Tag tagDtoToTag(TagDto tagDto);
    void updateTagFromDto(TagDto dto, @MappingTarget Tag entity);
    List<TagDto> tagsToTagDtos(List<Tag> tags);
}
