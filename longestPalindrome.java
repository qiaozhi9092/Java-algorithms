// Time O(n^2) and space is also O(n^2)
public static String longestPalindrome (String str) {
	char[] s = str.toCharArray();
	int n = s.length;
	int start = 0;
	int end = 0;
	int maxLen = 1;
	
	// P(i,j) = true iff s_i .. s_j is a palindrome
	boolean[][] table = new boolean[n][n];
	
	
	// Base case
	// P(i, i) = true
	for (int i = 0; i < n; i++) {
		table[i][i] = true;
	}
	
	// P(i, i + 1) = true if s[i] == s[i + 1]
	for (int i = 0; i < n - 1; i++) {
		if (s[i] == s[i + 1]) {
			table[i][i + 1] = true;
			start = i;
			end = i + 1;
			maxLen = 2;
		}
	}

	for (int len = maxLen + 1; len <= n; len++) {
		for (int i = 0; i < n - len + 1; i++) {
			int j = i + len - 1;
			table[i][j] = s[i] == s[j] && table[i + 1][j - 1];
			if (table[i][j] && (j - i + 1) > maxLen) {
				maxLen = j - i + 1;
				start = i;
				end = j;
			}
		}
	}

	return str.substring(start, end + 1);
}

// Time O(n^2) but space is O(1)
public static String longestPalindrome2 (String s) {
	int n = s.length();
	if (n == 0) return "";
	
	String longest = s.substring(0, 1);
	for (int i = 0; i < n - 1; i++) {
		String p1 = expandAroundCenter(s, i, i);
		if (p1.length() > longest.length()){
			longest = p1;
		} 
		
		String p2 = expandAroundCenter(s, i, i + 1);
		if (p2.length() > longest.length()) {
			longest = p2;
		}
	}
	return longest;
}

public static String expandAroundCenter(String s, int c1, int c2) {
	int l = c1, r = c2;
	int n = s.length();
	while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
		l--;
		r++;
	}
	return s.substring(l + 1, r);
}