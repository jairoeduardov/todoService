package puntoxpress.com.todoservice.model.services.chains.containers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.services.strategies.impls.*;

@Getter
@Component
@RequiredArgsConstructor
public class UserContainerStrategy  {
    private final UserCreateStrategy create;
    private final UserValidateIfExistStrategy validateIfExist;
    private final UserDeleteStrategy delete;
    private final UserUpdateStrategy update;
    private final UserRetrieveAllStrategy retrieveAll;
    private final UserRetrieveStrategy retrieve;

}
