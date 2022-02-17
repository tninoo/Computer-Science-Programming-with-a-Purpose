public class ActivationFunction {

  public static double heaviside(double x) {
    if (Double.isNaN(x)) return Double.NaN;
    if (x < 0.0) return 0.0; else if (x == 0) return 0.5; else return 1.0;
  }

  public static double sigmoid(double x) {
    if (Double.isNaN(x)) return Double.NaN;
    return 1.0 / (1.0 + Math.exp(-x));
  }

  public static double tanh(double x) {
    if (Double.isNaN(x)) return Double.NaN;
    return (
      ((Math.exp(x) - Math.exp(-x)) / 2) / ((Math.exp(x) + Math.exp(-x)) / 2)
    );
  }

  public static double softsign(double x) {
    if (Double.isNaN(x)) return Double.NaN;
    return (x / (1 + Math.abs(x)));
  }

  public static double sqnl(double x) {
    if (Double.isNaN(x)) return Double.NaN;
    if (x <= -2.0) return -1.0; else if (x > -2.0 && x < 0) return (
      x + (Math.pow(x, 2) / 4)
    ); else if (x >= 0 && x < 2) return (
      x - (Math.pow(x, 2) / 4)
    ); else return 1.0;
  }

  public static void main(String[] args) {
    double x = Double.parseDouble(args[0]);
    System.out.println("heaviside(" + x + ") = " + heaviside(x));
    System.out.println("sigmoid(" + x + ")= " + sigmoid(x));
    System.out.println("tanh(" + x + ")= " + tanh(x));
    System.out.println("softsign(" + x + ")= " + softsign(x));
    System.out.println("sqnl(" + x + ")= " + sqnl(x));
  }
}
