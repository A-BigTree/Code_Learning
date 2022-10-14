package com.seu.learn.project.teamwork.view;

import com.seu.learn.project.teamwork.domain.Employee;
import com.seu.learn.project.teamwork.domain.Programmer;
import com.seu.learn.project.teamwork.service.NameListService;
import com.seu.learn.project.teamwork.service.TeamException;
import com.seu.learn.project.teamwork.service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }

    public void enterMainMenu() {
        boolean loopFlag = true;
        char menu = 0;
        while (loopFlag) {
            if (menu != '1') {
                listAllEmployees();
            }
            System.out.print("1- 团队列表 2- 添加团队成员 3- 删除 团队成员 4- 退出 请选择（1-4）：");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println(" 请确认是否退出('Y' 或'N')：");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    /**
     * 显示所有的员工信息
     */
    private void listAllEmployees() {
        System.out.println("------------------------------------ 开发团 队调度软件------------------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println(" 公司中没有任何员工信息");
        } else {
            System.out.println("ID\t 姓名\t 年龄\t 工资\t 职位\t 状 态\t 奖金\t 股票\t 领用设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.print("----------------------------------------------------------------------------------\n");
    }

    /**
     * 显示团员列表
     */
    private void getTeam() {
        System.out.println("---------------------- 团队成员列表----------------------");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println(" 没有团队开发成员");
        } else {
            System.out.println("TID/ID\t 姓名\t 年龄\t 工资\t 职位\t 状态\t 奖金\t 股票\n");
            for (int i = 0; i < teamSvc.getTotal(); i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    /**
     * 添加成员
     */
    private void addMember() {
        System.out.println("---------------------- 添加成员----------------------");
        System.out.println(" 请输入添加员工的ID：");
        int id = TSUtility.readInt();
        try {
            Employee emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println(" 添加成功");
        } catch (TeamException e) {
            System.out.println(" 添加失败，原因：" + e.getMessage());
        }
        // 按回车键继续
        TSUtility.readReturn();
    }

    /**
     * 删除成员
     */
    private void deleteMember() {
        System.out.println("---------------------- 删除成员----------------------");
        System.out.println(" 请输入要删除员工的TID:");
        int memberId = TSUtility.readInt();
        System.out.println(" 确认是否删除(Y/N):");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N') {
            return;
        }
        try {
            teamSvc.removeMember(memberId);
            System.out.println(" 删除成功");
        } catch (TeamException e) {
            System.out.println(" 删除失败，原因" + e.getMessage());
        }
        // 按回车键继续
        TSUtility.readReturn();
    }
}
