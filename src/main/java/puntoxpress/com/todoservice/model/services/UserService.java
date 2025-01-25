package puntoxpress.com.todoservice.model.services;

import puntoxpress.com.todoservice.model.dto.*;
import puntoxpress.com.todoservice.model.entities.User;

public interface UserService extends BaseService<User, UserDto> {
    ResponseDto<UserDto> add(RequestDto<UserDto> request) throws Exception;
    ResponseDto<UserDto> update(RequestDto<UserDto> request, String uuid) throws Exception;
    ResponseListDto<TaskListDto> findTaskListByUserUuid(String uuid) throws Exception;
}
