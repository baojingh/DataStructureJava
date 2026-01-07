package leetcodecn.window;

/*
给你字符串 s 和整数 k 。
请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
英文中的 元音字母 为（a, e, i, o, u）。


示例 1：
输入：s = "abciiidef", k = 3
输出：3
解释：子字符串 "iii" 包含 3 个元音字母。

示例 2：
输入：s = "aeiou", k = 2
输出：2
解释：任意长度为 2 的子字符串都包含 2 个元音字母。

示例 3：
输入：s = "leetcode", k = 3
输出：2
解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。

示例 4：
输入：s = "rhythms", k = 4
输出：0
解释：字符串 s 中不含任何元音字母。

示例 5：
输入：s = "tryhard", k = 4
输出：1
 

提示：

1 <= s.length <= 10^5
s 由小写英文字母组成
1 <= k <= s.length
 */
public class P1456maxVowels {

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;

        int res = maxVowels(s, k);
        System.out.println(res);

    }

    // s = "leetcode", k = 3
    public static int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int maxCount = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isIt = arr[i] == 'a' || arr[i] == 'e'
                    || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u';

            // 初始化窗口，填充窗口，确保窗口内的元素数量是k
            if (isIt) {
                count++;
            }
            // 窗口大小不足 k，尚未形成第一个窗口
            if (i < k - 1) {
                continue;
            }

            // 处理元音数量
            maxCount = Math.max(maxCount, count);

            // 移除窗口最左边元素
            boolean isItAgain = arr[i - k + 1] == 'a' || arr[i] == 'e'
                    || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u';
            if (isItAgain) {
                count--;
            }

        }

        return maxCount;
    }

}
