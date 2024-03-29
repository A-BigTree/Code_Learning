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

# 1207.独一无二的出现次数

给你一个整数数组 `arr`，请你帮忙统计数组中每个数的出现次数。

如果每个数的出现次数都是独一无二的，就返回 `true`；否则返回 `false`。

##  代码

```java
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for(int num:arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.size()==new HashSet<Integer>(map.values()).size();
    }
}
```

# 2485.找出中枢函数

给你一个正整数 `n` ，找出满足下述条件的 **中枢整数** `x` ：

- `1` 和 `x` 之间的所有元素之和等于 `x` 和 `n` 之间所有元素之和。

返回中枢整数 `x` 。如果不存在中枢整数，则返回 `-1` 。题目保证对于给定的输入，至多存在一个中枢整数。

## 代码

```java
class Solution {
    public int pivotInteger(int n) {
        for(int i = 1; i<=n;i++){
            if(((i+1)*i)/2==((i+n)*(n-i+1))/2){
                return i;
            }else if(((i+1)*i)/2>((i+n)*(n-i+1))/2){
                return -1;
            }
        }
        return -1;
    }
}
```

# 1309.解码字母到整数映射

给你一个字符串 `s`，它由数字（`'0'` - `'9'`）和 `'#'` 组成。我们希望按下述规则将 `s` 映射为一些小写英文字符：

- 字符（`'a'` - `'i'`）分别用（`'1'` - `'9'`）表示。
- 字符（`'j'` - `'z'`）分别用（`'10#'` - `'26#'`）表示。 

返回映射之后形成的新字符串。

题目数据保证映射始终唯一。

## 代码

```java
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder buffer = new StringBuilder();
        for(int i = s.length() - 1; i>=0; --i){
            char temp = s.charAt(i);
            int offset = temp=='#'?(s.charAt(--i) - '1' + (s.charAt(--i) - '0') * 10):(temp - '1');
            buffer.append((char)('a' + offset));
        }
        return (buffer.reverse()).toString();

        /*
        ArrayList<Character> chars = new ArrayList<>();
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i)=='#'){
                int size = chars.size();
                String num = String.valueOf(chars.remove(size-1));
                num = String.valueOf(chars.remove(size-2)) + num;
                int index = Integer.parseInt(num);
                chars.add((char)(index + 96));
            }else{
                chars.add(s.charAt(i));
            }
        }
        char [] resChar = new char[chars.size()];
        for(int i = 0; i<chars.size();i++){
            char temp = chars.get(i);
            if(temp >= '1' && temp <= '9'){
                resChar[i] = (char)(temp + 48);
            }else{
                resChar[i] = temp;
            }
        }
        return new String(resChar);*/
    }
}
```

# 6.N字形变换

将一个给定字符串 `s` 根据给定的行数 `numRows` ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 `"PAYPALISHIRING"` 行数为 `3` 时，排列如下：

```
P   A   H   N
A P L S I I G
Y   I   R
```

## 代码

```java
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int n = s.length();
        short []offset = new short[numRows];
        // 一共有几块
        int block = n/(2*numRows-2);
        initBytes(offset, n, numRows, block);
        char[]chars = new char[n];
        for(int i = 0; i< n;i++){
            chars[getIndex(i, numRows, offset)] = s.charAt(i);
        }
        return new String(chars);
    }

    public void initBytes(short[] offset, int n, int k, int block){
        int base = k>2?block * 2:block;
        int mod = n % (2*k-2);
        boolean isOver = false;
        if(mod>k){
            isOver = true;
            mod = mod % k;
        }
        int last = 0;
        for(int i = 0; i<k; i++){
            offset[i] = (short)last;
            if(i==0 || i == k -1){
                last += block;
            }else{
                last += base;
            }
            if(isOver){
                last += 1;
                if(i!=0&&i!=k-1){
                    if(i>=k-mod-1){
                        last += 1;
                    }
                }
            }else{
                if(i < mod){
                    last += 1;
                }
            }
        }
    }

    public int getIndex(int index, int k, short[]offset){
        int mod = index % (2*k-2);
        int num = index / (2*k-2);
        int off = k>2?num*2:num;
        int col = mod>=k?2 * k - mod - 2:mod;
        int base = 0;
        if(col == 0 || col == k - 1){
            base = num;
        }else{
            base = off;
        }
        if(mod>=k){
            return offset[col] + base + 1;
        }
        return offset[col] + base;
    }
}
```

# 77.组合

