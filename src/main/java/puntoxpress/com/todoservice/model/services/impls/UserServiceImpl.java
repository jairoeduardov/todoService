package puntoxpress.com.todoservice.model.services.impls;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import puntoxpress.com.todoservice.model.dto.*;
import puntoxpress.com.todoservice.model.entities.User;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.mappers.UserMapper;
import puntoxpress.com.todoservice.model.services.UserService;
import puntoxpress.com.todoservice.model.services.chains.factories.UserChainFactory;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService {

    private final UserChainFactory chainFactory;

    private Wrapper<User, UserDto> createWrapper(){
        return new Wrapper<User, UserDto>();
    }

    @Override
    public ResponseDto<UserDto> add(RequestDto<UserDto> request) throws Exception {
        log.info("Creating category: {}", request);
        Wrapper<User, UserDto> wrapper = createWrapper();
        for(Strategy<User, UserDto> strategy : this.chainFactory.get(MethodType.CREATE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<UserDto> update(RequestDto<UserDto> request, String uuid) throws Exception {
        log.info("Creating category: {}", request);
        Wrapper<User, UserDto> wrapper = createWrapper();
        wrapper.setRequest(request);
        wrapper.setUuid(uuid);
        for(Strategy<User, UserDto> strategy : this.chainFactory.get(MethodType.UPDATE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<UserDto> get(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<User, UserDto> wrapper = createWrapper();
        wrapper.setUuid(uuid);
        for(Strategy<User, UserDto> strategy : this.chainFactory.get(MethodType.RETRIEVE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseListDto<UserDto> getAll() throws Exception {
        //log.info("Creating category: {}", uuid);
        Wrapper<User, UserDto> wrapper = createWrapper();
        //wrapper.setUuid(uuid);
        for(Strategy<User, UserDto> strategy : this.chainFactory.get(MethodType.ALL)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponseList();
    }

    @Override
    public ResponseDto<UserDto> remove(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<User, UserDto> wrapper = createWrapper();
        wrapper.setUuid(uuid);
        for(Strategy<User, UserDto> strategy : this.chainFactory.get(MethodType.DELETE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }
}
