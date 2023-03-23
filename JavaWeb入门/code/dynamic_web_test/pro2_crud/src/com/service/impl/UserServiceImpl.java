/**
 * ==================================================
 * Project: dynamic_web_test
 * Package: com.service.impl
 * =====================================================
 * Title: UserServiceImpl.java
 * Created: [2023/3/23 16:35] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/3/23, created by Shuxin-Wang.
 * 2.
 */

package com.service.impl;

import com.beans.User;
import com.dao.impl.UserDaoImpl;
import com.service.api.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl userImpl = new UserDaoImpl();
    @Override
    public List<User> getUserList() {
        return userImpl.getAllUsers();
    }

    @Override
    public void removeUser(String userID) {
        userImpl.deleteUserById(userID);
    }
}
