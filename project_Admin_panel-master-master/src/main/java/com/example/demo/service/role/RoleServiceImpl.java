package com.example.demo.service.role;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Transactional
    @Override
    public void getRole(int id) {
        roleRepository.getReferenceById(id);
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }
}
