class Solution {
    public int firstStableIndex(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int minNum = Integer.MAX_VALUE;
            int maxNum = nums[0];
            for (int j = 0; j < i; j++) {
                maxNum = Math.max(maxNum, nums[j]);
            }
            for (int l = i; l <= nums.length - 1; l++) {
                minNum = Math.min(minNum, nums[l]);
            }
            if (maxNum - minNum <= k) {
                return i;
            }
        }
        return -1;
    }
}