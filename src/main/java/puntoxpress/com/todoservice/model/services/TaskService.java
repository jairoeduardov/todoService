package puntoxpress.com.todoservice.model.services;

import puntoxpress.com.todoservice.model.dto.RequestDto;
import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.TaskDto;
import puntoxpress.com.todoservice.model.entities.Task;

public interface TaskService extends BaseService<Task, TaskDto> {
	 ResponseDto<TaskDto> add(RequestDto<TaskDto> request) throws Exception;
	 ResponseDto<TaskDto> update(RequestDto<TaskDto> request, String uuid) throws Exception;	
}

