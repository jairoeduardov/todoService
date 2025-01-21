package puntoxpress.com.todoservice.model.services.chains.factories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskTagDto;
import puntoxpress.com.todoservice.model.entities.TaskTag;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.chains.Factory;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;

@Getter
@Component
@RequiredArgsConstructor
public class TaskTagChainFactory implements Factory<Strategy<TaskTag, TaskTagDto>[], MethodType> {
    @Override
    public Strategy<TaskTag, TaskTagDto>[] get(MethodType methodType) {
        return new Strategy[0];
    }
}
