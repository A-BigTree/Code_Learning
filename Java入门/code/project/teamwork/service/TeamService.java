package com.seu.learn.project.teamwork.service;

import com.seu.learn.project.teamwork.domain.Employee;
import com.seu.learn.project.teamwork.domain.Programmer;


public class TeamService {
    private static int counter = 1;
    private static final int MAX_MEMBER = 5;
    private static final int[] MAX_TOTAL = new int[]{5, 3, 2, 1};
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total[] = new int[]{0, 0, 0, 0};

    public Programmer[] getTeam() {
        return team;
    }

    public void addMember(Employee employee) throws TeamException {
        if (total[0] == 5) {
            throw new TeamException("成员已满，无法添加.");
        } else if (employee.getId() == 10) {
            throw new TeamException("该成员不是开发人员，无法添加.");
        } else if (!(((Programmer) employee).getStatus().getNAME()).equals("FREE")) {
            throw new TeamException("该员工已在开发团队中或已是某团队成员或正在休假，无法添加.");
        } else if (total[employee.getId() % 10] == MAX_TOTAL[employee.getId() % 10]) {
            throw new TeamException("团队中最多只能有" + MAX_TOTAL[employee.getId() % 10] + "名" + employee.getWork() + ".");
        }
        ((Programmer) employee).setMemberId(counter);
        ((Programmer) employee).setStatus(Status.BUSY);
        team[total[0]] = (Programmer) employee;
        total[employee.getId() % 10]++;
        total[0]++;
        counter++;
    }

    public void removeMember(int memberId) throws TeamException {
        int index = -1;
        for (int i = 0; i < total[0]; i++) {
            if (memberId == team[i].getMemberId()) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new TeamException("找不到指定memberId = " + memberId + "的员工，删除失败.");
        }
        ((Programmer) team[index]).setStatus(Status.FREE);
        total[team[index].getId() % 10]--;
        for (int i = index; i < total[0] - 1; i++) {
            team[i] = team[i++];
        }
        team[total[0] - 1] = null;
        total[0]--;
    }

    public int getTotal(){
        return total[0];
    }
}
