public static boolean regExp(String string, String pattern) {
  return regExpCore(string.toCharArray(), pattern.toCharArray(), 0, 0);
}

public static boolean regExpCore(char[] chars, char[] pattern, int cIndex, int pIndex) {
  if (cIndex == chars.length && pIndex == pattern.length) 
    return true;
  if (cIndex != chars.length && pIndex == pattern.length)
    return false;
  if (cIndex == chars.length && pIndex != pattern.length) 
    return false;
    
  if (pattern[pIndex] == '*') {
    return regExpCore(chars, pattern, cIndex + 1, pIndex) || regExpCore(chars, pattern, cIndex + 1, pIndex + 1) || regExpCore(chars, pattern, cIndex, pIndex + 1);
  } 
  
  if (chars[cIndex] == pattern[pIndex] || (pattern[pIndex] == '.' && cIndex != chars.length))
    return regExpCore(chars, pattern, cIndex + 1, pIndex + 1);
    
  return false;
}