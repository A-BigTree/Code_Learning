/**
 * ==================================================
 * Project: springMVC_project
 * Package: ssm.service.impl
 * =====================================================
 * Title: UserServiceImpl.java
 * Created: [2023/4/8 21:09] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/8, created by Shuxin-Wang.
 * 2.
 */

package ssm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.entity.User;
import ssm.mapper.UserMapper;
import ssm.service.api.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userMapper.selectAll();
    }
}
