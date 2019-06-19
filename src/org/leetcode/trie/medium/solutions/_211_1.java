/**
 * 
 */
package org.leetcode.trie.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _211_1 {

}

class WordDictionary {

	public class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public String word = "";
	}

	public TrieNode dictionary;

	/** Initialize your data structure here. */
	public WordDictionary() {
		this.dictionary = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {

		TrieNode node = dictionary;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.word = word;

	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return match(word.toCharArray(), 0, dictionary);
	}

	private boolean match(char[] chs, int k, TrieNode node) {
		if (k == chs.length)
			return !node.word.equals("");
		if (chs[k] != '.') {
			return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
		} else {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null) {
					if (match(chs, k + 1, node.children[i])) {
						return true;
					}
				}
			}
		}
		return false;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */