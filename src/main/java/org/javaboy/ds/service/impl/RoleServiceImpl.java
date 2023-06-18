package org.javaboy.ds.service.impl;

import org.javaboy.ds.annotation.DataScope;
import org.javaboy.ds.entity.Role;
import org.javaboy.ds.mapper.RoleMapper;
import org.javaboy.ds.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author xyma
 * @since 2023-06-16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<Role> getAllRoles(Role role) {
        return roleMapper.getAllRoles(role);
    }
}
