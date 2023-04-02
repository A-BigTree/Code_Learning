/**
 * ==================================================
 * Project: pro4_mybatis_project
 * Package: cn.seucs.mybatis.dao
 * =====================================================
 * Title: UserMapper.java
 * Created: [2023/4/1 18:04] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/1, created by Shuxin-Wang.
 * 2.
 */


package cn.seucs.mybatis.dao;

import cn.seucs.mybatis.beans.User;

public interface UserMapper {
    User selectUser(String userId);
}
