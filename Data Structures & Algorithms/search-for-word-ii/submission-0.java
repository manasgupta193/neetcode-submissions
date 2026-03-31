class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // Store the actual word at the leaf to avoid building it
    }

    public List<String> findWords(char[][] board, String[] words) {
        // 1. Build the Trie
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.word = w; 
        }

        List<String> result = new ArrayList<>();
        // 2. Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        char ch = board[r][c];
        TrieNode nextNode = node.children.get(ch);

        // Pruning: if char not in Trie, stop
        if (nextNode == null) return;

        // Check if we found a word
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // Optimization: avoid duplicates
        }

        // Backtracking: mark as visited
        board[r][c] = '#';

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length 
                && board[nr][nc] != '#') {
                dfs(board, nr, nc, nextNode, result);
            }
        }

        // Restore for other paths
        board[r][c] = ch;

        // Optimization: Prune Trie nodes that have no more children
        if (nextNode.children.isEmpty()) {
            node.children.remove(ch);
        }
    }
}