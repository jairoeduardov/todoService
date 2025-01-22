package puntoxpress.com.todoservice.model.services.chains.factories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskDto;
import puntoxpress.com.todoservice.model.dto.TaskDto;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.chains.Factory;
import puntoxpress.com.todoservice.model.services.chains.containers.TaskContainerStrategy;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;

@Getter
@Component
@RequiredArgsConstructor
public class TaskChainFactory implements Factory<Strategy<Task, TaskDto>[], MethodType> {

    private final TaskContainerStrategy strategies;

    @Override
    public Strategy<Task, TaskDto>[] get(MethodType methodType) {
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
                    this.strategies.getValidateIfExist(),
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
