import java.util.Arrays;

class Solution {
    int[][] memo;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, n - 1, prefix);
    }

    private int solve(int l, int r, int[] prefix) {
        if (l >= r) {
            return 0;
        }
        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int ans = 0;
        for (int mid = l; mid < r; mid++) {
            int leftSum = prefix[mid + 1] - prefix[l];
            int rightSum = prefix[r + 1] - prefix[mid + 1];

            if (leftSum < rightSum) {
                ans = Math.max(ans, leftSum + solve(l, mid, prefix));
            } else if (rightSum < leftSum) {
                ans = Math.max(ans, rightSum + solve(mid + 1, r, prefix));
            } else {
                int takeLeft = leftSum + solve(l, mid, prefix);
                int takeRight = rightSum + solve(mid + 1, r, prefix);
                ans = Math.max(ans, Math.max(takeLeft, takeRight));
            }
        }

        memo[l][r] = ans;
        return ans;
    }
}