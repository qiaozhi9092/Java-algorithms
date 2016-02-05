public static int getMinCount(int total, int[] coins){
  int[] counts = new int[total + 1];
  counts[0] = 0;
  
  for (int i = 1; i <= total; i++) {
    int count = Integer.MAX_VALUE;
    
    for (int j = 0; j < coins.length; j++) {
      if (i - coins[j] >= 0 && count > counts[i - coins[j]]) 
        count = counts[i - coins[j]];
        
      
      if (count < Integer.MAX_VALUE)
        counts[i] = count + 1;
      else 
        counts[i] = Integer.MAX_VALUE;
    }
  }
  return counts[total];
}  

public static void main(String[] args) {
  int[] coins = {1, 3, 9, 10};
  System.out.println(getMinCount(15, coins));
}