package org.javaboy.ds.service.impl;

import org.javaboy.ds.entity.User;
import org.javaboy.ds.mapper.UserMapper;
import org.javaboy.ds.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author xyma
 * @since 2023-06-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
