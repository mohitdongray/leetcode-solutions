class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        int n = s.length();

        for(int len = k; len <= n; len++){
         String result = "";

         for(int start = 0; start <= n-len; start++){

          String temp = s.substring(start, start + len);
            int ones = 0;
            for(char ch: temp.toCharArray()){
                ones += (ch == '1') ? 1 : 0;
            } 

            if(ones == k){
                if(result.isEmpty() || temp.compareTo(result) < 0){
                    result = temp;
                }
            }
         }
         if(!result.isEmpty()){
            return result;
         }
      }
      return "";
    }
}