给定两个整数 `n` 和 `k`，返回范围 `[1, n]` 中所有可能的 `k` 个数的组合。

你可以按 **任何顺序** 返回答案。

## 代码

```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        ArrayList<Integer>temp = new ArrayList<>();
        subCombine(resList, n, k, temp, 0, 0);
        return resList;

    }

    public void subCombine(List<List<Integer>> resList, int n, int k, 
                            ArrayList<Integer> temp, int index, int next){
        if(next == k){
            resList.add(temp);
            return;
        }
        for(;index + k - next <= n;index++){
            ArrayList<Integer> tempCopy = new ArrayList<>(temp);
            tempCopy.add(index + 1);
            subCombine(resList, n, k, tempCopy, index + 1, next + 1);
        }
        return;
    }
```

# 1907.按分类统计薪水

```sql
SELECT
	'Low Salary' AS category,
	sum( income < 20000 ) AS accounts_count 
FROM
	accounts 
    UNION ALL
SELECT
	'Average Salary' AS category,
	sum( income >= 20000 AND income <= 50000 ) AS accounts_count 
FROM
	accounts 
	UNION ALL
SELECT
	'High Salary' AS category,
	sum( income > 50000 ) AS accounts_count 
FROM
	accounts
```

# 1070.产品销售分析Ⅲ

## 代码

```sql
# Write your MySQL query statement below
select product_id, year first_year, quantity, price
from sales
where (product_id, year) in
(select product_id, min(year)
from sales 
group by product_id)
```

# 376.摆动缓冲

如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 **摆动序列 。**第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。

- 例如， `[1, 7, 4, 9, 2, 5]` 是一个 **摆动序列** ，因为差值 `(6, -3, 5, -7, 3)` 是正负交替出现的；
- 相反，`[1, 4, 7, 2, 5]` 和 `[1, 7, 4, 5, 5]` 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零；

## 思路

$up[i]$ 表示以前 *i* 个元素中的某一个为结尾的最长的「上升摆动序列」的长度；

$down[i]$ 表示以前 *i* 个元素中的某一个为结尾的最长的「下降摆动序列」的长度。

构造状态方程
$$
\begin{cases}
\begin{cases}
up[i]=up[i-1],nums[i]\le nums[i-1]\\
\\
up[i]=\max{(up[i-1],down[i-1]+1)},nums[i]>nums[i-1]
\end{cases}\\
\\
\\
\begin{cases}
down[i]=down[i-1],nums[i]\ge nums[i-1]\\
\\
down[i]=\max{(down[i-1],up[i-1]+1)},nums[i]<nums[i-1]
\end{cases}
\end{cases}
$$

## 代码

```java
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            }
            if (nums[i] < nums[i - 1]) {
                down = Math.max(down, up + 1);
            }
        }
        return Math.max(up, down);
    }
}
```

# 168.Excel表列名称

给你一个整数 `columnNumber` ，返回它在 Excel 表中相对应的列名称。

例如：

```
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
```

## 思路

十进制转为26进制

## 代码

```java
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder buffer = new StringBuilder();
        for(int i = columnNumber; i > 0; i=i/26){
            i--;
            char temp = ((char)('A' + (i%26)));
            buffer.append(temp);
        }
        return buffer.reverse().toString();
    }
}
```



# 2360.图中的最长环

给你一个 `n` 个节点的 **有向图** ，节点编号为 `0` 到 `n - 1` ，其中每个节点 **至多** 有一条出边。

图用一个大小为 `n` 下标从 **0** 开始的数组 `edges` 表示，节点 `i` 到节点 `edges[i]` 之间有一条有向边。如果节点 `i` 没有出边，那么 `edges[i] == -1` 。

请你返回图中的 **最长** 环，如果没有任何环，请返回 `-1` 。

一个环指的是起点和终点是 **同一个** 节点的路径。

## 代码

```java
class Solution {
    public int longestCycle(int[] edges) {
        int res = -1;
        int n = edges.length;
        boolean []isCross = new boolean[n];
        for(int i = 0; i < n; i++){
            // 该节点已遍历
            if(isCross[i]){
                continue;
            }
            int index  = i;
            LinkedHashSet<Integer> set = new LinkedHashSet();
            while(!isCross[index]){
                set.add(index);
                isCross[index] = true;
                // 无出边
                if(edges[index]==-1){
                    break;
                }
                int out = edges[index];
                // 存在环
                if(set.contains(out)){
                    // 寻找环起点
                    Iterator<Integer> items = set.iterator();
                    int start = 0;
                    while(items.hasNext()){
                        if(items.next()==out){
                            break;
                        }
                        start++;
                    }
                    if(set.size()-start > res){
                        res = set.size() - start;
                    }
                }else{
                    index = out;
                }
            }
        }
        return res;
    }
}
```

