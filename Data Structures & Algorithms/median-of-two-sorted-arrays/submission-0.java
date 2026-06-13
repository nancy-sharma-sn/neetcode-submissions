class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merged = new int[nums1.length + nums2.length];
        double median =0;

int idx = 0;
for (int n : nums1) merged[idx++] = n;
for (int n : nums2) merged[idx++] = n;

Arrays.sort(merged);
int m = merged.length;
if(m % 2==0){
    median = (double)(merged[m/2]+merged[m/2 -1])/2;

}
else{
    median = merged[m/2];
}

return median;
        }
        
    }

