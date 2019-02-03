package daily;


import java.util.HashSet;
import java.util.Set;

public class Problem_11_Trie {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.addWord("boat");

        boolean present = trie.isWordPresent("boat");
        System.out.println(present);

        trie.addWord("body");
        Set<String> words = trie.getWordsWithPrefix("b");
        System.out.println(words);
    }

    private static class Trie {
        TrieNode root = new TrieNode();

        public void addWord(String word) {

            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char nextChar = word.charAt(i);
                if (!node.containsKey(nextChar)) {
                    node.put(nextChar);
                }
                node = node.get(nextChar);
            }
            node.isEnd = true;
        }

        public boolean isWordPresent(String word) {

            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                node = node.get(word.charAt(i));
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }

        public Set<String> getWordsWithPrefix(String prefx) {

            TrieNode node = root;
            for (int i = 0; i < prefx.length(); i++) {
                node = node.get(prefx.charAt(i));
                if (node == null) {
                    return null;
                }
            }

            HashSet<String> allWords = new HashSet<>();
            getAllWordsStartingWith(node, new StringBuilder(prefx), allWords);

            return allWords;
        }

        private void getAllWordsStartingWith(TrieNode node, StringBuilder prefix, Set<String> words) {

            if (node.isEnd) {
                words.add(prefix.toString());
            }

            for (int i = 0; i < 26; i++) {
                if (node.links[i] != null) {
                    prefix.append((char) ('a' + i));
                    getAllWordsStartingWith(node.links[i], prefix, words);
                    prefix.deleteCharAt(prefix.length() - 1);
                }
            }
        }
    }

    private static class TrieNode {

        private TrieNode[] links = new TrieNode[26];
        private boolean isEnd = false;

        public TrieNode() {
        }

        public void put(char data) {
            links[data - 'a'] = new TrieNode();
        }

        public boolean containsKey(char data) {
            return links[data - 'a'] != null;
        }

        public TrieNode get(char data) {
            return links[data - 'a'];
        }
    }
}
