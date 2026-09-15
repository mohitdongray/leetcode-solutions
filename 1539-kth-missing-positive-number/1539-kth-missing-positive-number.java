class Solution {
    public int findKthPositive(int[] arr, int k) {
        int curr = 1;
        int i = 0;

        while (k > 0) {
            if (i < arr.length && curr == arr[i]) {
                curr++;
                i++;
            } else {
                k--;
                curr++;
            }
        }
        return curr - 1;
    }
}