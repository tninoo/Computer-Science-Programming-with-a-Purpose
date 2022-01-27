// public class Ramanujan {

//   // Is n a Ramanujan number?
//   public static boolean isRamanujan(long n) {
//     long count = 0;

//     for (long i = 0; i < Math.pow(n, 1 / 3.0); i++) {
//       for (long j = 1; j < n; j++) {
//         if (i * i * i + j * j * j == n) count++;
//       }
//     }
//     return count >= 2;
//   }

//   // there have to be 2 or more positive set of cubes to be a Ramanujan number

//   // Takes a long integer command-line arguments n and prints true if
//   // n is a Ramanujan number, and false otherwise.
//   public static void main(String[] args) {
//     long n = Long.parseLong(args[0]);
//     System.out.println(isRamanujan(n));
//   }
// }

public class Ramanujan {

  public static boolean isRamanujan(long n) {
    long nn = (long) Math.pow(n, 1. / 3);
    for (long a = 1; a <= nn; a++) {
      long A = a * a * a;
      long b = (long) Math.ceil(Math.pow(n - A, 1. / 3));
      if (A + b * b * b == n) {
        for (long c = a + 1; c <= nn; c++) {
          long C = c * c * c;
          long d = (long) Math.ceil(Math.pow(n - C, 1. / 3));
          if (C + d * d * d == n && a != d) return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    long n = Long.parseLong(args[0]);
    System.out.println(isRamanujan(n));
  }
}
