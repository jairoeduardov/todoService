package puntoxpress.com.todoservice.model.services.chains.factories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TagDto;
import puntoxpress.com.todoservice.model.entities.Tag;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.chains.Factory;
import puntoxpress.com.todoservice.model.services.chains.containers.TagContainerStrategy;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;

@Getter
@Component
@RequiredArgsConstructor
public class TagChainFactory implements Factory<Strategy<Tag, TagDto>[], MethodType> {

    private final TagContainerStrategy strategies;

    @Override
    public Strategy<Tag, TagDto>[] get(MethodType methodType) {
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
