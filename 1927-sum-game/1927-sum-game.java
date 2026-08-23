class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0;
        int qLeft = 0, qRight = 0;

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                if (i < n / 2) qLeft++;
                else qRight++;
            } else {
                int digit = c - '0';
                if (i < n / 2) leftSum += digit;  
                else rightSum += digit;            
            }
        }

        int totalQ = qLeft + qRight;
        if (totalQ % 2 == 1) return true;   

        int leftValue = 2 * leftSum + 9 * qLeft;
        int rightValue = 2 * rightSum + 9 * qRight;

        return leftValue != rightValue;   
    }
}