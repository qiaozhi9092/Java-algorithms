public static boolean find2DArray(int[][] matrix, int value) {
  int row = 0;
  int col = matrix[0].length - 1;

  while (row < matrix.length && col >= 0) {
    if (matrix[row][col] == value) {
      return true;
    }

    if (matrix[row][col] > value) 
      --col;
    else
      ++row;
  }

  return false;
}