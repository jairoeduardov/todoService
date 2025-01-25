package puntoxpress.com.todoservice.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import puntoxpress.com.todoservice.model.dto.UserBaseDto;
import puntoxpress.com.todoservice.model.dto.UserDto;
import puntoxpress.com.todoservice.model.entities.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    User UserBaseDtoToUser(UserBaseDto userBaseDto);
    void updateUserFromDto(UserDto dto, @MappingTarget User entity);
    List<UserDto> usersToUserDtos(List<User> users);
    UserDto userBaseDtoToUserDto(UserBaseDto userBaseDto);
    void updateUserFromBaseDto(UserBaseDto userBaseDto, @MappingTarget User user);


}
