package puntoxpress.com.todoservice.model.services.chains.factories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.entities.TaskList;
import puntoxpress.com.todoservice.model.entities.TaskList;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.chains.Factory;
import puntoxpress.com.todoservice.model.services.chains.containers.TaskListContainerStrategy;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
@Getter
@Component
@RequiredArgsConstructor
public class TaskListChainFactory implements Factory<Strategy<TaskList, TaskListDto>[], MethodType> {

    private final TaskListContainerStrategy strategies;

    @Override
    public Strategy<TaskList, TaskListDto>[] get(MethodType methodType) {
        return switch (methodType){
            case CREATE -> new Strategy[]{
                    this.strategies.getCreate()
            };
            case ALL -> new Strategy[]{
                    this.strategies.getRetrieveAll()
            };
            case RETRIEVE -> new Strategy[]{
                    this.strategies.getValidateIfExist(),
                    this.strategies.getRetrieve()
            };
            case DELETE -> new Strategy[]{
                    this.strategies.getDelete()
            };
            case UPDATE -> new Strategy[]{
                    this.strategies.getValidateIfExist(),
                    this.strategies.getUpdate()
            };
            default -> new Strategy[]{};
        };
    }
}
