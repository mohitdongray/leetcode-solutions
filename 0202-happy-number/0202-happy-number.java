class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
              int sum = 0;
            if (set.contains(n))
                return false;
            set.add(n);
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
                   n = sum;
        }
        return true;
    }
}