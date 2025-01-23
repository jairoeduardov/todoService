package puntoxpress.com.todoservice.model.services;

import puntoxpress.com.todoservice.model.dto.*;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.entities.TaskList;

public interface TaskListService extends BaseService<TaskList, TaskListDto> {
	 ResponseDto<TaskListDto> add(RequestDto<TaskListDto> request) throws Exception;
	 ResponseDto<TaskListDto> update(RequestDto<TaskListDto> request, String uuid) throws Exception;
	 ResponseListDto<TaskDto> getTaskByTaskListUuid(String uuid) throws Exception;
}
