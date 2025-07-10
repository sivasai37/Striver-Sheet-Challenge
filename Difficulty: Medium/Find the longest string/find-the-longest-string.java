class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    String word = "";
}

class Solution {
    public String longestString(String[] words) {
        TrieNode root = new TrieNode();
        
        // Insert all words into the trie
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.isEnd = true;
            curr.word = word;
        }

        // DFS traversal
        return dfs(root, "");
    }

    private String dfs(TrieNode node, String best) {
        String res = best;

        for (int i = 0; i < 26; i++) {
            TrieNode child = node.children[i];
            if (child != null && child.isEnd) {
                String candidate = dfs(child, child.word);
                
                // update result only if:
                // - longer word
                // - or same length but lexicographically smaller
                if (candidate.length() > res.length() ||
                   (candidate.length() == res.length() && candidate.compareTo(res) < 0)) {
                    res = candidate;
                }
            }
        }

        return res;
    }
}
