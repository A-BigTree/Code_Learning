/**
 * ==================================================
 * Project: code
 * Package: LeetCode
 * =====================================================
 * Title: Main46.java
 * Created: [2023/6/5 22:25] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/6/5, created by Shuxin-Wang.
 * 2.
 */

package LeetCode;

import java.util.*;

public class Main46 {

    public static void main(String[]args){
        System.out.println(new String(new char[]{'a','b'}, 0, 1));
        new StringTokenizer("abc", ":");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[]nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }

        List<List<Integer>> resList = new ArrayList<>();
        reBuild(resList, new LinkedHashSet<Integer>(), 0, nums.length, nums);
        System.out.println(resList);
    }

    public static void reBuild(List<List<Integer>> resList, LinkedHashSet<Integer> temp, int index, int n, int[] nums){
        if(index == n){
            resList.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < n; i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            System.out.println(index);
            System.out.println(temp);
            reBuild(resList, new LinkedHashSet<Integer>(temp), index + 1, n, nums);
            temp.remove(nums[i]);
        }
    }
}

class A{
    public A(){
        System.out.println("A");
    }
}

class B extends A{
    public B(){
        System.out.println("B");
    }
}
