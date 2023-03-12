package com.example.demo.service.user;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserDTOMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserDTOMapper userDTOMapper;

    @Autowired
    public UserServiceImpl(UserDTOMapper userDTOMapper, UserDao userDao) {
        this.userDao = userDao;
        this.userDTOMapper = userDTOMapper;
    }


    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public UserDTO getUserDTO(int id) {return userDao.getUserDTO(id);}

    @Transactional
    @Override
    public void delete(int id) {userDao.delete(id);}

    @Transactional
    @Override
    public List<UserDTO> getAllUsers() {return userDao.getUsersDTO();}
}
