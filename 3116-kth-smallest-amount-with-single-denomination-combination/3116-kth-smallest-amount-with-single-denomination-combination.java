class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int minCoin = Integer.MAX_VALUE;
        for (int c : coins) minCoin = Math.min(minCoin, c);

        // Binary search bounds: the k-th smallest is at most minCoin * k
        long low = 1;
        long high = (long) minCoin * k;

        // Precompute LCM and inclusion-exclusion sign for all non-empty subsets
        int totalMasks = 1 << n;
        long[] lcmVal = new long[totalMasks];
        int[] sign = new int[totalMasks];
        Arrays.fill(lcmVal, 1);

        for (int mask = 1; mask < totalMasks; mask++) {
            int lsb = mask & -mask;
            int idx = Integer.numberOfTrailingZeros(lsb);
            int prev = mask ^ lsb;

            if (prev == 0) {
                lcmVal[mask] = coins[idx];
            } else {
                long a = lcmVal[prev];
                long b = coins[idx];
                long gcd = gcd(a, b);
                // Cap the LCM to avoid overflow. high is a safe upper bound.
                long lcm = a / gcd * b;
                if (lcm > high) lcm = high + 1;
                lcmVal[mask] = lcm;
            }
            sign[mask] = (Integer.bitCount(mask) % 2 == 1) ? 1 : -1;
        }

        while (low < high) {
            long mid = (low + high) >>> 1;
            long cnt = countUpTo(mid, lcmVal, sign, totalMasks);
            if (cnt >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Counts numbers <= x that are multiples of at least one coin (union of multiples)
    private long countUpTo(long x, long[] lcmVal, int[] sign, int totalMasks) {
        long count = 0;
        for (int mask = 1; mask < totalMasks; mask++) {
            long l = lcmVal[mask];
            if (l > x) continue;
            count += sign[mask] * (x / l);
        }
        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}