# 2351.第一次出现两次的字母

给你一个由小写英文字母组成的字符串 `s` ，请你找出并返回第一个出现 **两次** 的字母。

**注意：**

- 如果 `a` 的 **第二次** 出现比 `b` 的 **第二次** 出现在字符串中的位置更靠前，则认为字母 `a` 在字母 `b` 之前出现两次；
- `s` 包含至少一个出现两次的字母；

## 代码

```java
class Solution {
    public char repeatedCharacter(String s) {
        int n = s.length();
        boolean[]records = new boolean[26];
        for(int i = 0; i < n; i++){
            int index = 'z' - s.charAt(i);
            if(records[index]){
                return s.charAt(i);
            }else{
                records[index] = true;
            }
        }
        return 'a';
    }
}
```

# 1615.最大网络秩

`n` 座城市和一些连接这些城市的道路 `roads` 共同组成一个基础设施网络。每个`roads[i] = [ai, bi]` 都表示在城市 `ai` 和 `bi` 之间有一条双向道路。

两座不同城市构成的 **城市对** 的 **网络秩** 定义为：与这两座城市 **直接** 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 **一次** 。

给你整数 `n` 和数组 `roads`，返回整个基础设施网络的 **最大网络秩** 。

## 思路1

```java
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(n);
        // 初始化Map
        for(int i = 0; i<n; i++){
            map.put(i, new HashSet<Integer>());
        }
        // 写入Map
        for(int[] temp:roads){
            (map.get(temp[0])).add(temp[1]);
            (map.get(temp[1])).add(temp[0]);
        }
        // 寻找最大值
        int maxLength = 0;
        for(int i = 0; i<n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = map.get(i).size() + map.get(j).size();
                if(map.get(i).contains(j)){
                    temp--;
                }
                if(temp > maxLength){
                    maxLength = temp;
                }
            }
        }
        return maxLength;
    }
}
```



# 1032.字符流

设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 `words` 中的一个字符串。

例如，`words = ["abc", "xyz"]` 且字符流中逐个依次加入 4 个字符 `'a'`、`'x'`、`'y'` 和 `'z'`，你所设计的算法应当可以检测到 `"axyz"` 的后缀 `"xyz"` 与 `words` 中的字符串 `"xyz"` 匹配。

按下述要求实现 `StreamChecker` 类：

- `StreamChecker(String[] words)` ：构造函数，用字符串数组 `words` 初始化数据结构。
- `boolean query(char letter)`：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 `words` 中的某一字符串，返回 `true` ；否则，返回 `false`。



# 8.字符串转换整数

请你来实现一个 `myAtoi(string s)` 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 `atoi` 函数）。

函数 `myAtoi(string s)` 的算法如下：

读入字符串并丢弃无用的前导空格

检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。

读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。

将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。

如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 231 − 1 。

返回整数作为最终结果。

## 代码

```java
class Solution {
    public static final int MAX_RANGE = Integer.MAX_VALUE/10;
    public static final int MIN_RANGE = Integer.MIN_VALUE/10;

    public int myAtoi(String s) {
        int index = 0;
        int n = s.length();
        // 去除空格
        while(index < n && s.charAt(index)==' '){
            index++;
        }
        if(index == n){
            return 0;
        }
        // 寻找正负号
        int isMinus = 1;
        if(s.charAt(index) == '-'){
            isMinus = -1;
            index++;
        }else if(s.charAt(index) == '+'){
            index++;
        }
        int res = 0;
        // 读取数字
        while(index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            // 超过最大整数
            if((res > MAX_RANGE)||(res == MAX_RANGE && s.charAt(index) > '7')){
                return Integer.MAX_VALUE;
            }
            // 超过最小整数
            if((res < MIN_RANGE)||(res == MIN_RANGE && s.charAt(index) > '8')){
                return Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(index++) - '0') * isMinus;
        }

        return res;
    }
}
```

# 10.正则表达式匹配

给你一个字符串 `s` 和一个字符规律 `p`，请你来实现一个支持 `'.'` 和 `'*'` 的正则表达式匹配。

- `'.'` 匹配任意单个字符；
- `'*'` 匹配零个或多个前面的那一个元素；

所谓匹配，是要涵盖 **整个** 字符串 `s`的，而不是部分字符串。

## 思想

