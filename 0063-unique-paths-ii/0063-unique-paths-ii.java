class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        // return memorization(obstacleGrid, dp, m -1, n- 1);
        // return tabulation(obstacleGrid);
        return spaceOptimization(obstacleGrid);
    }
    public int memorization(int[][] arr, int[][] dp, int i, int j){
        if (i >= 0 && j >= 0 && arr[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        int left = memorization(arr, dp, i, j - 1);
        int top = memorization(arr, dp, i - 1, j);
        return dp[i][j] = left + top;
    }
    public int tabulation(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int left = 0, top = 0;
                    if(i > 0) left = dp[i - 1][j];
                    if(j > 0) top = dp[i][j - 1];
                    dp[i][j] = left + top;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    public int spaceOptimization(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];
        for (int i = 0; i < m; i++){
            int[] curr = new int[n];
            for (int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1) curr[j] = 0;
                else if(i == 0 && j == 0) curr[j] = 1;
                else{
                    int left = 0, top = 0;
                    if(i > 0) left = prev[j];
                    if(j > 0) top = curr[j - 1];
                    curr[j] = left + top;
                }
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}
