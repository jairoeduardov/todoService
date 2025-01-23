package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TaskTagDto;
import puntoxpress.com.todoservice.model.entities.TaskTag;
import puntoxpress.com.todoservice.model.mappers.TaskTagMapper;
import puntoxpress.com.todoservice.model.repositories.TaskTagRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskTagRetrieveAllStrategy extends AbstractStrategy<TaskTag, TaskTagDto> implements Strategy<TaskTag, TaskTagDto> {

    private final TaskTagRepository repository;

    @Override
    public void perform(Wrapper<TaskTag, TaskTagDto> wrapper) throws Exception {
        List<TaskTag> entities = repository.findAll();
        checkEntitiesNotEmpty(entities, wrapper, "No entities found");
        wrapper.setResponseList(createResponseList(wrapper, TaskTagMapper.INSTANCE.taskTagsToTaskTagDtos(entities)));
    }
}