$f[i][j]$表示s到i和p到j是否匹配，动态方程如下：
$$
f[i][j]=
\begin{cases}
\begin{cases}
f[i-1][j-1],match(s[i],p[j])\\
\\
false,otherwise
\end{cases}
\ \ \ \ \ \ p[i]\not='*'\\

\begin{cases}

f[i-1][j]||f[i][j-2],match(s[i],p[j - 1])\\
\\
f[i][j-2],otherwise

\end{cases}
\ \ \ \ \ \ \ p[i]=='*'
\end{cases}
$$

## 代码

```java
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for(int i = 0; i <= m; i++){
            for(int j = 1; j  <= n; j++){
                if(p.charAt(j - 1)== '*'){
                    f[i][j] |= f[i][j-2];
                    if(match(s, p, i ,j - 1)){
                        f[i][j] |= f[i - 1][j];
                    }
                }else{
                    if(match(s, p, i, j)){
                        f[i][j] = f[i-1][j-1];
                    }
                }
            }
        }
        return f[m][n];

    }

    public boolean match(String s, String p, int i, int j){
        if(i == 0){
            return false;
        }
        if(p.charAt(j - 1)=='.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
```

# 11.成最多水的容器

给定一个长度为 `n` 的整数数组 `height` 。有 `n` 条垂线，第 `i` 条线的两个端点是 `(i, 0)` 和 `(i, height[i])` 

找出其中的两条线，使得它们与 `x` 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

## 代码

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while(left < right){
            int temp; 
            if(height[left] <= height[right]){
                temp = (right - left) * height[left];
                if(temp > max){
                    max = temp;
                }
                left++;
            }else{
                temp = (right - left) * height[right];
                if(temp > max){
                    max = temp;
                }
                right--;
            }
        }
        return max;
    }
}
```

# 12.整数转罗马数字

## 代码

```java
class Solution {
    public static final char[][] MAP_CHAR = new char[][]{{'I','V'},{'X','L'},{'C','D'},{'M','M'}};

    public String intToRoman(int num) {
        
        StringBuilder buffer = new StringBuilder();
        rToRoman(num, buffer, 0);

        return buffer.toString();
    }

    public void rToRoman(int num, StringBuilder buffer, int index){
        if(num == 0){
            return;
        }
        rToRoman(num/10, buffer, index+1);
        int mod = num % 10;
        if(mod==4){
            buffer.append(MAP_CHAR[index][0]);
            buffer.append(MAP_CHAR[index][1]);
        }else if(mod==9){
            buffer.append(MAP_CHAR[index][0]);
            buffer.append(MAP_CHAR[index + 1][0]);
        }else if(mod < 4){
            for(int i = 0 ; i < mod; i++){
                buffer.append(MAP_CHAR[index][0]);
            }
        }else{
            buffer.append(MAP_CHAR[index][1]);
            for(int i = 0 ; i < mod - 5; i++){
                buffer.append(MAP_CHAR[index][0]);
            }
        }
    }
}
```

# 13 数字转罗马数字

## 代码

```java
class Solution {
    private static final HashMap<Character,Integer>MAP_CHAR = new HashMap<>();

    static{
        MAP_CHAR.put('I', 1);
        MAP_CHAR.put('V', 5);
        MAP_CHAR.put('X', 10);
        MAP_CHAR.put('L', 50);
        MAP_CHAR.put('C', 100);
        MAP_CHAR.put('D', 500);
        MAP_CHAR.put('M', 1000);
    }

    public int romanToInt(String s) {
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i++){
            if((i < n - 1) && (MAP_CHAR.get(s.charAt(i))<MAP_CHAR.get(s.charAt(i + 1)))){
                res += (MAP_CHAR.get(s.charAt(i + 1)) - MAP_CHAR.get(s.charAt(i)));
                i++;
            }else{
                res+= MAP_CHAR.get(s.charAt(i));
            }
        }

        return res;
    }
}
```

# 14.最长公共前缀

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 `""`。

## 代码

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder buffer = new StringBuilder();
        int minLength = 200;
        for(String temp:strs){
            minLength = Math.min(minLength, temp.length());
        }
        for(int i = 0; i < minLength; i++){
            char temp = strs[0].charAt(i);
            boolean isOk = true;
            for(String str:strs){
                if(str.charAt(i)!=temp){
                    isOk = false;
                    break;
                }
            }
            if(isOk){
                buffer.append(temp);
            }else{
                return buffer.toString();
            }
        }
        return buffer.toString();
    }
}
```

