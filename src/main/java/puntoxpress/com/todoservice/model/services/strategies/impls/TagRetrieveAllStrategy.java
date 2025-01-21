package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TagDto;
import puntoxpress.com.todoservice.model.entities.Tag;
import puntoxpress.com.todoservice.model.mappers.TagMapper;
import puntoxpress.com.todoservice.model.repositories.TagRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TagRetrieveAllStrategy extends AbstractStrategy<Tag, TagDto> implements Strategy<Tag, TagDto> {

    private final TagRepository repository;

    @Override
    public void perform(Wrapper<Tag, TagDto> wrapper) throws Exception {
        List<Tag> entities = repository.findAll();
        checkEntitiesNotEmpty(entities, wrapper, "No price list found");
        wrapper.setResponseList(createResponseList(wrapper, TagMapper.INSTANCE.tagsToTagDtos(entities)));
    }
}
