/**
 * https://leetcode.com/problems/fibonacci-number/
 * @author xuanyu
 */
public class FibonacciSequence {
    public int fib(int N) {
        if(N == 0){
            return 0;
        }
        if(N == 1){
            return 1;
        }

        int result = 0;
        int pre = 0;
        int prev = 1;
        for(int i=2;i<=N;i++){
            result = pre+prev;
            pre = prev;
            prev = result;
        }
        return result;
    }
}
