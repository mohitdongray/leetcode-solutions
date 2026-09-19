class Solution {
    int solve(int[] nums,int target, int s, int e){

        if(s > e) return -1;

        int mid = s + (e - s) / 2;

        if(target == nums[mid]) return mid;

        if(target < nums[mid]){
            return solve(nums, target, s, mid-1);

        }else{
            return solve(nums, target, mid+1, e);
        }
    }
    public int search(int[] nums, int target) {
        return solve(nums, target, 0, nums.length - 1);
    }
}