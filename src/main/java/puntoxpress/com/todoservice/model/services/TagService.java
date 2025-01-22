package puntoxpress.com.todoservice.model.services;

import puntoxpress.com.todoservice.model.dto.RequestDto;
import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.TagDto;
import puntoxpress.com.todoservice.model.entities.Tag;

public interface TagService extends BaseService<Tag, TagDto> {
	 ResponseDto<TagDto> add(RequestDto<TagDto> request) throws Exception;
	 ResponseDto<TagDto> update(RequestDto<TagDto> request, String uuid) throws Exception;
}
