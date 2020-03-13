class Solution {
    public int coinChange(int[] coins, int amount) {
      int max = amount + 1;
      //dp[i]是指多少个硬币可以组成金额i
      //dp[i] = min(dp[i-cj]+1 ,dp[i])是取【上一个金额最小的硬币数+1，amount的硬币数】中较小的那一个
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, max);
      dp[0] = 0;
      for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
          if (coins[j] <= i) {
            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
          }
        }
      }
      return dp[amount] > amount ? -1 : dp[amount];
    }
  }