package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskDto;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.entities.TaskList;
import puntoxpress.com.todoservice.model.exceptions.GeneralResponseException;
import puntoxpress.com.todoservice.model.mappers.TaskMapper;
import puntoxpress.com.todoservice.model.repositories.TaskListRepository;
import puntoxpress.com.todoservice.model.repositories.TaskRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskUpdateStrategy  extends AbstractStrategy<Task, TaskDto> implements Strategy<Task, TaskDto> {

    private final TaskRepository repository;
    private final TaskMapper taskMapper;
    private final TaskListRepository taskListRepository;

    @Override
    public void perform(Wrapper<Task, TaskDto> wrapper) throws Exception {
        Task task = wrapper.getEntity();



        if (wrapper.getRequest().getData().getTaskList() == null || wrapper.getRequest().getData().getTaskList().getUuid() == null)
            throw new GeneralResponseException(
                    generalErrorResponse(
                            HttpStatus.NOT_FOUND,
                            "TaskList is empty",
                            "TaskList is empty"
                    )
            );


        TaskList taskList = taskListRepository.findByUuid(wrapper.getRequest().getData().getTaskList().getUuid()).orElseThrow(
                () -> new GeneralResponseException(
                        generalErrorResponse(
                                HttpStatus.NOT_FOUND,
                                "TaskList not found",
                                "TaskList not found"
                        )
                )
        );

        task.setTaskList(taskList);
        taskMapper.updateTaskFromDto(wrapper.getRequest().getData(), task);
        Task entity = repository.save(task);
        wrapper.setResponse(createResponse(wrapper, TaskMapper.INSTANCE.taskToTaskDto(entity)));
    }
}
