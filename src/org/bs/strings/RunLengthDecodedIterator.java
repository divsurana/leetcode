package org.bs.strings;

class RunLengthDecodedIterator {
	int repeat;
	int i;
	String s;

	public RunLengthDecodedIterator(String s) {
		this.s = s;
		i = 0;
		int start = i;
		while (Character.isDigit(s.charAt(++i))) {
		}
		repeat = Integer.valueOf(s.substring(start, i));
	}

	public String next() {
		String c = String.valueOf(s.charAt(i));
		if (--repeat == 0 && ++i < s.length()) {
			int start = i;
			while (Character.isDigit(s.charAt(++i))) {
			}
			repeat = Integer.valueOf(s.substring(start, i));
		}
		return c;
	}

	public boolean hasnext() {
		return i < s.length();
	}
}