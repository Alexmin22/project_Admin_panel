package com.example.demo.util;

import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterByRoles {
    private final ModelMapper modelMapper;

    @Autowired
    public ConverterByRoles(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Role convertToRole(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, Role.class);
    }

    public RoleDTO convertToRoleDTO(Role role) {
        return modelMapper.map(role, RoleDTO.class);
    }
}
