package org.javaboy.ds.mapper;

import org.javaboy.ds.entity.Role;
import org.javaboy.ds.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author xyma
 * @since 2023-06-16
 */
public interface UserMapper extends BaseMapper<User> {

    List<Role> getRolesByUid(Long userId);

    List<User> getAllUsers(User user);
}
