public class DiscreteDistribution {

  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]);
    
    int[] s = new int[args.length];
    s[0] = 0;

    for (int i = 1; i < args.length; i++) {
      s[i] = Integer.parseInt(args[i]) + s[i - 1];
    }

    for (int i = 0; i < m; i++) {
      int r = (int) (Math.random() * (s[args.length - 1] - 1));
      int num = 0;
      while (s[num] <= r) {
        num++;
      }
      System.out.print(num + " ");
    }
  }
}
