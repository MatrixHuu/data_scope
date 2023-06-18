package org.javaboy.ds.service;

import org.javaboy.ds.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author xyma
 * @since 2023-06-16
 */
public interface IRoleService extends IService<Role> {

    List<Role> getAllRoles(Role role);
}
