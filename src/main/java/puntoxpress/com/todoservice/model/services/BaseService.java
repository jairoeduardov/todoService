package puntoxpress.com.todoservice.model.services;

import puntoxpress.com.todoservice.model.dto.Identifiable;
import puntoxpress.com.todoservice.model.dto.RequestDto;
import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.ResponseListDto;
import puntoxpress.com.todoservice.model.entities.AbstractEntity;

public interface BaseService<T extends AbstractEntity, K extends Identifiable> {
    ResponseDto<K> add(RequestDto<K> request) throws Exception;
    ResponseDto<K> get(String uuid) throws Exception;
    ResponseListDto<K> getAll() throws Exception;
    ResponseDto<K> update(RequestDto<K> request, String uuid) throws Exception;
    ResponseDto<K> remove(String uuid) throws Exception;
}
