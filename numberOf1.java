int numberOf1(int n) {
  int count = 0;
  while (n != 0) {
    count++;
    n = (n - 1) & n;
  }
  return count;
}

int numberOf1_2(int n) {
  int count = 0;
  for (; n != 0; c = c >>> 1)
    count++;
    
  return count;
}