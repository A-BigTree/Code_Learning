# 179.最大数

给定一组非负整数 `nums`，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。

**注意：**输出结果可能非常大，所以你需要返回一个字符串而不是整数。

**示例 1：**

```
输入：nums = [10,2]
输出："210"
```

**示例 2：**

```
输入：nums = [3,30,34,5,9]
输出："9534330"
```

思路1：多条件排序，首位数最大最短者排在前面，后面位数以此类推；

- 两个数怎么判断首位数大且短：先将整数转为字符串，通过`compareStrings()`方法逻辑判断；

```java
class Solution {
    public String largestNumber(int[] nums) {
        // 将整数转为字符串
        String[] numsStr = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            numsStr[i]=String.valueOf(nums[i]);
        }
        // 冒泡排序
        for(int i = 0; i<nums.length-1;i++){
            for(int j = 0; j<nums.length-1-i;j++){
                if(compareStrings(numsStr[j+1], numsStr[j])){
                    String temp = numsStr[j];
                    numsStr[j] = numsStr[j+1];
                    numsStr[j+1] = temp;
                }
            }
        }
        //将字符串输出
        String result = "";
        // 去除开头的0
        int j = 0;
        for(;j<numsStr.length - 1;j++){
            if(!numsStr[j].equals("0")){
                break;
            }
        }
        // 结果累加
        for(;j<numsStr.length;j++){
            result += numsStr[j];
        }
        return result;
    }
    // 比较两个字符串大小
    private boolean compareStrings(String str1, String str2){
        int i = 0;
        for(;i<str1.length()&&i<str2.length();i++){
            if(str1.charAt(i)>str2.charAt(i)){
                return true;
            }else if(str1.charAt(i)<str2.charAt(i)){
                return false;
            }
        }
        if(i!=str1.length() || i!=str2.length()){
            String temp1 = str1 + str2, temp2 = str2 + str1;
            for(;i<temp1.length();i++){
                if(temp1.charAt(i)>temp2.charAt(i)){
                return true;
                }else if(temp1.charAt(i)<temp2.charAt(i)){
                    return false;
                }
            }
        }
        return false;
    }
}
```



# 3.无重复数字

给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 **示例 1:**

```
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例 2:**

```
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例 3:**

```
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

思路：用128大小哈希表记录字符上次出现位置，空间大小控制在O(128)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现位置
        int[]charHash=new int[128];
        for(int i=0;i<128;i++){
            charHash[i] = -1;
        }
        // 窗口滑动位置
        int start = 0, res = 0;
        for(int i = 0;i<s.length();i++){
            int index = s.charAt(i);
            start = Math.max(start, charHash[index] + 1);
            res = Math.max(res,  i-start+1);
            charHash[index] = i;
        }
        return res;
    }
}
```

# 1835. 所有数对按位与结果的异或和

列表的 **异或和（XOR sum）**指对所有元素进行按位 XOR 运算的结果。如果列表中仅有一个元素，那么其 异或和 就等于该元素。

- 例如，[1,2,3,4] 的 异或和 等于 1 XOR 2 XOR 3 XOR 4 = 4 ，而 [3] 的 异或和 等于 3 。

给你两个下标 从 0 开始 计数的数组 `arr1` 和 `arr2` ，两数组均由非负整数组成。

根据每个 (i, j) 数对，构造一个由 `arr1[i] AND arr2[j]`（按位 AND 运算）结果组成的列表。

返回上述列表的异或和 。

示例 1：

```
输入：arr1 = [1,2,3], arr2 = [6,5]
输出：0
解释：列表 = [1 AND 6, 1 AND 5, 2 AND 6, 2 AND 5, 3 AND 6, 3 AND 5] = [0,1,2,0,2,1] ，
异或和 = 0 XOR 1 XOR 2 XOR 0 XOR 2 XOR 1 = 0 。
```

示例 2：

```
输入：arr1 = [12], arr2 = [4]
输出：4
解释：列表 = [12 AND 4] = [4] ，异或和 = 4 。
```

思路：$ab\oplus ac=a(b\oplus c)$

