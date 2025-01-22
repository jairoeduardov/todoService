package puntoxpress.com.todoservice.model.services;

import puntoxpress.com.todoservice.model.dto.RequestDto;
import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.TaskTagDto;
import puntoxpress.com.todoservice.model.entities.TaskTag;

public interface TaskTagService extends BaseService<TaskTag, TaskTagDto> {
	 ResponseDto<TaskTagDto> add(RequestDto<TaskTagDto> request) throws Exception;
	 ResponseDto<TaskTagDto> update(RequestDto<TaskTagDto> request, String uuid) throws Exception;
}
