/**
 * ==================================================
 * Project: code
 * Package: Test
 * =====================================================
 * Title: Main.java
 * Created: [2023/6/2 13:06] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/6/2, created by Shuxin-Wang.
 * 2.
 */

package Test;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){

        Scanner input = new Scanner(System.in);
        /*
        int n = input.nextInt();
        int []cap = new int[n];
        int []water = new int[n];
        int []need = new int[n];
        int []remained = new int[n];
        for(int i = 0; i < n; i++){
            cap[i] = input.nextInt();
        }
        for(int i = 0; i < n; i++){
            water[i] = input.nextInt();
            remained[i] = cap[i] - water[i];
        }
        for(int i = 0; i < n; i++){
            need[i] = input.nextInt();
        }
        int m = input.nextInt();
        for(int i = 0; i < m; i++){
            int index = input.nextInt() - 1;
            if(remained[index] == 0){
                System.out.println(0);
                continue;
            }
            int min = remained[index] * need[index];
            int last = remained[index];
            for(int j = index - 1; j >= 0; j--){
                last += remained[j];
                min = Math.min(min, last * remained[j]);
            }
            System.out.println(min);
        }*/

        /*
        String str = input.nextLine();
        int change = 0;
        int n = str.length();
        int left = 0, right = n - 1;
        char[]chars = new char[n];
        for(int i = 0; i < n; i++){
            chars[i] = str.charAt(i);
        }
        while(left < right){
            char l = str.charAt(left), r = str.charAt(right);
            if(l!=r){
                int index = right;
                char ch = l;
                if(r < l){
                    ch = r;
                    index = left;
                    //System.out.println(String.valueOf(index) + ch);
                }
                chars[index] = ch;
                change++;
                //System.out.println(new String(chars));
            }
            left++;
            right--;
        }
        if(change==2 ||(change==1 && n % 2 == 0)){
            System.out.println(new String(chars));
        }else if(change == 1){
            chars[n/2] = 'a';
            System.out.println(new String(chars));
        }else{
            int temp = 0;
            char minChar = chars[0];
            for(int i = 1; i < n/2; i++){
                if(chars[i] > minChar){
                    temp = i;
                    minChar = chars[i];
                }
            }
            if(n%2==0){
                chars[temp] =  'a';
                chars[n - temp - 1] =  'a';
                System.out.println(new String(chars));
            }else{
                if((minChar - 'a') * 2 > chars[n/2] - 'a'){
                    chars[temp] =  'a';
                    chars[n - temp - 1] =  'a';
                    System.out.println(new String(chars));
                }else{
                    chars[n/2] = 'a';
                    System.out.println(new String(chars));
                }
            }
        }*/

        /*
        int n = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        int []price = new int[n];
        int []minus = new int[n];
        for(int i = 0; i < n; i++){
            price[i] = input.nextInt();
            minus[i] = input.nextInt();
        }
        System.out.println(String.valueOf(8) + " " + 24);*/

        int n = input.nextInt();
        int[]p = new int[n + 1];
        int[]c = new int[n + 1];
        int[]value = new int[n + 1];
        int max =Integer.MIN_VALUE;
        for(int i = 2; i <= n; i++){
            p[i] = input.nextInt();
            if(p[i] > max){
                max = p[i];
            }
        }
        for(int i = 1; i <= n; i++){
            c[i] = input.nextInt();
            value[i] = i;
        }
        for(int i = max; i >= 1; i--){
            int i1 = -1, i2 = -1;
            for(int j = 1; j < n + 1; j++){
                if((i1==-1 || i2 == -1) && p[j]==max){
                    if(i1 == -1){
                        i1 = j;
                    }else{
                        i2 = j;
                    }
                }
            }
            if(i1 != -1 || i2 != -1){
                if(c[max]==1){
                    value[max] = value[i1] + value[i2];
                }else{
                    value[max] = value[i1] ^ value[i2];
                }
            }else{
                value[max] = 1;
            }
        }
        System.out.println(value[1]);
    }
}
