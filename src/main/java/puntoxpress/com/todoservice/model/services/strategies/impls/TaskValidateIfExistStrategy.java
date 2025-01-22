package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskDto;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.exceptions.GeneralResponseException;
import puntoxpress.com.todoservice.model.mappers.TaskMapper;
import puntoxpress.com.todoservice.model.repositories.TaskRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskValidateIfExistStrategy extends AbstractStrategy<Task, TaskDto> implements Strategy<Task, TaskDto> {

    private final TaskRepository repository;

    @Override
    public void perform(Wrapper<Task, TaskDto> wrapper) throws Exception {
        String uuid;
        if (wrapper.getUuid() == null){
             throw new GeneralResponseException(
                    generalErrorResponse(
                            HttpStatus.NOT_FOUND,
                            "Task Uuid is empty",
                            "Task Uuid is empty"
                    )
            );
        }
        uuid = wrapper.getUuid();
        Task entity = repository.findByUuid(uuid).orElseThrow(
                () -> new GeneralResponseException(
                        generalErrorResponse(
                                HttpStatus.NOT_FOUND,
                                "Task entity not found",
                                "Task entity not found"
                        )
                )
        );
        wrapper.setEntity(entity);
    }
}
