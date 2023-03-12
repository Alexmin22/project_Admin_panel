package com.example.demo.service.user;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    public void save(User user);
    public UserDTO getUserDTO(int id);
    public void delete(int id);
    public List<UserDTO> getAllUsers();
}