```java
class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int temp1 = arr1[0], temp2 = arr2[0];
        for(int i = 1; i<arr1.length;i++){
            temp1 = temp1^arr1[i];
        }
        for(int i = 1; i<arr2.length;i++){
            temp2 = temp2^arr2[i];
        }
        return temp1&temp2;
        
    }
}
```

# 1051.高度检查器

学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。

排序后的高度情况用整数数组 `expected` 表示，其中 `expected[i]` 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。

给你一个整数数组 `heights` ，表示 当前学生站位 的高度情况。`heights[i]` 是这一行中第 i 位学生的高度（下标从 0 开始）。

返回满足 `heights[i] != expected[i]` 的 下标数量 。

思路：排序检查那几个地方不一致

```java
public int heightChecker(int[] heights) {
    int count = 0;
    int[] temp = heights.clone();
    Arrays.sort(temp);
    for(int i=0;i<heights.length;i++){
        if(heights[i]!=temp[i])
            count++;
    }
    return count;
}
```

# 449.序列化和反序列化二叉搜索树

序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。

设计一个算法来序列化和反序列化 **二叉搜索树** 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。

编码的字符串应尽可能紧凑。

**示例 1：**

```
输入：root = [2,1,3]
输出：[2,1,3]
```

**示例 2：**

```
输入：root = []
输出：[]
```

思路：前序遍历输出，因为是搜索二叉树，排序后结果为中序遍历，即可通过前序遍历和中序遍历构造二叉树。

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder buffer = new StringBuilder();
        preorderEncodedTree(root, buffer);
        return (buffer.toString()).trim();
    }

    // 前序遍历
    public void preorderEncodedTree(TreeNode tree, StringBuilder buffer){
        if(tree!=null){
            buffer.append(tree.val + " ");
            preorderEncodedTree(tree.left, buffer);
            preorderEncodedTree(tree.right, buffer);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String [] datas = data.split(" ");
        int[] preorder = new int[datas.length];
        int i = 0;
        for(String str:datas){
            preorder[i] = Integer.parseInt(str);
            i++;
        }
        int[] inorder = Arrays.copyOfRange(preorder,0,preorder.length);
        Arrays.sort(inorder);
        return buildTree(preorder, inorder);

    }

    // 前序 中序恢复
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length==0){
            return null;
        }
        int mid = preorder[0];
        int index = Arrays.binarySearch(inorder, mid);
        TreeNode root = new TreeNode(mid);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
```

# 91.解码方法

一条包含字母 `A-Z` 的消息通过以下的方式进行了 **编码** ：

```
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
```

要 **解码** 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，`"11106"` 可以映射为：

- `AAJF"` 对应分组 `(1 1 10 6)`
- `"KJF"` 对应分组 `(11 10 6)`

注意，像 `(1 11 06)` 这样的分组是无效的，因为 `"06"` 不可以映射为 `'F'` ，因为 `"6"` 与 `"06"` 不同。

给你一个只含数字的 **非空** 字符串 `s` ，请计算并返回 **解码** 方法的 **总数** 。

题目数据保证答案肯定是一个 **32 位** 的整数。

## 思路

假设$f_i$为字符串s前i位的解码总数，

当解码字符为1位时，状态方程为
$$
\begin{cases}
f_i=f_{i-1},s[i]\not=0\\
f_i=0,s[i]=0
\end{cases}
$$
当解码字符为2位时，状态方程为
$$
\begin{cases}
f_i=f_{i-2},s[i-1]\not=0\&\overline{s[i-1]s[i]}\in[10,26]\\
f_i=0, other
\end{cases}
$$

## 代码

```java
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int res = 0, last1 = 1, last2=0;
        for(int i = 1;i<=n;i++){
            res = last1*skip1Char(s.charAt(i-1));
            if(i>1){
                res += last2*skip2Char(s.charAt(i-2), s.charAt(i-1));
            }
            last2 = last1;
            last1 = res;
        }
        return res;
    }

    public int skip1Char(char ch){
        if(ch=='0'){
            return 0;
        }else{
            return 1;
        }
    }

    public int skip2Char(char ch1, char ch2){
        if(ch1 != '0'){
            if(ch1 == '1'){
                return 1;
            }else if(ch1=='2' && ch2 < '7'){
                return 1;
            }
        }
        return 0;
    }
}
```



