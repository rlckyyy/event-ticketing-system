package relucky.code.userservice.service;

import relucky.code.userservice.entity.User;
import relucky.code.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();

    UserDTO getOne(String id);

    User save(UserDTO userDTO);

    void delete(String id);
}
