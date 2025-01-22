package puntoxpress.com.todoservice.model.services;

import puntoxpress.com.todoservice.model.dto.RequestDto;
import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.entities.TaskList;

public interface TaskListService extends BaseService<TaskList, TaskListDto> {
	 ResponseDto<TaskListDto> add(RequestDto<TaskListDto> request) throws Exception;
	    ResponseDto<TaskListDto> update(RequestDto<TaskListDto> request, String uuid) throws Exception;
}
