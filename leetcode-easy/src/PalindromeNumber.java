/**
 * https://leetcode.com/problems/palindrome-number/
 * 回文数字
 * 空间复杂度O(1) 边界条件,x数字的奇数位还是偶数位  举例 121 11
 * @author xuanyu
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int revertedNumber = 0;
        while (x>revertedNumber){
            revertedNumber = revertedNumber*10+x%10;
            x=x/10;
        }
        return x==revertedNumber || x==revertedNumber/10;

    }
    public static boolean isPalindrome2(int x) {
        if(x<0){
            return false;
        }
        if(x==0){
            return true;
        }
        int j=0;
        int tmp =x;
        while (tmp!=0){
            tmp=tmp/10;
            j++;
        }
        int[] num = new  int[j];
        int i=0;
        while (x!=0){
            num[i]=x%10;
            x=x/10;
            i++;
        }
        int m=0;
        int n=num.length-1;
        while (n!=m && n>=m){
            if(num[n]!=num[m]){
                return false;
            }
            n--;
            m++;
        }
        return true;
    }
    public static void main(String[] args) {
        isPalindrome(121);
    }

}
