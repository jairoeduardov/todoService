package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.entities.TaskList;
import puntoxpress.com.todoservice.model.exceptions.GeneralResponseException;
import puntoxpress.com.todoservice.model.repositories.TaskRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskListValidateIfHasChildStrategy  extends AbstractStrategy<TaskList, TaskListDto> implements Strategy<TaskList, TaskListDto> {

    private final TaskRepository taskRepository;

    @Override
    public void perform(Wrapper<TaskList, TaskListDto> wrapper) throws Exception {
        List<Task> tasks = taskRepository.findByTaskListUuid(wrapper.getUuid());
        if (tasks != null && !tasks.isEmpty()) {
            String taskUuids = tasks.stream()
                    .map(Task::getUuid)
                    .collect(Collectors.joining(", "));
            throw new GeneralResponseException(
                    generalErrorResponse(
                            HttpStatus.NOT_FOUND,
                            "TaskList is not empty",
                            "TaskList contains the following tasks: " + taskUuids
                    )
            );
        }

    }
}
