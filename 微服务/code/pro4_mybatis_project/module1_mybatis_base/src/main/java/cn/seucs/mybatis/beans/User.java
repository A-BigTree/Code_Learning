/**
 * ==================================================
 * Project: pro4_mybatis_project
 * Package: cn.seucs.mybatis
 * =====================================================
 * Title: User.java
 * Created: [2023/4/1 17:49] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/1, created by Shuxin-Wang.
 * 2.
 */

package cn.seucs.mybatis.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String userName;
    private double salary;
}
