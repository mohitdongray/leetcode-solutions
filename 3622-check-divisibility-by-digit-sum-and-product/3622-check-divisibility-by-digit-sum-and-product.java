class Solution {
    public boolean checkDivisibility(int n) {

        String s  = String.valueOf(n);
        int sum = 0;
        int product = 1;
        for(char c: s.toCharArray()){
         int digit = c - '0';  
          sum += digit;
          product *= digit;
        }

          int divisor = sum + product;
        if (divisor == 0) return false;   
        return n % divisor == 0;

    }
}