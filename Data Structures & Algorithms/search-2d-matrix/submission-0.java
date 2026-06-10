class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int[]row: matrix){
            int begin = row[0];
            int end = row[row.length -1];
            if(target>= begin && target<=end){
                for(int i=0;i<row.length;i++){
                    if(row[i]==target){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
