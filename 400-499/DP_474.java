class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < l + 1; i++){
            int[] res = twoRes(strs[i - 1]);
            for (int j = m; j >= res[0]; j--){
                for (int k = n; k >= res[1]; k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j - res[0]][k - res[1]] + 1);
                }
            }
        }
        // Be careful about the direction
        // The update should be from right to left to be clean with the result

        return dp[m][n];
    }

// the twoRes function will resturn the number of 0's and 1's
    private int[] twoRes(String str){
        int[] res = new int[] {0, 0};
        for (char c: str.toCharArray()){
            if (c == '0'){
                res[0] += 1;
            }else{
                res[1] += 1;
            }
        }
        return res;
    }
}
