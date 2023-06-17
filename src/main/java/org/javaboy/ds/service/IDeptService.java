package org.javaboy.ds.service;

import org.javaboy.ds.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author xyma
 * @since 2023-06-16
 */
public interface IDeptService extends IService<Dept> {

    List<Dept> getAllDepts(Dept dept);
}
