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

@Slf4j
@Component
@RequiredArgsConstructor
public class TagDeleteStrategy  extends AbstractStrategy<Tag, TagDto> implements Strategy<Tag, TagDto> {

    private final TagRepository repository;

    @Override
    public void perform(Wrapper<Tag, TagDto> wrapper) throws Exception {
       Tag entity = wrapper.getEntity();
       repository.delete(entity);
       //createResponse(wrapper, TagMapper.INSTANCE.tagToTagDto(entity));
    }
}