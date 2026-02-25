package leetcodecn.window;

public class P3090MaximumLengthSubstring {

    /**
     * 3090. 每个字符最多出现两次的最长子字符串
     * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。
     * <p>
     * 示例 1：
     * 输入： s = "bcbbbcba"
     * 输出： 4
     * <p>
     * 解释：
     * 以下子字符串长度为 4，并且每个字符最多出现两次："bcbbbcba"。
     * 示例 2：
     * 输入： s = "aaaa"
     * 输出： 2
     * 解释：
     * 以下子字符串长度为 2，并且每个字符最多出现两次："aaaa"。
     * <p>
     * 提示：
     * <p>
     * 2 <= s.length <= 100
     * s 仅由小写英文字母组成。
     *
     * @param args
     */




    public static void main(String[] args) {
//        String s = "aaa";
//        String s = "abc";
        String s = "abbbac";
        int res = maximumLengthSubstring(s);
        System.out.println(res);
    }

    public static int maximumLengthSubstring(String s) {
        char[] charArray = s.toCharArray();
        int right = 0;
        int left = 0;
        int res = 0;
        int[] cnt = new int[128];

        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            cnt[c]++;
            while (cnt[c] > 2) {
                cnt[charArray[left]]--;
                // 顺序不能颠倒
                left = left + 1;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }


}
