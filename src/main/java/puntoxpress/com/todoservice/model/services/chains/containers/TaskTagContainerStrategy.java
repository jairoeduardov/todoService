package puntoxpress.com.todoservice.model.services.chains.containers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.services.strategies.impls.*;

@Getter
@Component
@RequiredArgsConstructor
public class TaskTagContainerStrategy {
    private final TaskTagCreateStrategy create;
    private final TaskTagValidateIfExistStrategy validateIfExist;
    private final TaskTagDeleteStrategy delete;
    private final TaskTagUpdateStrategy update;
    private final TaskTagRetrieveAllStrategy retrieveAll;
    private final TaskTagRetrieveStrategy retrieve;

}
