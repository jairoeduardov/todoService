package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskTagDto;
import puntoxpress.com.todoservice.model.entities.TaskTag;
import puntoxpress.com.todoservice.model.exceptions.GeneralResponseException;
import puntoxpress.com.todoservice.model.mappers.TaskTagMapper;
import puntoxpress.com.todoservice.model.repositories.TaskTagRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskTagValidateIfExistStrategy extends AbstractStrategy<TaskTag, TaskTagDto> implements Strategy<TaskTag, TaskTagDto> {

    private final TaskTagRepository repository;

    @Override
    public void perform(Wrapper<TaskTag, TaskTagDto> wrapper) throws Exception {
        String uuid;
        if (wrapper.getUuid() == null){
             throw new GeneralResponseException(
                    generalErrorResponse(
                            HttpStatus.NOT_FOUND,
                            "TaskTag Uuid is empty",
                            "TaskTag Uuid is empty"
                    )
            );
        }
        uuid = wrapper.getUuid();
        TaskTag entity = repository.findByUuid(uuid).orElseThrow(
                () -> new GeneralResponseException(
                        generalErrorResponse(
                                HttpStatus.NOT_FOUND,
                                "TaskTag entity not found",
                                "TaskTag entity not found"
                        )
                )
        );
        wrapper.setEntity(entity);
    }
}
