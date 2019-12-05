/**
 * 两数之和 时间or空间
 * https://leetcode.com/problems/two-sum/
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i =0 ;i<nums.length;i++){
            for (int j=i+1;j< nums.length;j++){
                if(nums[i]==target-nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
