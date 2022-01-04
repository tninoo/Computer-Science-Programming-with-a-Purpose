public class Minesweeper {

  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);
    int k = Integer.parseInt(args[2]);

    boolean[][] mines = new boolean[m][n];
    int[][] gridCount = new int[m][n];
    // generate mines
    int row;
    int column;

    for (int i = 0; i < k; i++) {
      row = (int) (Math.random() * m);
      column = (int) (Math.random() * n);

      if (!mines[row][column]) {
        mines[row][column] = true;
        if (row > 0) gridCount[row - 1][column]++;
        if (column > 0) gridCount[row][column - 1]++;
        if (row < m - 1) gridCount[row + 1][column]++;
        if (column < n - 1) gridCount[row][column + 1]++;
        if (row > 0 && column > 0) gridCount[row - 1][column - 1]++;
        if (row > 0 && column < n - 1) gridCount[row - 1][column + 1]++;
        if (row < m - 1 && column > 0) gridCount[row + 1][column - 1]++;
        if (row < m - 1 && column < n - 1) gridCount[row + 1][column + 1]++;
      } else {
        i--;
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mines_grid[i][j]) System.out.print("*  "); else System.out.print(
          gridCount[i][j] + "  "
        );
      }
      System.out.println();
    }
  }
}
