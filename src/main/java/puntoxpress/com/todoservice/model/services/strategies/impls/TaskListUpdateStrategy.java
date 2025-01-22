package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.entities.TaskList;
import puntoxpress.com.todoservice.model.mappers.TaskListMapper;
import puntoxpress.com.todoservice.model.repositories.TaskListRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskListUpdateStrategy  extends AbstractStrategy<TaskList, TaskListDto> implements Strategy<TaskList, TaskListDto> {

    private final TaskListRepository repository;

    @Override
    public void perform(Wrapper<TaskList, TaskListDto> wrapper) throws Exception {
        TaskListMapper.INSTANCE.updateTaskListFromDto(wrapper.getRequest().getData(), wrapper.getEntity());
        TaskList entity = repository.save(wrapper.getEntity());
        wrapper.setResponse(createResponse(wrapper, TaskListMapper.INSTANCE.taskListToTaskListDto(entity)));
    }
}
