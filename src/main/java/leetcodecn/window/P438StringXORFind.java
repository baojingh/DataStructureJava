
/*
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。


示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 

提示:

1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母

 */



 /*
 根据题目要求，我们需要在字符串 s 寻找字符串 p 的异位词。因为字符串 p 的异位词的长度一定与字符串 p 的长度相同，所以我们可以在字符串 s 中构造一个长度为与字符串 p 的长度相同的滑动窗口，并在滑动中维护窗口中每种字母的数量；当窗口中每种字母的数量与字符串 p 中每种字母的数量相同时，则说明当前窗口为字符串 p 的异位词。


 当字符串 s 的长度小于字符串 p 的长度时，字符串 s 中一定不存在字符串 p 的异位词。但是因为字符串 s 中无法构造长度与字符串 p 的长度相同的窗口，所以这种情况需要单独处理。


 https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/1123971/zhao-dao-zi-fu-chuan-zhong-suo-you-zi-mu-xzin/

 
 */
package leetcodecn.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P438StringXORFind {
    // s = "cbaebabacd", p = "abc"

    public static void main(String[] args) {
      // String s = "cbaebabacd";
      // String p = "abc";

      // String s = "abab";
      // String p = "ab";

      // String s = "abaac";
      // String p = "aa";

      // String s = "aaab";
      // String p = "aa";

      String s = "axbzcde";
      String p = "xz";

      List<Integer> res = findAnagrams(s, p);
      System.out.println(res.toString());
    }

    public static  List<Integer> findAnagrams(String s, String p) {
      List<Integer> resultList =  new ArrayList<Integer>();
      int sLen = s.length();
      int pLen = p.length();

      int[] pArr = new int[26];
      int[] sArr = new int[26];

        // 步骤2：统计p中每个字符的出现次数
        // 例如：p = "abc" -> pCount['a'-'a']=1, pCount['b'-'a']=1, pCount['c'-'a']=1
      for(int i = 0; i < pLen;i++) {
        pArr[p.charAt(i) - 'a']++;
        sArr[s.charAt(i) - 'a']++;
      }
      if(Arrays.equals(pArr, sArr)){
        resultList.add(0);
      }
      for (int i = 0; i < sLen - pLen; i++) {
        sArr[s.charAt(i) - 'a']--;
        sArr[s.charAt(i + pLen) - 'a']++;
        if(Arrays.equals(sArr, pArr)) {
          resultList.add(i + 1);
        }
      }
      return resultList;
    }

}
