public static void reverseWordsInPlace(char[] chars) {
	reverseChars(chars, 0, chars.length - 1);
	
	int start = 0;
	for (int i = 0; i < chars.length; i++){
		if (chars[i] == ' ') {
			reverseChars(chars, start, i - 1);
			start = i + 1;
		} else if (i == chars.length - 1) {
			reverseChars(chars, start, i);
		}
	}
}

public static void reverseChars(char[] chars, int start, int end) {
	if (start >= end) 
		return;
	
	for (int i = start; i <= (start + end) / 2; i++) {
		char temp = chars[i];
		chars[i] = chars[start + end - i];
		chars[start + end - i] = temp;
	}
}