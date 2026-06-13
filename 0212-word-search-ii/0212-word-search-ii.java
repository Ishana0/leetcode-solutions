class Solution {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    List<String> result = new ArrayList<>();

    public List<String> findWords( char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                    dfs(board, row, col, root);
            }
        }

        return result;
    }

    private TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for(String word : words) {
            TrieNode current = root;
            for(char ch : word.toCharArray()) {
                int index = ch - 'a';

                if(current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.word = word;
        }

        return root;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }

        char ch = board[row][col];

        if(ch == '#') {
            return;
        }

        TrieNode next = node.children[ch - 'a'];

        if(next == null) {
            return;
        }

        if(next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        board[row][col] = '#';

        dfs(board,row+1,col,next);
        dfs(board,row-1,col,next);
        dfs(board,row,col+1,next);
        dfs(board,row,col-1,next);

        board[row][col] = ch;
    }
}