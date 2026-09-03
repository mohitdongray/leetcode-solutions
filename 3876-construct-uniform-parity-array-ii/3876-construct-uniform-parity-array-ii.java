class Solution {
    public boolean uniformArray(int[] nums1) {
        
        int oddCount = 0;
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        int evenCount = 0;
        for(int num: nums1){
         if(num % 2 == 1){
            minOdd = Math.min(minOdd, num);
            oddCount++;
         }else{
            minEven = Math.min(minEven, num);
            evenCount++;
         }

        }
        if(oddCount == 0 || evenCount == 0){
            return true;
        }
        return minOdd < minEven;
    }
}