class Solution {
    public boolean isPalindrome(String s) {
    StringBuilder checkpalind = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isLetterOrDigit(c)) {
            checkpalind.append(Character.toLowerCase(c));
        }
    }

    String clean = checkpalind.toString();
    int n = clean.length();
    for (int i = 0, j = n - 1; i < j; i++, j--) {
        if (clean.charAt(i) != clean.charAt(j)) {
            return false;
        }
    }
    return true;
}
}
