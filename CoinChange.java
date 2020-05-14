/**
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * */

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int amount = 4;

        int[][] dp = new int[coins.length+1][amount+1];

        System.out.println(dp.length);
        for(int i = 0 ; i< dp.length;i++){
            dp[i][0] = 1;
        }

        for(int i = 0 ; i<= amount;i++){
            dp[0][i] = 0;
        }
        dp[0][0] = 1;

        for(int i = 1; i < dp.length;i++){
            for(int j = 1 ; j <= amount;j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }

            }
        }

        System.out.println(dp[dp.length-1][amount]);


    }
}
