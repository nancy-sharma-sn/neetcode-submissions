class Solution {
    private int ROWS, COLS;
    private char[][] board;
    private List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        ROWS = board.length;
        COLS = board[0].length;
        res = new ArrayList<>();

        TrieNode root = buildTrie(words);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                backtrack(r, c, root);
            }
        }
        return res;
    }

    private void backtrack(int r, int c, TrieNode node){
        if(r<0||c<0 ||r>=ROWS||c>=COLS) return;
        char ch = board[r][c];
        if(ch =='*'|| node.children[ch-'a']==null) return;
        node = node.children[ch-'a'];

        if(node.word !=null){
            res.add(node.word);
            node.word = null;
        }

        board[r][c] ='*';
        backtrack(r+1,c,node);
        backtrack(r-1,c,node);
        backtrack(r,c+1,node);
        backtrack(r,c-1,node);
        board[r][c] = ch;
        if (isEmpty(node)) {
            TrieNode parent = node;
            // handled implicitly since parent still holds reference
        }
    }

    private TrieNode  buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode node = root;
            for(char ch: word.toCharArray()){
                int idx = ch -'a';
                if(node.children[idx]==null){
                    node.children[idx] = new TrieNode();
                }                
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
    }
     private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
