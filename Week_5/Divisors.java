public class Divisors {

  //returns the greatest common divisor of a and b
  public static int gcd(int a, int b) {
    if (a == 0 && b == 0) return 0; else if (b == 0) return Math.abs(a);
    int absoluteA = Math.abs(a);
    int absoluteB = Math.abs(b);
    while (absoluteA % absoluteB != 0) {
      int moveToLeft = absoluteA;
      absoluteA = absoluteB;
      absoluteB = moveToLeft % absoluteA;
    }
    return absoluteB;
  }

  //returns the least common multiple of a and b
  public static int lcm(int a, int b) {
    if (a == 0 || b == 0) return 0; else {
      int absoluteA = Math.abs(a);
      int absoluteB = Math.abs(b);

      return (absoluteA / gcd(a, b) * absoluteB);
    }
  }

  //returns true if a and b are relative prime  ; false other wise
  public static boolean areRelativelyPrime(int a, int b) {
    if (gcd(a, b) == 1) {
      return true;
    } else return false;
  }

  //returns the number of integers between 1 and n that are relatively prime with n
  public static int totient(int n) {
    if (n <= 0) return 0;
    int count = 0;

    for (int i = 0; i <= n; i++) {
      if (areRelativelyPrime(n, i)) count++;
    }
    return count;
  }

  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int totientA = totient(a);
    int totientB = totient(b);
    System.out.println("gcd(" + a + "," + b + ") = " + gcd(a, b));
    System.out.println("lcm(" + a + "," + b + ") = " + lcm(a, b));
    System.out.println(
      "areRelativelyPrime(" + a + "," + b + ") = " + areRelativelyPrime(a, b)
    );
    System.out.println("totient(" + a + ")= " + totientA);

    System.out.println("totient(" + b + ")= " + totientB);
  }
}
