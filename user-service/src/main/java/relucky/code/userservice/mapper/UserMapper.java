package relucky.code.userservice.mapper;

import org.mapstruct.Mapper;
import relucky.code.userservice.document.User;
import relucky.code.userservice.dto.UserDTO;

@Mapper
public interface UserMapper {
    UserDTO toDTO(User user);
    User toModel(UserDTO userDTO);
}