# 15.三数之和

给你一个整数数组 `nums` ，判断是否存在三元组 `[nums[i], nums[j], nums[k]]` 满足 `i != j`、`i != k` 且 `j != k` ，同时还满足 `nums[i] + nums[j] + nums[k] == 0` 。请

你返回所有和为 `0` 且不重复的三元组。

**注意：**答案中不可以包含重复的三元组。

## 代码

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        if(nums[0]>0)return resList;
        int n = nums.length;
        if(nums[n-1]<0)return resList;
        int left = 0, right = n - 1;
        int lLast = Integer.MIN_VALUE, rLast = Integer.MAX_VALUE;
        int lIndex = 0, rIndex = n - 1;
        while(left < right - 1){
            // 是否重复
            if(left != lIndex && nums[left]==lLast){
                left++;
                continue;
            }else{
                lLast = nums[left];
            }
            if(right != rIndex && nums[right]==rLast){
                right--;
                continue;
            }else{
                rLast = nums[right];
            }
            lIndex = left;
            rIndex = right;
            int sum2 = nums[left] + nums[right];
            int curr, currLast = Integer.MAX_VALUE;
            if(sum2 < 0){
                curr = right - 1;
                for(;curr > left;curr--){
                    if(nums[curr]==currLast){
                        continue;
                    }else{
                        currLast = nums[curr];
                    }
                    if(nums[curr] + sum2==0){
                        ArrayList<Integer> lt = new ArrayList<>(3);
                        lt.add(nums[left]);
                        lt.add(nums[curr]);
                        lt.add(nums[right]);
                        resList.add(lt);
                    }else if(nums[curr] + sum2 < 0){
                        break;
                    }
                }
                left++;
            }else{
                curr = left + 1;
                for(;curr < right;curr++){
                    if(nums[curr]==currLast){
                        continue;
                    }else{
                        currLast = nums[curr];
                    }
                    if(nums[curr] + sum2==0){
                        ArrayList<Integer> lt = new ArrayList<>(3);
                        lt.add(nums[left]);
                        lt.add(nums[curr]);
                        lt.add(nums[right]);
                        resList.add(lt);
                    }else if(nums[curr] + sum2 > 0){
                        break;
                    }
                }
                right--;
            }
        }
        return resList;
    }
}*/
```

# 16.最接近的三数之和

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        int n = nums.length;
        for(int left = 0; left < n - 2; left++){
            if(left > 1 && nums[left] == nums[left - 1]){
                continue;
            }
            for(int right = n - 1; right > left + 1; right--){
                if(right < n - 1 && nums[right] == nums[right + 1]){
                    continue;
                }
                int temp = nums[left] + nums[right];
                for(int curr = right - 1; curr > left; curr--){
                    if(curr < right - 1 && nums[curr] == nums[curr+1]){
                        continue;
                    }
                    int minTemp = temp + nums[curr];
                    if(Math.abs(minTemp - target) < min){
                        res = minTemp;
                        min = Math.abs(minTemp - target);
                    }
                }

            }
        }
        return res;
    }
}
```

# 17.电话号码的字母组合

## 代码

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int n = digits.length();
        if(n == 0){
            return res;
        }
        char[]temp = new char[n];
        reCombination(res, 0, temp, digits);
        return res;
    }

    public void reCombination(List<String>res, int index, char[]temp, String digits){
        if(index == digits.length()){
            res.add(new String(temp));
            return;
        }
        char charTemp = digits.charAt(index);
        int num = (charTemp=='7' || charTemp=='9')?4:3;
        for(int i = 0; i < num; i++){
            char[] tempCopy = Arrays.copyOf(temp,digits.length());
            tempCopy[index] = (char)((charTemp - '2') * 3 + i + 'a');
            if(charTemp > '7'){
                tempCopy[index] = (char) (tempCopy[index] + 1);
            }
            reCombination(res, index + 1, tempCopy, digits);
        }

    }
}
```

# 18.四数之和

## 代码

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}


/*
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n < 4){
            return res;
        }
        Arrays.sort(nums);
        if(nums[0] + nums[1] + nums[2] + nums[3] > target){
            return res;
        }
        for(int first = 0; first < n - 3; first++){
            if(first > 0 && nums[first]==nums[first - 1]){
                continue;
            }
            for(int secound = first + 1; secound < n - 2; secound++){
                if(secound > first + 1 && nums[secound]==nums[secound - 1]){
                    continue;
                }
                for(int third = secound + 1; third < n - 1; third++){
                    if(third > secound + 1 && nums[third]==nums[third - 1]){
                        continue;
                    }
                    int curr = third + 1;
                    int sum3 = nums[first] + nums[secound] + nums[third];
                    if(sum3 > target){
                        return res;
                    }
                    while(curr < n && sum3 + nums[curr] < target){
                        curr++;
                    }
                    if(curr < n && sum3 + nums[curr] == target){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[first]);
                        temp.add(nums[secound]);
                        temp.add(nums[third]);
                        temp.add(nums[curr]);
                        res.add(temp);
                    }
                }
            }

        }
        return res;
    }
}*/
```

