package org.javaboy.ds.service.impl;

import org.javaboy.ds.annotation.DataScope;
import org.javaboy.ds.entity.Dept;
import org.javaboy.ds.mapper.DeptMapper;
import org.javaboy.ds.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    DeptMapper deptMapper;

    @Override
    @DataScope(deptAlias = "d")
    public List<Dept> getAllDepts(Dept dept) {
        return deptMapper.getAllDepts(dept);
    }
}
