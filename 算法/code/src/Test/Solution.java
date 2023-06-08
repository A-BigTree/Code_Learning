/**
 * ==================================================
 * Project: code
 * Package: Test
 * =====================================================
 * Title: Solution.java
 * Created: [2023/6/8 17:02] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/6/8, created by Shuxin-Wang.
 * 2.
 */

package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        System.out.println(splitNums(nums));
    }

    public static List<List<Integer>> splitNums(int[]nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        sum /= 2;
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(new ArrayList<Integer>());
        resList.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        reSplit(res, nums, 0, 0, sum);
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(j < res.size() && i == res.get(j)){
                resList.get(0).add(nums[i]);
                j++;
            }else{
                resList.get(1).add(nums[i]);
            }
        }
        return resList;
    }

    public static boolean reSplit(List<Integer> res, int[]nums, int index, int cnt, int sum){
        for(int i = index; i < nums.length; i++){
            if(cnt + nums[i] > sum){
                return false;
            }
            res.add(i);
            if(cnt+nums[i] == sum){
                return true;
            }
            if(reSplit(res, nums, i + 1, cnt + nums[i], sum)){
                return true;
            }else{
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
