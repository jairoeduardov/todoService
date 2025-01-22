package puntoxpress.com.todoservice.model.services.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import puntoxpress.com.todoservice.model.dto.RequestDto;
import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.ResponseListDto;
import puntoxpress.com.todoservice.model.dto.TaskTagDto;
import puntoxpress.com.todoservice.model.entities.TaskTag;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.TaskTagService;
import puntoxpress.com.todoservice.model.services.chains.factories.TaskTagChainFactory;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskTagServiceImpl implements TaskTagService {

    private final TaskTagChainFactory chainFactory;

    @Override
    public ResponseDto<TaskTagDto> add(RequestDto<TaskTagDto> request) throws Exception {
        log.info("Creating category: {}", request);
        Wrapper<TaskTag, TaskTagDto> wrapper = createWrapper();
        wrapper.setRequest(request);
        for(Strategy<TaskTag, TaskTagDto> strategy : this.chainFactory.get(MethodType.CREATE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<TaskTagDto> get(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<TaskTag, TaskTagDto> wrapper = createWrapper();
        wrapper.setUuid(uuid);
        for(Strategy<TaskTag, TaskTagDto> strategy : this.chainFactory.get(MethodType.RETRIEVE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseListDto<TaskTagDto> getAll() throws Exception {
        //log.info("Creating category: {}", uuid);
        Wrapper<TaskTag, TaskTagDto> wrapper = createWrapper();
        //wrapper.setUuid(uuid);
        for(Strategy<TaskTag, TaskTagDto> strategy : this.chainFactory.get(MethodType.ALL)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponseList();
    }

    @Override
    public ResponseDto<TaskTagDto> update(RequestDto<TaskTagDto> request, String uuid) throws Exception {
        log.info("Creating category: {}", request);
        Wrapper<TaskTag, TaskTagDto> wrapper = createWrapper();
        wrapper.setRequest(request);
        for(Strategy<TaskTag, TaskTagDto> strategy : this.chainFactory.get(MethodType.UPDATE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<TaskTagDto> remove(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<TaskTag, TaskTagDto> wrapper = createWrapper();
        wrapper.setUuid(uuid);
        for(Strategy<TaskTag, TaskTagDto> strategy : this.chainFactory.get(MethodType.DELETE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    private Wrapper<TaskTag, TaskTagDto> createWrapper(){
        return new Wrapper<TaskTag, TaskTagDto>();
    }
}
