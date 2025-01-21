package puntoxpress.com.todoservice.model.services.strategies.impls;

import org.springframework.http.HttpStatus;
import puntoxpress.com.todoservice.model.dto.*;
import puntoxpress.com.todoservice.model.entities.AbstractEntity;
import puntoxpress.com.todoservice.model.exceptions.GeneralResponseException;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractStrategy <T extends AbstractEntity, D extends Identifiable> {


    protected ResponseErrorDto generalErrorResponse(HttpStatus status, String title, String detail) {
        return new ResponseErrorDto(
                new Object(),
                List.of(new ErrorDto(
                        String.valueOf(status.value()),
                        UUID.randomUUID().toString(),
                        LocalDateTime.now(),
                        detail,
                        title
                ))
        );
    }


    protected ResponseDto<D> createResponse(Wrapper<T, D> wrapper, D dto) {
        ResponseDto<D> response = ResponseDto.<D>builder()
                .data(dto)
                .errors(new ArrayList<>())
                .build();
        wrapper.setResponse(response);
        return response;
    }

    protected ResponseListDto<D> createResponseList(Wrapper<T, D> wrapper, List<D> dtos) {
        return ResponseListDto.<D>builder()
                .data(dtos)
                .errors(new ArrayList<>())
                .build();
    }

    public void generateAndAssignUuid(Wrapper<T, D> wrapper) {
        String uuid = UUID.randomUUID().toString();
        wrapper.getRequest().getData().setUuid(uuid);
    }

    protected void checkEntitiesNotEmpty(List<? extends AbstractEntity> entities, Wrapper<T, D> wrapper, String notFoundMessage) throws GeneralResponseException {
        if (entities.isEmpty()) {
            throw new GeneralResponseException(
                    generalErrorResponse(
                            HttpStatus.NOT_FOUND,
                            notFoundMessage,
                            notFoundMessage
                    )
            );
        }
    }

}
