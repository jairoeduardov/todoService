package puntoxpress.com.todoservice.model.services.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import puntoxpress.com.todoservice.model.dto.*;
import puntoxpress.com.todoservice.model.entities.Task;
import puntoxpress.com.todoservice.model.entities.TaskList;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.TaskListService;
import puntoxpress.com.todoservice.model.services.chains.factories.TaskChainFactory;
import puntoxpress.com.todoservice.model.services.chains.factories.TaskListChainFactory;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskListServiceImpl implements TaskListService {

    private final TaskListChainFactory chainFactory;
    private final TaskChainFactory taskChainFactory;

    @Override
    public ResponseDto<TaskListDto> add(RequestDto<TaskListDto> request) throws Exception {
        log.info("Creating category: {}", request);
        Wrapper<TaskList, TaskListDto> wrapper = createWrapper();
        wrapper.setRequest(request);
        for(Strategy<TaskList, TaskListDto> strategy : this.chainFactory.get(MethodType.CREATE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<TaskListDto> get(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<TaskList, TaskListDto> wrapper = createWrapper();
        wrapper.setUuid(uuid);
        for(Strategy<TaskList, TaskListDto> strategy : this.chainFactory.get(MethodType.RETRIEVE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseListDto<TaskDto> getTaskByTaskListUuid(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<Task, TaskDto> wrapper = new Wrapper<>();
        wrapper.setUuid(uuid);
        for(Strategy<Task, TaskDto> strategy : this.taskChainFactory.get(MethodType.RETRIEVE_CHILDRENS)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponseList();
    }

    @Override
    public ResponseListDto<TaskListDto> getAll() throws Exception {
        //log.info("Creating category: {}", uuid);
        Wrapper<TaskList, TaskListDto> wrapper = createWrapper();
        //wrapper.setUuid(uuid);
        for(Strategy<TaskList, TaskListDto> strategy : this.chainFactory.get(MethodType.ALL)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponseList();
    }

    @Override
    public ResponseDto<TaskListDto> update(RequestDto<TaskListDto> request, String uuid) throws Exception {
        log.info("Creating category: {}", request);
        Wrapper<TaskList, TaskListDto> wrapper = createWrapper();
        wrapper.setRequest(request);
        for(Strategy<TaskList, TaskListDto> strategy : this.chainFactory.get(MethodType.UPDATE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<TaskListDto> remove(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<TaskList, TaskListDto> wrapper = createWrapper();
        wrapper.setUuid(uuid);
        for(Strategy<TaskList, TaskListDto> strategy : this.chainFactory.get(MethodType.DELETE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    private Wrapper<TaskList, TaskListDto> createWrapper(){
        return new Wrapper<TaskList, TaskListDto>();
    }
}
