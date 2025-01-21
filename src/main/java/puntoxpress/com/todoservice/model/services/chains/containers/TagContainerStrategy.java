package puntoxpress.com.todoservice.model.services.chains.containers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.services.strategies.impls.*;

@Getter
@Component
@RequiredArgsConstructor
public class TagContainerStrategy {
    private final TagCreateStrategy create;
    private final TagValidateIfExistStrategy validateIfExist;
    private final TagDeleteStrategy delete;
    private final TagUpdateStrategy update;
    private final TagRetrieveAllStrategy retrieveAll;
    private final TagRetrieveStrategy retrieve;

}
