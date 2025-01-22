package puntoxpress.com.todoservice.model.services.chains.containers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.services.strategies.impls.*;

@Getter
@Component
@RequiredArgsConstructor
public class TaskContainerStrategy {
    private final TaskCreateStrategy create;
    private final TaskValidateIfExistStrategy validateIfExist;
    private final TaskDeleteStrategy delete;
    private final TaskUpdateStrategy update;
    private final TaskRetrieveAllStrategy retrieveAll;
    private final TaskRetrieveStrategy retrieve;
}
