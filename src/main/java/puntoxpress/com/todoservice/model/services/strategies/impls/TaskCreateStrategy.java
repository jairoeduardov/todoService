package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskDto;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.entities.User;
import puntoxpress.com.todoservice.model.exceptions.GeneralResponseException;
import puntoxpress.com.todoservice.model.mappers.TaskMapper;
import puntoxpress.com.todoservice.model.mappers.UserMapper;
import puntoxpress.com.todoservice.model.repositories.TaskRepository;
import puntoxpress.com.todoservice.model.repositories.UserRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskCreateStrategy extends AbstractStrategy<Task, TaskDto> implements Strategy<Task, TaskDto> {

    private final TaskRepository repository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;

    @Override
    public void perform(Wrapper<Task, TaskDto> wrapper) throws Exception {
        if (wrapper.getRequest().getData().getUser() == null || wrapper.getRequest().getData().getUser().getUuid() == null)
            throw new GeneralResponseException(
                    generalErrorResponse(
                            HttpStatus.NOT_FOUND,
                            "User is empty",
                            "User is empty"
                    )
            );

        User user = userRepository.findByUuid(wrapper.getRequest().getData().getUser().getUuid()).orElseThrow(
                () -> new GeneralResponseException(
                        generalErrorResponse(
                                HttpStatus.NOT_FOUND,
                                "User not found",
                                "User not found"
                        )
                )
        );
        Task task = taskMapper.taskDtoToTask(wrapper.getRequest().getData());
        task.setUser(user);
        Task entityUpdated = repository.save(task);
        wrapper.setResponse(createResponse(wrapper, taskMapper.taskToTaskDto(entityUpdated)));
    }
}
