package com.seu.learn.project.teamwork.service;

import com.seu.learn.project.teamwork.domain.*;
import com.seu.learn.project.teamwork.view.Data;

public class NameListService {

    private Employee[] employees;

    /**
     *读出Data中员工数据
     */
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            int index1;
            try {
                index1 = Integer.parseInt(Data.EQUIPMENTS[i][0]);
            } catch (IndexOutOfBoundsException | NullPointerException e) {
                index1 = -1;
            }
            System.out.println(index1);
            System.out.println(Data.EMPLOYEES[i][0]);
            int index2 = Integer.parseInt(Data.EMPLOYEES[i][0]);
            Equipment equipment = null;
            employees[i] = null;
            switch (index1) {
                case Data.PC:
                    equipment = new PC(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                    break;
                case Data.NOTEBOOK:
                    equipment = new NoteBook(Data.EQUIPMENTS[i][1], Double.parseDouble(Data.EQUIPMENTS[i][2]));
                    break;
                case Data.PRINTER:
                    equipment = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                    break;
                default:
                    break;
            }
            switch (index2) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(index2, Data.EMPLOYEES[i][2],
                            Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]));
                    break;
                case Data.PROGRAMMER:
                    employees[i] = new Programmer(index2, Data.EMPLOYEES[i][2],
                            Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]),
                            equipment);
                    break;
                case Data.DESIGNER:
                    employees[i] = new Designer(index2, Data.EMPLOYEES[i][2],
                            Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]),
                            equipment, Double.parseDouble(Data.EMPLOYEES[i][5]));
                    break;
                case Data.ARCHITECT:
                    employees[i] = new Architect(index2, Data.EMPLOYEES[i][2],
                            Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]),
                            equipment, Double.parseDouble(Data.EMPLOYEES[i][5]),
                            Integer.parseInt(Data.EMPLOYEES[i][6]));
                    break;
                default:
                    break;
            }
        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 根据下标返回员工类
     * @param d 获取员工在数组中的下标
     * @return 结果员工引用
     * @throws TeamException 自定义异常类
     */
    public Employee getEmployee(int d) throws TeamException {
        if(d<1 || d>employees.length){
            throw new TeamException("下标超出范围.");
        }
        return employees[d - 1];
    }
}
