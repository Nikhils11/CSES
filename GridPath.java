import java.util.*;
import java.io.*;

class GridPath{

    static int paths = 0;

    static int mod = 1000_000_007;

    public static void main(String []agrs) throws IOException{
        BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(red.readLine());
        String [][] grid = new String[n][n];
        for (int i = 0; i < n; i++){
            String [] input = red.readLine().split(" ");
            for (int j = 0; j < n; j++){
                grid[i][j] = String.valueOf(input[0].charAt(j));
            }
        }
        int [][] dp = new int[n][n];
        findingGridPath(grid, 0, 0, dp);
        System.out.println(dp[n-1][n-1]);
    }

    public static int findingGridPath(String [][] grid, int row, int col, int [][] dp){
        if (!grid[0][0].equals("*")){
            dp[0][0] = 1;
        }
        for (int i = 0; i < grid.length; i++){
          for (int j = 0; j < grid.length; j++){
              if (i - 1 >= 0 && !grid[i][j].equals("*")){
                  dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
              }
              if (j - 1 >= 0 && !grid[i][j].equals("*")){
                  dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
              }
          }
      }
      return dp[grid.length - 1][grid.length - 1];
    }
}