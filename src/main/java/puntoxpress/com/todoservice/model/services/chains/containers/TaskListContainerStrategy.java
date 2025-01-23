package puntoxpress.com.todoservice.model.services.chains.containers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.services.strategies.impls.*;

@Getter
@Component
@RequiredArgsConstructor
public class TaskListContainerStrategy {
    private final TaskListCreateStrategy create;
    private final TaskListValidateIfExistStrategy validateIfExist;
    private final TaskListDeleteStrategy delete;
    private final TaskListUpdateStrategy update;
    private final TaskListRetrieveAllStrategy retrieveAll;
    private final TaskListRetrieveStrategy retrieve;
    private final TaskListValidateIfHasChildStrategy validateIfHasChild;

}
