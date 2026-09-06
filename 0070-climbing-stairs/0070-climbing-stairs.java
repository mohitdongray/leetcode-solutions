class Solution {
    int[] t;

    int solve(int n) {
          if (n < 0) return 0;
        if (n == 0) return 1;
        if (t[n] != -1) return t[n];

        int oneStep = solve(n - 1);
        int twoStep = solve(n - 2);

        return t[n] = oneStep + twoStep;
    }

    public int climbStairs(int n) {
        t = new int[n + 1];
        Arrays.fill(t, -1);
        return solve(n);
    }
}