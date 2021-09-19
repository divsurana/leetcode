/**
 * 
 */
package org.eoplij.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 93. Restore IP Addresses -
// https://leetcode.com/problems/restore-ip-addresses/
public class ComputeAllValidIPAddresses_7_10 {
	public List<String> restoreIpAddresses_v1(String s) {
		List<String> result = new ArrayList<>();

		for (int i = 1; i < 4 && s.length() > 3; i++) {
			String first = s.substring(0, i);
			if (isValid(first)) {
				for (int j = 1; j < 4 && i + j < s.length() - 1; j++) {
					String second = s.substring(i, i + j);
					if (isValid(second)) {
						for (int k = 1; k < 4 && i + j + k < s.length(); k++) {
							String third = s.substring(i + j, i + j + k);
							String fourth = s.substring(i + j + k);
							if (isValid(third) && isValid(fourth)) {
								result.add(first + "." + second + "." + third + "." + fourth);
							}
						}
					}
				}
			}
		}

		return result;
	}

	private boolean isValid(String s) {
		boolean isValid = false;
		if (s.length() < 4) {
			if (!(s.startsWith("0") && s.length() > 1)) {
				if (Integer.parseInt(s) >= 0 && Integer.parseInt(s) < 256) {
					isValid = true;
				}
			}
		}
		return isValid;
	}

	public List<String> restoreIpAddresses_v2(String s) {
		return findNextPart(s, 0, 4, new StringBuilder(), new ArrayList<>());
	}

	private List<String> findNextPart(String s, int startIndex, int partsLeft, StringBuilder restored,
			List<String> result) {
		if (partsLeft == 0) {
			restored.setLength(restored.length() - 1);
			if (restored.length() == s.length() + 3) {
				result.add(restored.toString());
			}
			restored.append(".");
		} else {
			for (int i = 1; i < 4 && startIndex + i <= s.length() - partsLeft + 1; i++) {
				String part = s.substring(startIndex, startIndex + i);
				if (isValid(part)) {
					findNextPart(s, startIndex + i, partsLeft - 1, restored.append(part).append("."), result);
					restored.setLength(restored.length() - part.length() - 1);
				}
			}
		}
		return result;
	}
}
