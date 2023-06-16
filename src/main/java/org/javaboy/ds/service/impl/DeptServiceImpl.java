package org.javaboy.ds.service.impl;

import org.javaboy.ds.entity.Dept;
import org.javaboy.ds.mapper.DeptMapper;
import org.javaboy.ds.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author xyma
 * @since 2023-06-16
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
