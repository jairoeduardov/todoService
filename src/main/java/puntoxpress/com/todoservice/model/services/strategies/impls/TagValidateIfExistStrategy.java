package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.TagDto;
import puntoxpress.com.todoservice.model.entities.Tag;
import puntoxpress.com.todoservice.model.exceptions.GeneralResponseException;
import puntoxpress.com.todoservice.model.mappers.TagMapper;
import puntoxpress.com.todoservice.model.repositories.TagRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class TagValidateIfExistStrategy extends AbstractStrategy<Tag, TagDto> implements Strategy<Tag, TagDto> {

    private final TagRepository repository;

    @Override
    public void perform(Wrapper<Tag, TagDto> wrapper) throws Exception {
        String uuid;
        if (wrapper.getUuid() == null){
             throw new GeneralResponseException(
                    generalErrorResponse(
                            HttpStatus.NOT_FOUND,
                            "Tag Uuid is empty",
                            "Tag Uuid is empty"
                    )
            );
        }
        uuid = wrapper.getUuid();
        Tag entity = repository.findByUuid(uuid).orElseThrow(
                () -> new GeneralResponseException(
                        generalErrorResponse(
                                HttpStatus.NOT_FOUND,
                                "Tag entity not found",
                                "Tag entity not found"
                        )
                )
        );

    }

}