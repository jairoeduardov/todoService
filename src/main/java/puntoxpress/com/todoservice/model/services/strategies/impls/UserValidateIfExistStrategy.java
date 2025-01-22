package puntoxpress.com.todoservice.model.services.strategies.impls;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import puntoxpress.com.todoservice.model.dto.UserDto;
import puntoxpress.com.todoservice.model.entities.User;
import puntoxpress.com.todoservice.model.exceptions.GeneralResponseException;
import puntoxpress.com.todoservice.model.mappers.UserMapper;
import puntoxpress.com.todoservice.model.repositories.UserRepository;
import puntoxpress.com.todoservice.model.services.strategies.Strategy;
import puntoxpress.com.todoservice.model.services.wrappers.Wrapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserValidateIfExistStrategy extends AbstractStrategy<User, UserDto> implements Strategy<User, UserDto> {

    private final UserRepository repository;

    @Override
    public void perform(Wrapper<User, UserDto> wrapper) throws Exception {
        String uuid;
        if (wrapper.getUuid() == null){
             throw new GeneralResponseException(
                    generalErrorResponse(
                            HttpStatus.NOT_FOUND,
                            "User Uuid is empty",
                            "User Uuid is empty"
                    )
            );
        }
        uuid = wrapper.getUuid();
        User entity = repository.findByUuid(uuid).orElseThrow(
                () -> new GeneralResponseException(
                        generalErrorResponse(
                                HttpStatus.NOT_FOUND,
                                "User entity not found",
                                "User entity not found"
                        )
                )
        );
    }
}
