/**
 * 
 */
package org.leetcode.hashtable.medium.solutions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author divyesh_surana
 *
 */
public class _535_2 {

	private Map<String, String> mapping = new HashMap<>();
	private Map<String, String> reverseMapping = new HashMap<>();
	String tinyDomain = "http://tinyurl.com/";
	List<Character> allCharacters = "abcdefghijklmnopqrstuvwxyz0123456789".chars() // IntStream
			.mapToObj(e -> (char) e) // Stream<Character>
			.collect(Collectors.toList());

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String tinyUrl;
		if (!reverseMapping.keySet().contains(longUrl)) {
			String hashcode;
			do {
				Collections.shuffle(allCharacters);
				hashcode = allCharacters.subList(0, 6).stream().map(String::valueOf).collect(Collectors.joining());
			} while (mapping.keySet().contains(hashcode));
			tinyUrl = tinyDomain + hashcode;
			mapping.put(tinyUrl, longUrl);
			reverseMapping.put(longUrl, tinyUrl);
		} else {
			tinyUrl = reverseMapping.get(longUrl);
		}

		return tinyUrl;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return mapping.get(shortUrl);
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));