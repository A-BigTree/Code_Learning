/**
 * ==================================================
 * Project: springMVC_project
 * Package: ssm.entity
 * =====================================================
 * Title: User.java
 * Created: [2023/4/8 19:30] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/8, created by Shuxin-Wang.
 * 2.
 */

package ssm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String userName;
    private double userSalary;
}
