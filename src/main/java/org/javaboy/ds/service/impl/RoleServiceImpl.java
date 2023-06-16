package org.javaboy.ds.service.impl;

import org.javaboy.ds.entity.Role;
import org.javaboy.ds.mapper.RoleMapper;
import org.javaboy.ds.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
