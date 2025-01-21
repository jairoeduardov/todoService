package puntoxpress.com.todoservice.model.services.chains.factories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.UserDto;
import puntoxpress.com.todoservice.model.entities.User;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.chains.Factory;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
@Getter
@Component
@RequiredArgsConstructor
public class UserChainFactory implements Factory<Strategy<User, UserDto>[], MethodType> {
    @Override
    public Strategy<User, UserDto>[] get(MethodType methodType) {
        return new Strategy[0];
    }
}
