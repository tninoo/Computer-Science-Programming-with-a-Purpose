public class Inversions {

  // Return the number of inversions in the permutation a[].
  public static long count(int[] a) {
    long count = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[i] > a[j]) count++;
      }
    }
    return count;
  }

  // Return a permutation of length n with exactly k inversions.
  public static int[] generate(int n, long k) {
    int[] array = new int[n];
    int counter = 1;
    long newk = k;
    if (k == ((long) n) * (n - 1) / 2) {
      for (int i = 0; i < n; i++) {
        array[i] = n - i - 1;
      }
      return array;
    }
    while (newk >= ((long) n) - counter) {
      array[counter - 1] = n - counter;
      newk = newk - n + counter;
      counter++;
    }
    int index = n - (int) newk - 1;
    array[index] = n - counter;
    for (int i = counter - 1; i < index; i++) {
      array[i] = i - counter + 1;
    }
    for (int i = index + 1; i < n; i++) {
      array[i] = i - counter;
    }
    return array;
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);

    int[] b = generate(n, k);

    for (int j = 0; j < b.length; j++) {
      StdOut.print(b[j] + " ");
    }
  }
}
