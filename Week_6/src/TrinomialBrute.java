public class TrinomialBrute {

  // Returns the trinomial coefficient T(n, k).
  public static long trinomial(int n, int k) {
    if ((n == 0) && (k == 0)) return 1;
    if ((k < -n) || (k > n)) return 0;
    return (
      trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1)
    );
  }

  // Takes two integer command-line arguments n and k and prints T(n, k).
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);
    System.out.println(trinomial(n, k));
  }
}
// //n=3 k=2
// T(n−1,k−1)+T(n−1,k)+T(n−1,k+1)
// T(3-1, 2-1)+ T(3-1, 2)+ T(3-1, 2+1)
// T(2, 1) + T(2, 2) + T(2, 3)
// //the output is 3
// //n=3 k=1
// T(n−1,k−1)+T(n−1,k)+T(n−1,k+1)
// T(3-1, 1-1)+ T(3-1, 1)+ T(3-1, 1+1)
// T(2, 0) + T(2, 1) + T(2, 2)
// //n=2 k=0
// T(n−1,k−1)+T(n−1,k)+T(n−1,k+1)
// T(2-1, 0-1)+ T(2-1,0 )+ T(2-1, 1)
// T(2-1, -1)+ T(2-1,0 )+ T(2-1, 1)
