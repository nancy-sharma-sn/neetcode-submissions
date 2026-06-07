class Solution {
    public int maxArea(int[] heights) {

        int i=0;
        int j=heights.length-1;
        int Area =0;

        while(i<j){
            Area = Math.max(((j-i)*Math.min(heights[i],heights[j])),Area);
            if(heights[i]<heights[j]){
                i++;
            }
            else if(heights[i]>heights[j]){
                j--;
            }
            else{
                i++;
                j--;
            }
        }

        return Area;
    }
}
