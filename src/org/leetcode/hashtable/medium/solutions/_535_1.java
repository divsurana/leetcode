/**
 * 
 */
package org.leetcode.hashtable.medium.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyesh_surana
 *
 */
public class _535_1 {

	private Map<String, String> mapping = new HashMap<>();
	String tinyDomain = "http://tinyurl.com/";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String hashcode = String.valueOf(longUrl.hashCode());
		String tinyUrl = tinyDomain + hashcode;

		mapping.put(tinyUrl, longUrl);
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