class Solution {
    public int maxProfit(int[] prices) {

        int i=0;
        int j= i+1;
        int profit =0;

        while(i<j && j< prices.length ){

            profit = Math.max((prices[j]-prices[i]),profit);

            if(prices[i]<prices[j]){
                j++;
            }
            else if(prices[i]>prices[j]){
                i=j;
                j++;
            }
            else{
                j++;
            }

        }
        return profit;
    }
}
