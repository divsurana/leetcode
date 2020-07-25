/**
 * 
 */
package org.leetcode.string.easy.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class UniqueEmailAddress {
	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();

		for (String email : emails) {
			String[] split = email.split("@");
			String local = split[0];
			String domain = split[1];

			local = local.split("\\+")[0];
			local = local.replace(".", "");

			set.add(local + "@" + domain);
		}

		return set.size();
	}
}
