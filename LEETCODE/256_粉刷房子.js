/**
 * @param {number[][]} costs
 * @return {number}
 */
var minCost = function(costs) { 
    let n = costs.length;
    if(n==0)
        return 0;
    //dp[i][j]就是指i号房子刷成j色需要的钱。
    //要求是相邻的房子不可以涂相同的颜色，所以0号之后的房子都要看之前的房子刷的颜色再来算钱
    let dp = new Array();
    for(let i=0;i<n;i++){
        dp[i] = new Array();
    }
    //0号房子刷成0 1 2色要花的钱
    dp[0][0] = costs[0][0];
    dp[0][1] = costs[0][1];
    dp[0][2] = costs[0][2];
    for(let i=1;i<n;i++){
        //i号房子刷成0色，i-1号房子只能刷成1色或者2色。所以dp[i][0]就是i号房子刷成0色要的最少的钱
        dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
        //i号房子刷成1色，i-1号房子只能刷成0色或者2色。所以dp[i][1]就是i号房子刷成1色要的最少的钱
        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
        //i号房子刷成2色，i-1号房子只能刷成0色或者1色。所以dp[i][2]就是i号房子刷成2色要的最少的钱
        dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
    }
    //dp[n-1]里就存下了n-1号房子刷成0、1、2色需要的最少的钱，找到最小值返回即可
    return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
};
