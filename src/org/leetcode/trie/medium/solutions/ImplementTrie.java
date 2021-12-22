/**
 * 
 */
package org.leetcode.trie.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class ImplementTrie {
	class Trie {
		Trie[] trie;
		boolean isWord;

		public Trie() {
			this.trie = new Trie[26];
			this.isWord = false;
		}

		public void insert(String word) {
			Trie t = this;
			for (char c : word.toCharArray()) {
				if (t.trie[c - 'a'] == null) {
					t.trie[c - 'a'] = new Trie();
				}
				t = t.trie[c - 'a'];
			}
			t.isWord = true;
		}

		public boolean search(String word) {
			Trie t = this;
			for (char c : word.toCharArray()) {
				if (t.trie[c - 'a'] == null) {
					return false;
				}
				t = t.trie[c - 'a'];
			}
			return t.isWord;
		}

		public boolean startsWith(String prefix) {
			Trie t = this;
			for (char c : prefix.toCharArray()) {
				if (t.trie[c - 'a'] == null) {
					return false;
				}
				t = t.trie[c - 'a'];
			}
			return true;
		}
	}
}
