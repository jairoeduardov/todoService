package puntoxpress.com.todoservice.model.services.chains.factories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TagDto;
import puntoxpress.com.todoservice.model.entities.Tag;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.chains.Factory;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;

@Getter
@Component
@RequiredArgsConstructor
public class TagChainFactory implements Factory<Strategy<Tag, TagDto>[], MethodType> {
    @Override
    public Strategy<Tag, TagDto>[] get(MethodType methodType) {
        return new Strategy[0];
    }
}
