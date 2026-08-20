class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int len1 = 1;
        int len2 = 1;

        for (int i = 2; i < n; i++) {

            if (arr1[len1 - 1] > arr2[len2 - 1]) {
                arr1[len1++] = nums[i];

            } else {
                arr2[len2++] = nums[i];
            }
        }
          int[] result = new int[n];
            for (int i = 0; i < len1; i++) {
                result[i] = arr1[i];
            }
            for(int i = 0; i < len2; i++){
                result[len1 + i] = arr2[i];
            }
        return result;
    }
}
