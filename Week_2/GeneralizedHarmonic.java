public class GeneralizedHarmonic {
    public static void main(String[] args) {
     //args
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double harmonicNumber = 0;
        //loop
        for (int i = 1; i <= n; i++) {
    // https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/
            harmonicNumber += 1.0 / Math.pow(i, r);

        }
        System.out.println(harmonicNumber);
    }
}


