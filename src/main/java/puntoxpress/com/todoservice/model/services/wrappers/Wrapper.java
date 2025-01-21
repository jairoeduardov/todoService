package puntoxpress.com.todoservice.model.services.wrappers;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import puntoxpress.com.todoservice.model.dto.*;
import puntoxpress.com.todoservice.model.entities.AbstractEntity;

@Data
@NoArgsConstructor
@SuperBuilder
public class Wrapper<T extends AbstractEntity, D extends Identifiable> {
    private RequestDto<D> request;
    private ResponseDto<D> response;
    private T entity;
    private D dto;
    private ResponseListDto<D> responseList;
    private String uuid;
}
