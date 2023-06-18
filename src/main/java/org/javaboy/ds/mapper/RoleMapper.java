package org.javaboy.ds.mapper;

import org.javaboy.ds.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author xyma
 * @since 2023-06-16
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getAllRoles(Role role);
}
