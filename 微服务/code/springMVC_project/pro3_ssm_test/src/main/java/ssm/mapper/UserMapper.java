/**
 * ==================================================
 * Project: springMVC_project
 * Package: ssm.mapper
 * =====================================================
 * Title: UserMapper.java
 * Created: [2023/4/8 19:32] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/8, created by Shuxin-Wang.
 * 2.
 */


package ssm.mapper;

import ssm.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