# 639.解码方法Ⅱ

一条包含字母 `A-Z` 的消息通过以下的方式进行了 **编码** ：

```
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
```

要 **解码** 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，`"11106"` 可以映射为：

- `AAJF"` 对应分组 `(1 1 10 6)`
- `"KJF"` 对应分组 `(11 10 6)`

注意，像 `(1 11 06)` 这样的分组是无效的，因为 `"06"` 不可以映射为 `'F'` ，因为 `"6"` 与 `"06"` 不同。

**除了** 上面描述的数字字母映射方案，编码消息中可能包含 `'*'` 字符，可以表示从`'1'` 到 `'9'` 的任一数字（不包括 `'0'`）。例如，编码字符串 `"1*"` 可以表示`"11"`、`"12"`、`"13"`、`"14"`、`"15"`、`"16"`、`"17"`、`"18"` 或 `"19"` 中的任意一条消息。对 `"1*"` 进行解码，相当于解码该字符串可以表示的任何编码消息。

给你一个字符串 `s` ，由数字和 `'*'` 字符组成，返回 **解码** 该字符串的方法 **数目** 。

由于答案数目可能非常大，返回 `10^9 + 7` 的 **模** 

# 5.最长回文子串

给你一个字符串 `s`，找到 `s` 中最长的回文子串。

如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

**示例 1：**

```
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
```

**示例 2：**

```
输入：s = "cbbd"
输出："bb"
```

##  思路

$P(i,j)$表示第i个字符到第j个字符是否为回文串，构建状态方程：
$$
\begin{cases}
P(i,j)=true,i==j\\
P(i,j)=(P(i+1,j-1)\&\&(s[j]==s[i]))

\end{cases}
$$

## 代码

```java
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][]isPalin = new boolean[n][n];
        // 初始化
        for(int i = 0; i<n;i++){
            isPalin[i][i] = true;
            if(i>0){
                isPalin[i][i-1] = true;
            }
        }
        // 动态规划
        int begin = 0, maxLen = 1;
        for(int l = 2;l<=n;l++){
            for(int i = 0; i < n-l+1;i++){
                int j = i + l -1;
                if(isPalin[i+1][j-1]&&(s.charAt(i)==s.charAt(j))){
                    isPalin[i][j] = true;
                    if(l>maxLen){
                        begin = i;
                        maxLen = l;
                    }
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }
}
```

# 1537.最大得分

你有两个 **有序** 且数组内元素互不相同的数组 `nums1` 和 `nums2` 。

一条 **合法路径** 定义如下：

- 选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。
- 从左到右遍历当前数组。

- 如果你遇到了 `nums1` 和 `nums2` 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。

得分定义为合法路径中不同数字的和。

请你返回所有可能合法路径中的最大得分。

由于答案可能很大，请你将它对 10^9 + 7 取余后返回。

## 思路

数组nums1前i个最大和为$f(i)$，数组nums2前j个最大和为$g(j)$，构建状态方程：
$$
\begin{cases}
f(i)=f(i-1)+nums1[i],nums1[i]<nums2[j]\\
\\
g(j)=g(j-1)+nums2[j],nums1[i]>nums2[j]\\
\\
f(i)=g(j)=\max{(f(i-1),g(j-1))}+nums1[i],nums1[i]==nums2[j]
\end{cases}
$$

## 代码

```java
class Solution {
    private static final int MOD_VALUE = 1000000007;

    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        long sum1 = 0L, sum2 = 0L;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                sum1 = sum2 = Math.max(sum1,sum2) + nums1[i];
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                sum1 = sum1 + nums1[i];
                i++;
            }else{
                sum2 = sum2 + nums2[j];
                j++;
            }
        }
        while(i<nums1.length){
            sum1 = sum1 + nums1[i];
            i++;
        }
        while(j<nums2.length){
            sum2 = sum2 + nums2[j];
            j++;
        }
        return (int) (Math.max(sum1, sum2)%MOD_VALUE);

    }
}
```

