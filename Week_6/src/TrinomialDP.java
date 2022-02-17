public class TrinomialDP {

  public static long trinomial(int n, int k) {
    if ((k < -n) || (k > n)) return 0; else if (
      (n == 0) && (k == 0)
    ) return 1; else {
      long[][] tdp = new long[n + 1][n + 2];
      tdp[0][0] = 1;
      for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
          tdp[i][j] =
            tdp[i - 1][Math.abs(j - 1)] + tdp[i - 1][j] + tdp[i - 1][j + 1];
        }
      }
      return tdp[n][Math.abs(k)];
    }
  }

  // Takes two integer command-line arguments n and k and prints T(n, k).
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);
    StdOut.println(trinomial(n, k));
  }
}
