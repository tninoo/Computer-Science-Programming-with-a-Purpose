public class Birthday {

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);
    double[] counter = new double[n + 2];

    for (int i = 0; i < trials; i++) {
      boolean found = false;
      boolean[] twin = new boolean[n];
      int count = 0;
      while (!found) {
        double birthday = n * Math.random();
        int sameBirthday = (int) birthday;
        if (twin[sameBirthday]) {
          found = true;
          counter[count] += 1.0;
        } else {
          twin[sameBirthday] = true;
          count++;
        }
      }
    }
    double frac = 0.0;
    int i = 0;
    //
    while (frac < 0.5) {
      double dtrials = trials;
      frac += counter[i] / dtrials;
      System.out.println(i + 1 + "\t" + (int) counter[i] + "\t" + frac);
      i++;
    }
  }
}
