package puntoxpress.com.todoservice.model.services.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import puntoxpress.com.todoservice.model.dto.RequestDto;
import puntoxpress.com.todoservice.model.dto.ResponseDto;
import puntoxpress.com.todoservice.model.dto.TagDto;
import puntoxpress.com.todoservice.model.entities.Tag;
import puntoxpress.com.todoservice.model.enums.MethodType;
import puntoxpress.com.todoservice.model.services.TagService;
import puntoxpress.com.todoservice.model.services.chains.factories.TagChainFactory;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagChainFactory chainFactory;

    @Override
    public ResponseDto<TagDto> add(RequestDto<TagDto> request) throws Exception {
        log.info("Creating category: {}", request);
        Wrapper<Tag, TagDto> wrapper = createWrapper();
        wrapper.setRequest(request);
        for(Strategy<Tag, TagDto> strategy : this.chainFactory.get(MethodType.CREATE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<TagDto> get(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<Tag, TagDto> wrapper = createWrapper();
        wrapper.setUuid(uuid);
        for(Strategy<Tag, TagDto> strategy : this.chainFactory.get(MethodType.RETRIEVE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<TagDto> getAll() throws Exception {
        //log.info("Creating category: {}", uuid);
        Wrapper<Tag, TagDto> wrapper = createWrapper();
        //wrapper.setUuid(uuid);
        for(Strategy<Tag, TagDto> strategy : this.chainFactory.get(MethodType.ALL)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<TagDto> update(RequestDto<TagDto> request, String uuid) throws Exception {
        log.info("Creating category: {}", request);
        Wrapper<Tag, TagDto> wrapper = createWrapper();
        wrapper.setRequest(request);
        for(Strategy<Tag, TagDto> strategy : this.chainFactory.get(MethodType.UPDATE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    @Override
    public ResponseDto<TagDto> remove(String uuid) throws Exception {
        log.info("Creating category: {}", uuid);
        Wrapper<Tag, TagDto> wrapper = createWrapper();
        wrapper.setUuid(uuid);
        for(Strategy<Tag, TagDto> strategy : this.chainFactory.get(MethodType.DELETE)){
            strategy.perform(wrapper);
        }
        return wrapper.getResponse();
    }

    private Wrapper<Tag, TagDto> createWrapper(){
        return new Wrapper<Tag, TagDto>();
    }
}
