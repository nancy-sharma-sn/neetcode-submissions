class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] result = new int[n];
        int greater =0;

        for(int i=0;i<n;i++){
            greater =0;
            for(int j=i+1;j<n;j++){
                if(temperatures[i]<temperatures[j]){
                    result[i]++;
                    greater = temperatures[j];
                    break;
                } else if(temperatures[i]>=temperatures[j]){
                    result[i]++;
                }
                if(j==(n-1)&& greater==0){
                    result[i]=0;        
                }
            }
        }
        return result;        
    }
}
