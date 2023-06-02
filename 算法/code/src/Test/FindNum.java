/**
 * ==================================================
 * Project: code
 * Package: Test
 * =====================================================
 * Title: FindNum.java
 * Created: [2023/6/2 12:49] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/6/2, created by Shuxin-Wang.
 * 2.
 */

package Test;

import java.util.Scanner;

public class FindNum {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int max = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int temp = s.nextInt();
            if(temp > max){
                max = temp;
            }
            if(temp  < min){
                min = temp;
            }
        }
        // Arrays.sort(nums);
        System.out.println(max - min);
    }
}
