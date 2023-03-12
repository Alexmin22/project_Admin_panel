package com.example.demo.dto;

import com.example.demo.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter @NoArgsConstructor
public class UserDTOMapper {
    public UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setAge(user.getAge());
        return userDTO;
    }
}
