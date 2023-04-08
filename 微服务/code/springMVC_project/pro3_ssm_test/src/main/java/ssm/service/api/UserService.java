/**
 * ==================================================
 * Project: springMVC_project
 * Package: ssm.service.api
 * =====================================================
 * Title: UserService.java
 * Created: [2023/4/8 21:08] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/8, created by Shuxin-Wang.
 * 2.
 */


package ssm.service.api;

import ssm.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
}
