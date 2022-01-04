public class ThueMorse {

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int[] bits = new int[n];
    bits[0] = 0;

    for (int i = 1; i < n; i++) {
      if (i % 2 == 0) bits[i] = bits[i / 2]; else bits[i] = 1 - bits[i - 1];
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
          
        if (bits[i] == bits[j]) System.out.print("+  "); else System.out.print(
          "-  "
        );
      }
      System.out.println();
    }
  }
}
