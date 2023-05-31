package com.akbank.roleservice.mapper;

import com.akbank.roleservice.dto.request.RoleCreateRequest;
import com.akbank.roleservice.dto.response.RoleResponse;
import com.akbank.roleservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel="spring")
public interface RoleMapper {

    RoleMapper MAP = Mappers.getMapper(RoleMapper.class);

    RoleResponse entityToDto(Role role);

    Role dtoToEntity(RoleCreateRequest roleCreateRequest);

    List<RoleResponse> entityListToDtoList(List<Role> roleList);

}