# 19.删除链表倒数节点

## 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        if(length==n){
            return head.next;
        }
        ListNode curr = head, next = null,res = null;
        int i = 0;
        while(curr != null){
            if(i == (length - n)){
                next = curr.next;
                break;
            }
            i++;
            res = curr;
            curr = curr.next;
        }
        res.next = next;
        return head;
        
    }
}
```

# 20.有效的括号

## 代码

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();
        int n = s.length();
        int i = 0;
        while(i < n){
            char temp = s.charAt(i);
            if(temp=='(' || temp=='{' || temp == '['){
                chars.push(temp);
                i++;
            }else{
                if(chars.size()==0){
                    return false;
                }
                if(temp==')'){
                    if(chars.peek()=='('){
                        i++;
                        chars.pop();
                    }else{
                        return false;
                    }
                }else if(temp == '}'){
                    if(chars.peek()=='{'){
                        i++;
                        chars.pop();
                    }else{
                        return false;
                    }
                }else if(temp == ']'){
                    if(chars.peek()=='['){
                        i++;
                        chars.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return chars.size()==0;
    }
}
```

# 21.合并两个有序链表

## 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode next1 = list1, next2 = list2, res = new ListNode(), resNext = res;
        while(next1 != null && next2 != null){
            if(next1.val < next2.val){
                resNext.val = next1.val;
                next1 = next1.next;
            }else{
                resNext.val = next2.val;
                next2 = next2.next;
            }
            resNext.next = new ListNode();
            resNext = resNext.next;
        }
        while(next1!=null){
            resNext.val = next1.val;
            next1 = next1.next;
            if(next1!=null)
                resNext.next = new ListNode();
            resNext = resNext.next;
        }
        while(next2!=null){
            resNext.val = next2.val;
            next2 = next2.next;
            if(next2!=null)
                resNext.next = new ListNode();
            resNext = resNext.next;
        }
        return res;
    }
}
```

# 22.括号生成

## 代码

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        reGenerate(res, buffer, 0, 0, 2 * n);
        return res;

    }

    public void reGenerate(List<String> res, StringBuilder buffer, int left, int right, int max){
        if(left + right == max){
            res.add(buffer.toString());
            return;
        }
        if(left < max/2){
            buffer.append('(');
            reGenerate(res, buffer, left + 1, right, max);
            buffer.deleteCharAt(buffer.length() - 1);
        }
        if(left > right){
            buffer.append(')');
            reGenerate(res, buffer, left, right + 1, max);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}
```

# 23.合并k个升序链表

## 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0)return null;
        if(n == 1)return lists[0];
        ListNode[] nexts = new ListNode[n];
        int j = 0;
        for(int i = 0; i < n; i++){
            if(lists[i]!=null){
                nexts[j++] = lists[i];
            }
        }
        n = j;
        if(n == 0) return null;
        if(n == 1) return nexts[0];
        
        int nullNum = 0;
        ListNode res = new ListNode(),resNext = res;
        while(true){
            int min = Integer.MAX_VALUE,index = -1;
            for(int i = 0; i < n; i++){
                if(nexts[i]!=null){
                    if(nexts[i].val < min){
                        index = i;
                        min = nexts[i].val;
                    }
                }
            }
            if(index == -1){
                break;
            }else{
                resNext.val = min;
                nexts[index] = nexts[index].next;
                if(nexts[index] == null){
                    nullNum++;
                }
                if(nullNum != n)
                    resNext.next = new ListNode();
                resNext = resNext.next;
            }
        }
        return res;
    }
}
```

# 24.两两交换链表节点

## 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode headNode = new ListNode();
        headNode.next = head;
        ListNode last = headNode;
        ListNode first = head;
        while(first != null){
            ListNode secound = first.next;
            if(secound == null){
                break;
            }
            ListNode nodeNext = secound.next;
            last.next = secound;
            secound.next = first;
            last = secound.next;
            first.next = nodeNext;
            first = nodeNext;
        }
        return headNode.next;
    }
}
```

