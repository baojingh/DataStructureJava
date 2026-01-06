package leetcodecn.window;

/*
给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。

请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。

任何误差小于 10-5 的答案都将被视为正确答案。

 

示例 1：

输入：nums = [1,12,-5,-6,50,3], k = 4
输出：12.75
解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75

示例 2：
输入：nums = [5], k = 1
输出：5.00000
 

提示：

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
 */
 /*
入：下标为 i 的元素进入窗口，窗口元素和 s 增加 nums[i]。如果 i<k−1 则重复第一步。
更新：更新答案。本题由于窗口长度固定为 k，可以统计窗口元素和的最大值 maxS，最后返回的时候再除以 k。
出：下标为 i−k+1 的元素离开窗口，窗口元素和 s 减少 nums[i−k+1]。


 */
public class P643findMaxAverage {

    public static void main(String[] args) {
        int[] arr = {1, 12, -5, -6, 50, 3};
        int k = 4;

        // int[] arr = {5};
        // int k = 1;
        // int[] arr = {1, 6, 2, 3, 5, 1, 4, 7, 5};
        // int k = 3;
        double res = findMaxAverage(arr, k);
        System.out.println(res);
    }

    public static double findMaxAverage(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        int winValue = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            winValue = winValue + tmp;
            // 初始化窗口，确保填充k个元素到窗口
            if (i < k - 1) {
                continue;
            }
            maxVal = Math.max(maxVal, winValue);
            // 从窗口删除一元素，还剩下3个，为下一次添加元素做准备
            winValue = winValue - nums[i - k + 1];
        }
        return (double) maxVal / k;
    }

}
