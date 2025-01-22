package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskDto;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.mappers.TaskMapper;
import puntoxpress.com.todoservice.model.repositories.TaskRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskRetrieveAllStrategy extends AbstractStrategy<Task, TaskDto> implements Strategy<Task, TaskDto> {

    private final TaskRepository repository;

    @Override
    public void perform(Wrapper<Task, TaskDto> wrapper) throws Exception {
        List<Task> entities = repository.findAll();
        checkEntitiesNotEmpty(entities, wrapper, "No price list found");
        wrapper.setResponseList(createResponseList(wrapper, TaskMapper.INSTANCE.tasksToTaskDtos(entities)));
    }
}
