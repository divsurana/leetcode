/**
 * 
 */
package org.leetcode.math.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _537_1 {
	public String complexNumberMultiply(String a, String b) {
		String[] aArr = a.split("\\+");
		String[] bArr = b.split("\\+");
		int aReal = Integer.parseInt(aArr[0]);
		int aImag = Integer.parseInt(aArr[1].replace("i", ""));
		int bReal = Integer.parseInt(bArr[0]);
		int bImag = Integer.parseInt(bArr[1].replace("i", ""));
		int realPart = (aReal * bReal) - (aImag * bImag);
		int imagPart = (aReal * bImag) + (aImag * bReal);

		return realPart + "+" + imagPart + "i";
	}
}
