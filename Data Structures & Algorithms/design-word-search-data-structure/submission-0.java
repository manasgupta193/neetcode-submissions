class WordDictionary {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode curr) {
        // Base Case: reached the end of the search string
        if (index == word.length()) {
            return curr.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            // Wildcard: Try all 26 possible children
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    if (dfs(word, index + 1, curr.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            // Standard: Follow the specific character branch
            int idx = c - 'a';
            TrieNode next = curr.children[idx];
            if (next == null) return false;
            return dfs(word, index + 1, next);
        }
    }
}