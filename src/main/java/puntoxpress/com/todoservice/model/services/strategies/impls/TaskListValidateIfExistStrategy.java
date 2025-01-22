package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.entities.TaskList;
import puntoxpress.com.todoservice.model.exceptions.GeneralResponseException;
import puntoxpress.com.todoservice.model.mappers.TaskListMapper;
import puntoxpress.com.todoservice.model.repositories.TaskListRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskListValidateIfExistStrategy extends AbstractStrategy<TaskList, TaskListDto> implements Strategy<TaskList, TaskListDto> {

    private final TaskListRepository repository;

    @Override
    public void perform(Wrapper<TaskList, TaskListDto> wrapper) throws Exception {
        String uuid;
        if (wrapper.getUuid() == null){
             throw new GeneralResponseException(
                    generalErrorResponse(
                            HttpStatus.NOT_FOUND,
                            "TaskList Uuid is empty",
                            "TaskList Uuid is empty"
                    )
            );
        }
        uuid = wrapper.getUuid();
        TaskList entity = repository.findByUuid(uuid).orElseThrow(
                () -> new GeneralResponseException(
                        generalErrorResponse(
                                HttpStatus.NOT_FOUND,
                                "TaskList entity not found",
                                "TaskList entity not found"
                        )
                )
        );
        wrapper.setEntity(entity);
    }
}
