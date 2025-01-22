package puntoxpress.com.todoservice.model.services.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import puntoxpress.com.todoservice.model.dto.RequestDto;
import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.ResponseListDto;
import puntoxpress.com.todoservice.model.dto.TaskDto;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.TaskService;
import puntoxpress.com.todoservice.model.services.chains.factories.TaskChainFactory;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskChainFactory chainFactory;

    @Override
    public ResponseDto<TaskDto> add(RequestDto<TaskDto> request) throws Exception {
        log.info("Creating category: {}", request);
        Wrapper<Task, TaskDto> wrapper = createWrapper();
        wrapper.setRequest(request);
        for(Strategy<Task, TaskDto> strategy : this.chainFactory.get(MethodType.CREATE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<TaskDto> get(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<Task, TaskDto> wrapper = createWrapper();
        wrapper.setUuid(uuid);
        for(Strategy<Task, TaskDto> strategy : this.chainFactory.get(MethodType.RETRIEVE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseListDto<TaskDto> getAll() throws Exception {
        //log.info("Creating category: {}", uuid);
        Wrapper<Task, TaskDto> wrapper = createWrapper();
        //wrapper.setUuid(uuid);
        for(Strategy<Task, TaskDto> strategy : this.chainFactory.get(MethodType.ALL)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponseList();
    }

    @Override
    public ResponseDto<TaskDto> update(RequestDto<TaskDto> request, String uuid) throws Exception {
        log.info("Creating category: {}", request);
        Wrapper<Task, TaskDto> wrapper = createWrapper();
        wrapper.setRequest(request);
        for(Strategy<Task, TaskDto> strategy : this.chainFactory.get(MethodType.UPDATE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<TaskDto> remove(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<Task, TaskDto> wrapper = createWrapper();
        wrapper.setUuid(uuid);
        for(Strategy<Task, TaskDto> strategy : this.chainFactory.get(MethodType.DELETE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    private Wrapper<Task, TaskDto> createWrapper(){
        return new Wrapper<Task, TaskDto>();
    }
}
