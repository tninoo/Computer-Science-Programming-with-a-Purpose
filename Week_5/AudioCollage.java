public class AudioCollage {

  // Returns a new array that rescales a[] by a multiplicative factor of alpha.
  public static double[] amplify(double[] a, double alpha) {
    double[] amplify = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      amplify[i] = alpha * a[i];
    }
    return amplify;
  }

  // Returns a new array that is the reverse of a[].
  public static double[] reverse(double[] a) {
    double[] reverse = new double[a.length];
    int n = a.length;
    for (int i = n - 1; i >= 0; i--) {
      reverse[n - i - 1] = a[i];
    }
    return reverse;
  }

  // Returns a new array that is the concatenation of a[] and b[].
  public static double[] merge(double[] a, double[] b) {
    double[] merge = new double[a.length + b.length];

    for (int i = 0; i < a.length; i++) merge[i] = a[i];

    for (int i = 0; i < b.length; i++) merge[a.length + i] = b[i];

    return merge;
  }

  // Returns a new array that is the sum of a[] and b[],
  // padding the shorter arrays with trailing 0s if necessary.
  // public static double[] mix(double[] a, double[] b);

  // Returns a new array that changes the speed by the given factor.
  public static double[] changeSpeed(double[] a, double alpha) {
    int speed = (int) (a.length / alpha);
    double[] changeSpeed = new double[speed];
    for (int i = 0; i < speed; i++) {
      changeSpeed[i] = a[(int) (alpha * i)];
    }
    return changeSpeed;
  }

  public static void main(String[] args) {
    double alpha = 2.0;

    String audioA = "beatbox.wav";
    String audioB = "piano.wav";

    double[] a = StdAudio.read(audioA);
    double[] b = StdAudio.read(audioB);

    StdAudio.play(amplify(a, alpha));
    StdAudio.play(reverse(a));
    StdAudio.play(merge(a, b));
    // StdAudio.play(mix(a, b));
    StdAudio.play(changeSpeed(a, alpha));
  }
}
// public static double [] tone(double hz, double duration)
// {
//     int N =(int)(44100 * duration);
//     double []a = new double[N+1];
//     for (int i =0;i <=N; i++)
//     a[i] = Math.sin(2 * Math.PI * i * hz /44100);
//     return a;
// }
// public static void main(String[]args)
// {
//     double hz= Double.parseDouble(args[0]);
//     double duration = Double.parseDouble(args[1]);
//     double [] a =tone(hz, duration);
//     StdAudio.play(a);
// }}
