package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.entities.TaskList;
import puntoxpress.com.todoservice.model.repositories.TaskListRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskListDeleteStrategy  extends AbstractStrategy<TaskList, TaskListDto> implements Strategy<TaskList, TaskListDto> {

    private final TaskListRepository repository;

    @Override
    public void perform(Wrapper<TaskList, TaskListDto> wrapper) throws Exception {
       TaskList entity = wrapper.getEntity();
       repository.delete(entity);
    }
}