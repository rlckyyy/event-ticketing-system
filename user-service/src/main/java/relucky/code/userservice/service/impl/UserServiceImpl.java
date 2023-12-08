package relucky.code.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import relucky.code.userservice.document.User;
import relucky.code.userservice.dto.UserDTO;
import relucky.code.userservice.exception.EmailRegisteredYetException;
import relucky.code.userservice.exception.NotFoundException;
import relucky.code.userservice.mapper.UserMapper;
import relucky.code.userservice.repository.UserRepository;
import relucky.code.userservice.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(userMapper::toDTO).toList();
    }

    @Override
    public UserDTO getOne(String id) {
        return userMapper.toDTO(userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("User with id " + id + " not found")));
    }

    @Override
    public User save(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.email()).isPresent()){
            throw new EmailRegisteredYetException("Email: " + userDTO.email() + " already registered");
        }
        return userRepository.save(userMapper.toModel(userDTO));
    }

    @Override
    public void delete(String id) {
        if (userRepository.findById(id).isEmpty()){
            throw new NotFoundException("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }
}
