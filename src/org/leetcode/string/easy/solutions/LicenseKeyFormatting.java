/**
 * 
 */
package org.leetcode.string.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
		S = S.replace("-", "");
		S = S.toUpperCase();
		String limiter = "";

		StringBuilder sb = new StringBuilder();
		int start = S.length() % K;
		if (start != 0) {
			sb.append(S.substring(0, start));
			limiter = "-";
		}

		for (int i = start; i < S.length(); i += K) {
			sb.append(limiter).append(S.substring(i, i + K));
			limiter = "-";
		}
		return sb.toString();
	}
}