# 25.K个一组反转列表

## 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode headNode = new ListNode();
        ListNode last = headNode, first = head;
        ListNode []swaps = new ListNode[k];
        while(first!=null){
            int i = 0;
            // 初始化数组
            for(;first!=null && i<k;i++){
                swaps[i] = first;
                first = first.next;
            }
            if(i!=k){
                break;
            }
            // 交换节点
            for(int j = k-1; j > 0; j--){
                swaps[j].next = swaps[j-1];
            }
            last.next = swaps[k-1];
            last = swaps[0];
            swaps[0].next = first;
        }

        return headNode.next;
    }
}
```

# 28.KMP算法

## 代码

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int []next = new int[n];
        kmp(next, needle);
        int j = 0, i = 0;
        while(i < m){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)) j=next[j-1];
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == n){
                return i - n + 1;
            }
            i++;
        }
        return -1;
    }

    public void kmp(int[]next, String needle){
        for(int i = 1, j = 0; i < needle.length(); i++){
            while(j > 0 && needle.charAt(i) != needle.charAt(j)) j = next[j - 1];
            if(needle.charAt(i) == needle.charAt(j)) j++;
            next[i] = j;
        }
    }
}
```

# 29.串联所有单词的字串

## 代码

```java
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }
}
```

# 30.下一个排列

## 代码

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
```

# 32.最长有效括号

给你一个只包含 `'('` 和 `')'` 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

## 思路

$f[i,j]$表示从i到j是否有效
$$
f[i,j]=
\begin{cases}
s[j]=='('\rightarrow false\\
\\
s[j]==')'\rightarrow
\begin{cases}
if\ f[i+1,j-1]\&\&s[i]='(',true\\
\\
if\ f[i,k]\&\&f[k+1,j],true\\
\\
otherwise,false


\end{cases}



\end{cases}
$$

## 代码

```java
class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
```

# 33.搜索旋转排序数组

## 代码

```java
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
```

# 34.在排序数组中查找元素的第一个和最后一个位置

## 代码

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        } 
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

```

# 38.外观数列

## 代码

```java
class Solution {
    public String countAndSay(int n) {
        String num = String.valueOf(n);
        StringBuilder buffer = new StringBuilder();
        buffer.append(1);
        for(int i = 1; i < n; i++){
            buffer = getString(buffer);
        }
        return buffer.toString();
    }

    public StringBuilder getString(StringBuilder buffer){
        int n = buffer.length();
        int sum = 1;
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(i < n - 1){
                if(buffer.charAt(i)==buffer.charAt(i + 1)){
                    sum++;
                }else{
                    temp.append(sum);
                    temp.append(buffer.charAt(i));
                    sum = 1;
                }
            }else{
                temp.append(sum);
                temp.append(buffer.charAt(i));
            }
        }
        return temp;
    }
}
```

# 39.组合总数

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates[0]>target){
            return resList;
        }
        reBack(resList, new ArrayList<Integer>(), 0, target, 0, candidates.length, candidates);
        return resList;
    }

    public void reBack(List<List<Integer>> resList, List<Integer>temp, int start, int target, int sum, int n, int[] candidates){
        for(int i = start; i < n; i++){
            if(sum + candidates[i] > target){
                return;
            }
            temp.add(candidates[i]);
            if(sum + candidates[i] == target){
                resList.add(temp);
                return;
            }
            reBack(resList, new ArrayList<Integer>(temp), i, target, sum + candidates[i], n, candidates);
            temp.remove(temp.size() - 1);
        }
    }
}
```

# 40.组合总数Ⅱ

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates[0]>target){
            return resList;
        }
        reBack(resList, new ArrayList<Integer>(), 0, target, 0, candidates.length, candidates);
        return resList;
    }

    public void reBack(List<List<Integer>> resList, List<Integer>temp, int start, int target, int sum, int n, int[] candidates){
        for(int i = start; i < n; i++){
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            if(sum + candidates[i] > target){
                return;
            }
            temp.add(candidates[i]);
            if(sum + candidates[i] == target){
                resList.add(temp);
                return;
            }
            reBack(resList, new ArrayList<Integer>(temp), i + 1, target, sum + candidates[i], n, candidates);
            temp.remove(temp.size() - 1);
        }
    }
}
```

# 41.缺失的第一个正整数

