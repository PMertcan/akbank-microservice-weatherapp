package com.akbank.roleservice.controller;

import com.akbank.roleservice.dto.request.RoleCreateRequest;
import com.akbank.roleservice.dto.response.RoleResponse;
import com.akbank.roleservice.servicelayer.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/roles")
public class RoleController {

    private final IRoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponse> saveRole(@RequestBody RoleCreateRequest roleCreateRequest) {
        var savedRole = roleService.saveRole(roleCreateRequest);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAllRoles() {
        var roleList = roleService.getAllRoles();
        return ResponseEntity.ok(roleList);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<RoleResponse> getRole(@PathVariable String username) {
        var role = roleService.getRoleByUsername(username);
        return ResponseEntity.ok(role);
    }

}
