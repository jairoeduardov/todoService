package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.UserDto;
import puntoxpress.com.todoservice.model.entities.User;
import puntoxpress.com.todoservice.model.mappers.UserMapper;
import puntoxpress.com.todoservice.model.repositories.UserRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserCreateStrategy extends AbstractStrategy<User, UserDto> implements Strategy<User, UserDto> {

    private final UserRepository repository;
    private final UserMapper userMapper;

    @Override
    public void perform(Wrapper<User, UserDto> wrapper) throws Exception {
        User user = userMapper.userDtoToUser(wrapper.getRequest().getData());
        User entity = repository.save(user);
        wrapper.setResponse(createResponse(wrapper, userMapper.userToUserDto(entity)));
    }
}