## 代码

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int range = n + 1;
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0){
                nums[i] = range;
            }
        }
        for(int i = 0; i < n; i++){
            int num = Math.abs(nums[i]);
            if(num < range){
                nums[num - 1] = -1 * Math.abs(nums[num - 1]);
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return range;
    }
}
```

# 42.接雨水

## 代码

```java
class Solution {
    public int trap(int[] height) {
        int n = height.length, res = 0;
        int[]left = new int[n];
        int []right = new int[n];
        for(int i = 1; i < n - 1; i++){
            left[i] = Math.max(height[i - 1], left[i - 1]);
        }
        for(int i = n - 2; i >= 0; i--){
            right[i] = Math.max(height[i + 1], right[i + 1]);
        }
        for(int i = 1; i < n - 1; i++){
            int min = Math.min(left[i], right[i]);
            if(min > height[i]){
                res += (min - height[i]);
            }
        }
        return res;
    }
}
```

# 43.字符串相乘

## 代码

```java

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        if(n > m){
            String tempStr = num2;
            num2 = num1;
            num1 = tempStr;
            m = num1.length();
            n = num2.length();
        }
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
```

# 44.通配符匹配

## 代码

```java
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][]dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 0; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j - 1) == '*'){
                    dp[i][j] |= dp[i][j - 1];
                    if(i > 0){
                        dp[i][j] |= (dp[i - 1][j] | dp[i - 1][j - 1]);
                    }
                    
                }else{
                    if(isCharMatch(s, p, i, j)){
                        dp[i][j] = dp[i - 1][ j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean isCharMatch(String s, String p, int i, int j){
        if(i == 0){
            return false;
        }
        if(p.charAt(j - 1) == '?'){
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
```

# 45.跳跃游戏

## 代码

```java
class Solution {
    public int jump(int[] nums) {
        int end = nums.length - 1;
        int step = 0;
        while(end > 0){
            for(int i = 0; i < end; i++){
                if(i + nums[i] >= end){
                    end = i;
                    step++;
                }
            }
        }
        return step;
    }
}
```

# 46.全排列

## 代码

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        reBuilde(resList, new LinkedHashSet<Integer>(), 0, nums.length, nums);
        return resList;
    }

    public void reBuilde(List<List<Integer>> resList, LinkedHashSet<Integer> temp, int index, int n, int[] nums){
        if(index == n){
            resList.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < n; i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            reBuilde(resList, new LinkedHashSet<Integer>(temp), index + 1, n, nums);
            temp.remove(nums[i]);
        }
    }
}
```

# 47.全排列Ⅱ

## 代码

```java
class Solution {
    private boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        vis = new boolean[n];
        Arrays.sort(nums);
        List<List<Integer>> reList = new ArrayList<>();
        reBuild(reList, new ArrayList<Integer>(), 0, n, nums);
        return reList;
    }

    public void reBuild(List<List<Integer>> resList, ArrayList<Integer> temp, int index, int n, int[]nums){
        if(index == n){
            resList.add(temp);
            return;
        }
        for(int i = 0; i < n; i++){
            if(vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])){
                continue;
            }
            temp.add(nums[i]);
            vis[i] = true;
            reBuild(resList, new ArrayList<Integer>(temp), index + 1, n, nums);
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }
}
```

# 48.旋转图像

## 代码

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
```

# 49.字母异位词

## 代码

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
```

# 54.螺旋矩阵

给你一个 `m` 行 `n` 列的矩阵 `matrix` ，请按照 **顺时针螺旋顺序** ，返回矩阵中的所有元素。

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int sum = m * n;
        boolean[][]vis = new boolean[m][n];
        int [][]cross = new int[][]{{0,1},{1,0},{0,-1},{-1, 0}};
        int crossIndex = 0;
        int row = 0, col = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < sum; i++){
            res.add(matrix[row][col]);
            vis[row][col] = true;
            int nextRow = row + cross[crossIndex][0], nextCol = col + cross[crossIndex][1];
            if(nextRow<0 || nextRow >= m || nextCol < 0 || nextCol >= n || vis[nextRow][nextCol]){
                crossIndex = (crossIndex + 1) % 4;
            }
            row += cross[crossIndex][0];
            col += cross[crossIndex][1];
        } 
        return res;
    }
}
```

# 55.跳跃游戏

```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return true;
        }
        int end = n - 1;
        while(end > 0){
            int index = -1;
            for(int i = 0; i < end; i++){
                if(i + nums[i] >= end){
                    index = i;
                    break;
                }
            }
            if(index == -1){
                return false;
            }
            end = index;
        }
        return true;
    }
}
```

