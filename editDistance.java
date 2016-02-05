public static int getEditDistance(String s1, String s2) {
  int len1 = s1.length();
  int len2 = s2.length();
  
  int[][] distances = new int[len2][len1];
  
  for (int i = 0; i < len2; i++) {
    distances[i][0] = i;
  }
  
  for (int j = 0; j < len1; j++) {
    distances[0][j] = j;
  }
  
  for (int i = 1; i < len2; i++) {
    for (int j = 1; j < len1; j++) {
      if (s1.charAt(j) == s2.charAt(i)) {
        distances[i][j] = distances[i - 1][j - 1];
      } else {
        int deletion = distances[i][j - 1] + 1;
        int insertion = distances[i - 1][j] + 1;
        int substitution = distances[i - 1][j - 1] + 1;
        distances[i][j] = min(deletion, insertion, substitution);
      }
    }
  }
  
  return distances[len2 - 1][len1 - 1];
}

private static int min(int a, int b, int c) {
  int less = a < b ? a : b;
  return less < c ? less : c;
}
public static void main(String[] args) {
  String s1 = "Saturday";
  String s2 = "Sunday";
  
  System.out.println(getEditDistance(s1, s2));
}