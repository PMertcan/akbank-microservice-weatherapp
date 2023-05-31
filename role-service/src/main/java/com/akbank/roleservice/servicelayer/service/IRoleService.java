package com.akbank.roleservice.servicelayer.service;

import com.akbank.roleservice.dto.request.RoleCreateRequest;
import com.akbank.roleservice.dto.response.RoleResponse;
import java.util.List;

public interface IRoleService {

    List<RoleResponse> getAllRoles();

    RoleResponse getRoleByUsername(String username);

    RoleResponse saveRole(RoleCreateRequest roleCreateRequest);

}
