package puntoxpress.com.todoservice.model.services.chains.factories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskListDto;
import puntoxpress.com.todoservice.model.entities.TaskList;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.chains.Factory;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
@Getter
@Component
@RequiredArgsConstructor
public class TaskListChainFactory implements Factory<Strategy<TaskList, TaskListDto>[], MethodType> {
    @Override
    public Strategy<TaskList, TaskListDto>[] get(MethodType methodType) {
        return new Strategy[0];
    }
}
