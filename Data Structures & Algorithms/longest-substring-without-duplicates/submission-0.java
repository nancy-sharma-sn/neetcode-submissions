class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> maxlen = new HashSet<>();
        int max =0;
        int left =0;
        for(int right=0;right<s.length();right++){
            while(maxlen.contains(s.charAt(right))){
                maxlen.remove(s.charAt(left));
                left++;
            }
            maxlen.add(s.charAt(right));
            max = Math.max(max,right-left+1);
        }
        return max;
}
}
