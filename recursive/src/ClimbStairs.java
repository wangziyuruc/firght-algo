/**
 * https://leetcode.com/problems/climbing-stairs/solution/
 * 非递归实现
 * @author xuanyu
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        int pre = 1;
        int prev = 2;
        for (int i = 3; i < n + 1; i++) {
            result = pre + prev;
            pre = prev;
            prev = result;
        }
        return result;
    }

    /**
     * 递归实现
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
