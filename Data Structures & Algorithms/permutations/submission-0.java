class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultlist = new ArrayList<>();
        backtrack(resultlist, new ArrayList<>(), nums);
        return resultlist;
        
    }

    public void backtrack(List<List<Integer>> resultlist, ArrayList<Integer> templist, int[] nums){
        if(templist.size() == nums.length){
            resultlist.add(new ArrayList<>(templist));
            return;
        }
        for(int number: nums){
            if(templist.contains(number)){
                continue;
            }
            templist.add(number);
            backtrack(resultlist, templist, nums);
            templist.remove(templist.size()-1);
        }
    }
}
