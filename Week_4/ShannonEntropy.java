public class ShannonEntropy {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        double h = 0;
        int[] count = new int[m + 1];
        int sequenceLength = 0;
        while (!StdIn.isEmpty()) {
            int j = StdIn.readInt();
            count[j] = count[j] + 1;
            sequenceLength += 1;
        }
 

        for (int i = 0; i < m + 1; i++) {
            
            double p = 1.0 * count[i] / sequenceLength;
            if (count[i] > 0)
                h -= p * Math.log(p) / Math.log(2);
        }

        System.out.print(h);
    }
}






