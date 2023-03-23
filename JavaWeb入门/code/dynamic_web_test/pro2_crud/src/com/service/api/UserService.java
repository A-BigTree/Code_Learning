/**
 * ==================================================
 * Project: dynamic_web_test
 * Package: com.service.api
 * =====================================================
 * Title: UserService.java
 * Created: [2023/3/23 16:34] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/3/23, created by Shuxin-Wang.
 * 2.
 */


package com.service.api;

import com.beans.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    void  removeUser(String userID);
}
