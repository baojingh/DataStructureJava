//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


/*


用两个指针 left 和 right 表示窗口的左右边界。

用一个集合（比如 HashSet 或 HashMap）来记录窗口内已经存在的字符。
右指针向右移动，将字符加入窗口：
如果当前字符没有出现过，就扩大窗口。
如果当前字符已经出现过，就移动左指针，直到移除掉那个重复的字符。

算法步骤
初始化 left = 0，right = 0，最大长度 maxLen = 0。
用一个 HashMap<Character, Integer> 来存储字符和它的最新索引。
遍历字符串：
如果当前字符已经在窗口中出现过（即在 map 中且索引 >= left），则更新 left 到重复字符的下一个位置。
更新当前字符在 map 中的位置（存储 right+1 或 right 都可以，看实现习惯）。
计算当前窗口长度 right - left + 1，并更新 maxLen。
返回 maxLen。


0 1 2 3 4 5
p w w k e w

初始状态
left = 0, maxLen = 0, map = {}

right = 0 (字符 'p')
'p' 不在 map 中 → 更新 map {'p':0}
窗口长度 = 0 - 0 + 1 = 1 → maxLen = 1

right = 1 (字符 'w')
'w' 不在 map 中 → 更新 map {'p':0, 'w':1}
窗口长度 = 1 - 0 + 1 = 2 → maxLen = 2

right = 2 (字符 'w')
'w' 在 map 中且位置 1 >= left=0 → 更新 left = 1 + 1 = 2
更新 map {'p':0, 'w':2}
窗口长度 = 2 - 2 + 1 = 1 → maxLen = 2

right = 3 (字符 'k')
'k' 不在 map 中 → 更新 map {'p':0, 'w':2, 'k':3}
窗口长度 = 3 - 2 + 1 = 2 → maxLen = 2

right = 4 (字符 'e')
'e' 不在 map 中 → 更新 map {'p':0, 'w':2, 'k':3, 'e':4}
窗口长度 = 4 - 2 + 1 = 3 → maxLen = 3

right = 5 (字符 'w')
'w' 在 map 中且位置 2 >= left=2 → 更新 left = 2 + 1 = 3
更新 map {'p':0, 'w':5, 'k':3, 'e':4}
窗口长度 = 5 - 3 + 1 = 3 → maxLen = 3

最终结果：3


0 1 2 3 4 5
p w w k e w

*/


package leetcodecn.window;

import java.util.HashMap;
import java.util.Map;

public class P3LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    
  }

  public int lengthOfLongestSubstring(String s) { 
    Map<Character, Integer> map  = new HashMap<Character, Integer>();

    int left = 0;
    int maxLen = 0;
    for(int right =0; right < s.length(); right++) {
      Integer ele = map.get(s[right]);
      



    }




    return 0;
  }




}
