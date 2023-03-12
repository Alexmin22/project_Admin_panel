package com.example.demo.dao;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserDTOMapper;
import com.example.demo.exception.NoSuchEmplExcep;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDao {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    public UserDao(UserRepository userRepository, UserDTOMapper userDTOMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
    }

    public List<UserDTO> getUsersDTO() {
        List<User> list = userRepository.findAll();

        return list.stream()
                .map(user -> new UserDTO(
                        user.getUsername(),
                        user.getAge()))
                .collect(Collectors.toList());
    }

    public UserDTO getUserDTO(Integer id) {
        Optional<User> optUser = userRepository.findById(id);
        User user = optUser.orElseThrow(() ->
                new NoSuchEmplExcep("Работника с id [%s] не обнаружено в БД".formatted(id)));

        return userDTOMapper.map(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}
