/**
 * ==================================================
 * Project: pro3_mybatis_log
 * Package: org.example
 * =====================================================
 * Title: Employee.java
 * Created: [2023/4/1 15:40] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/1, created by Shuxin-Wang.
 * 2.
 */

package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;
}
