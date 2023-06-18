package org.javaboy.ds.controller;

import org.javaboy.ds.entity.Role;
import org.javaboy.ds.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author xyma
 * @since 2023-06-16
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    IRoleService roleService;


    @GetMapping("/")
    public List<Role> getAllRoles(Role role) {
        return roleService.getAllRoles(role);
    }

}
