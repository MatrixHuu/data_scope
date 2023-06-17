package org.javaboy.ds.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.javaboy.ds.annotation.DataScope;
import org.javaboy.ds.entity.BaseEntity;
import org.javaboy.ds.entity.Role;
import org.javaboy.ds.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/18 0:22
 */
@Aspect
@Component
public class DataScopeAspect {
    public static final String DATA_SCOPE_ALL = "1";
    public static final String DATA_SCOPE_CUSTOM = "2";
    public static final String DATA_SCOPE_DEPT = "3";
    public static final String DATA_SCOPE_DEPT_AND_CHILD = "4";
    public static final String DATA_SCOPE_SELF = "5";
    public static final String DATA_SCOPE = "data_scope";

    @Before("@annotation(dataScope)")
    public void doBefore(JoinPoint jp, DataScope dataScope) {
        clearDataScope(jp);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getUserId() == 1L) {
            return;
        }
        StringBuilder sql = new StringBuilder();
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            String ds = role.getDataScope();
            if (DATA_SCOPE_ALL.equals(ds)) {
                return;
            } else if (DATA_SCOPE_CUSTOM.equals(ds)) {
                sql.append(String.format(" OR %s.dept_id in(select rd.dept_id from sys_role_dept rd where rd.role_id=%d)", dataScope.deptAlias(), role.getRoleId()));
            } else if (DATA_SCOPE_DEPT.equals(ds)) {
                sql.append(String.format(" OR %s.dept_id=%d", dataScope.deptAlias(), user.getDeptId()));
            } else if (DATA_SCOPE_DEPT_AND_CHILD.equals(ds)) {
                sql.append(String.format(" OR %s.dept_id in(select dept_id from sys_dept where dept_id=%d or find_in_set(%d,'ancestors'))", dataScope.deptAlias(), user.getDeptId(), user.getDeptId()));
            } else if (DATA_SCOPE_SELF.equals(ds)) {
                String s = dataScope.userAlias();
                if ("".equals(s)) {
                    sql.append(" OR 1=0");
                } else {
                    sql.append(String.format(" OR %s.user_id = %d", dataScope.userAlias(), user.getUserId()));
                }
            }

        }
        Object arg = jp.getArgs()[0];
        if (arg != null && arg instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) arg;
            baseEntity.getParams().put(DATA_SCOPE, " AND (" + sql.substring(4) + ")");
        }
    }

    /**
     * 防止SQL注入
     *
     * @param jp
     */
    private void clearDataScope(JoinPoint jp) {
        Object arg = jp.getArgs()[0];
        if (arg != null && arg instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) arg;
            baseEntity.getParams().put(DATA_SCOPE, "");
        }
    }

}
