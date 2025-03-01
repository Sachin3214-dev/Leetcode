class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(dp[i] , -1);
        }
        int ans = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == '1'){
                    int ca = solve(matrix , i  ,j , m , n , dp);
                    // System.out.println(i+" "+j+" "+ca);
    ans = Math.max(ans , ca );
                }
            }
        }
    return ans*ans;
    }

    public int solve(char[][] mat , int i , int j , int m , int n , int[][] dp){
       
        if(i == m || j == n)return 0;
        if(mat[i][j] == '0') return 0;

        if(dp[i][j] != -1)return dp[i][j];

        int r = solve(mat , i , j+1 , m , n , dp);
        int dia = solve(mat , i+1 , j+1 , m , n , dp);
        int down = solve(mat , i+1 , j , m ,n , dp);

        int ans  = 1 + Math.min(r , Math.min(dia , down));
        
        dp[i][j] = ans;
        return dp[i][j];

    }
}