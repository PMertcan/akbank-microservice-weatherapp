package com.akbank.roleservice.servicelayer.impl;

import com.akbank.roleservice.dao.IRoleRepository;
import com.akbank.roleservice.dto.request.RoleCreateRequest;
import com.akbank.roleservice.dto.response.RoleResponse;
import com.akbank.roleservice.entity.Role;
import com.akbank.roleservice.mapper.RoleMapper;
import com.akbank.roleservice.servicelayer.service.IRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository roleRepository;

    @Override
    public List<RoleResponse> getAllRoles() {
        List<Role> roleList = roleRepository.findAll();

        List<RoleResponse> roleResponses = RoleMapper.MAP.entityListToDtoList(roleList);

        boolean isRoleListNotEmpty = !roleResponses.isEmpty();

        if (isRoleListNotEmpty) return roleResponses;
        else throw new RuntimeException("Hata");
    }

    @Override
    public RoleResponse getRoleByUsername(String username) {
        Optional<Role> role = roleRepository.findByUsername(username);

        if (role.isPresent()) {
            log.info("Received the Role with username : {} ", username);
            return RoleMapper.MAP.entityToDto(role.get());
        } else throw new RuntimeException("Hata");

    }

    @Override
    public RoleResponse saveRole(RoleCreateRequest roleCreateRequest) {
        Role role = RoleMapper.MAP.dtoToEntity(roleCreateRequest);
        roleRepository.save(role);
        return RoleMapper.MAP.entityToDto(role);
    }
}
