/**
 * https://leetcode.com/problems/reverse-integer/
 * 注意：逆转后的超出存储范围
 * @author xuanyu
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int result = 0;
        int pre = 0;
        int prev = x;
        while (prev != 0) {
            pre = prev % 10;
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && pre > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10
                    || (result == Integer.MIN_VALUE / 10 && pre < -8)) return 0;
            result = result * 10 + pre;

            prev = prev / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
