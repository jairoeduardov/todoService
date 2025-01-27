package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.entities.TaskList;
import puntoxpress.com.todoservice.model.mappers.TaskListMapper;
import puntoxpress.com.todoservice.model.mappers.TaskMapper;
import puntoxpress.com.todoservice.model.repositories.TaskListRepository;
import puntoxpress.com.todoservice.model.repositories.TaskRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskListRetrieveAllStrategy extends AbstractStrategy<TaskList, TaskListDto> implements Strategy<TaskList, TaskListDto> {

    private final TaskListRepository repository;
    private final TaskRepository taskRepository;
    private final TaskListMapper taskListMapper;
    private final TaskMapper taskMapper;

    @Override
    public void perform(Wrapper<TaskList, TaskListDto> wrapper) throws Exception {
        List<TaskList> entities = repository.findAll();
        checkEntitiesNotEmpty(entities, wrapper, "No entities found");
        List<TaskListDto> taskListDtos =  taskListMapper.taskListsToTaskListDtos(entities);
        taskListDtos.forEach(taskListDto -> {
            // Obtener las tareas asociadas a la lista de tareas actual
            List<Task> tasks = taskRepository.findByTaskListUuid(taskListDto.getUuid());
            // Actualizar las tareas en la lista de tareas
            taskListDto.setTasks(taskMapper.tasksToTaskDtos(tasks));
        });
        wrapper.setResponseList(createResponseList(wrapper, taskListDtos));
    }
}
