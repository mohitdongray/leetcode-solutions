class Solution {
    int m = 1_000_000_007;
    long[] last = new long[26];
    long total = 1; 
    public int distinctSubseqII(String s) {
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long prevTotal = total;

            total = (total * 2 - last[idx]) % m;
            if (total < 0) total += m;

            last[idx] = prevTotal;
        }
        return (int)((total - 1 + m) % m);
    }
}