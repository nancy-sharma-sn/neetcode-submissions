class Solution {
    public int largestRectangleArea(int[] heights) {
    int maxarea = 0, n = heights.length;

    for (int i = 0; i < n; i++) {
        int smallest = heights[i];
        maxarea = Math.max(maxarea, smallest);       // single bar

        for (int j = i + 1; j < n; j++) {
            smallest = Math.min(smallest, heights[j]); // always take min
            int area = smallest * (j - i + 1);          // width = j - i + 1
            maxarea = Math.max(area, maxarea);
        }
    }
    return maxarea;
}
}
