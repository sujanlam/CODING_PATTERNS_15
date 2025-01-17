package trie;

public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("top");
        trie.insertWord("ton");
       /* trie.insertWord("bye");
        System.out.println("Has prefix: "+trie.hasPrefix("to"));
        System.out.println("Search: "+ trie.search("to"));
        System.out.println("Search: bye: "+ trie.search("bye"));
        trie.insertWord("to");
        System.out.println("Search: "+trie.search("to"));*/
        
    }

    //Insert
    public void insertWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    //Search
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    //Has prefix
    public boolean hasPrefix(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

}
